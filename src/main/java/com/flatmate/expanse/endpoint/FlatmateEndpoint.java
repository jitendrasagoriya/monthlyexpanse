/**
 * 
 */
package com.flatmate.expanse.endpoint;

import java.sql.Timestamp;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.h2.message.DbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flatmate.expanse.dao.AuthenticationDao;
import com.flatmate.expanse.dao.FlatmateDao;
import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.model.FlatMate;
import com.flatmate.expanse.password.PasswordUtils;
import com.flatmate.expanse.service.AuthenticationService;
import com.flatmate.expanse.service.FlatmateService;
import com.flatmate.expanse.tokengenerator.SecureTokenGenerator;

/**
 * @author lenovo
 *
 */
@RestController
@RequestMapping(path = "/api/flatmate/",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
public class FlatmateEndpoint {

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	private Validator validator = factory.getValidator();
	
	@Value( "${authenticate.salt}" )
	private String salt;
	
	
	@Autowired
	private FlatmateService flatmateService;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping({ "id" })
	public ResponseEntity<?> get(@PathVariable Long id) {
		return new ResponseEntity<>(flatmateService.findById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(flatmateService.findAll(pageable), HttpStatus.OK);
	}

	@PostMapping(path="add/",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addFlatmate(@RequestBody @Valid FlatMate flatMate) {
		return new ResponseEntity<FlatMate>(flatmateService.save(flatMate), HttpStatus.OK);

	}

	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addFlatmate(@RequestBody com.flatmate.expanse.dto.FlatmateDto flatmateDto) {

		FlatMate flatMate = new FlatMate();
		flatMate.setEmail(flatmateDto.getEmail());
		flatMate.setName(flatmateDto.getName());
		flatMate.setNickName(flatmateDto.getNickName());
		flatMate.setPhoneNumber(flatmateDto.getPhoneNumber());
		flatMate.setJoingDate(new Timestamp(System.currentTimeMillis()));
		
		

		Authentication authentication = new Authentication();
		authentication.setAccessToken(SecureTokenGenerator.getToken(flatmateDto.getEmail()));
		authentication.setLastLogin(new Timestamp(System.currentTimeMillis()));
		authentication.setPassword( PasswordUtils.generateSecurePassword(flatmateDto.getPassword(), salt) );
		authentication.setTokenTimeout((long) (30 * 60000));
		authentication.setUserName(flatmateDto.getEmail());
		
		Set<ConstraintViolation<FlatMate>> violations = validator.validate(flatMate);
		if(! violations.isEmpty()) {
			return new ResponseEntity<>(violations, HttpStatus.OK);
		}

		try {
			flatMate = flatmateService .save(flatMate);
			if (flatMate.getId() != null) {
				authentication.setFlatmateId(flatMate.getId());
				authenticationService.save(authentication);
			}

			AuthenticationDto authenticationDto = new AuthenticationDto(flatMate.getName(),
					authentication.getAccessToken(), authentication.getTokenTimeout());
			
			return new ResponseEntity<AuthenticationDto>(authenticationDto, HttpStatus.OK);
		}catch (DbException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		

	}

	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> modifyFlatmate(@RequestBody @Valid FlatMate flatMate) {
		return new ResponseEntity<FlatMate>(flatmateService.save(flatMate), HttpStatus.OK);

	}

	@DeleteMapping({ "id" })
	public ResponseEntity<?> modifyFlatmate(@PathVariable Long id) {
		try {
			flatmateService.deleteById(id);
			return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
