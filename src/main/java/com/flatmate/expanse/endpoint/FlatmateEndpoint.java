/**
 * 
 */
package com.flatmate.expanse.endpoint;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.model.FlatMate;
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

	@Autowired
	private FlatmateService service;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping({ "id" })
	public ResponseEntity<?> get(@PathVariable Long id) {
		return new ResponseEntity<>(service.getRepository().findById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getAll(Pageable pageable) {
		return new ResponseEntity<>(service.getRepository().findAll(pageable), HttpStatus.OK);
	}

	@PostMapping(path="add/",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addFlatmate(@RequestBody @Valid FlatMate flatMate) {
		return new ResponseEntity<FlatMate>(service.getRepository().save(flatMate), HttpStatus.OK);

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
		authentication.setPassword(flatmateDto.getPassword());
		authentication.setTokenTimeout((long) (30 * 60000));
		authentication.setUserName(flatmateDto.getEmail());

		try {
			flatMate = service.getRepository().save(flatMate);
			if (flatMate.getId() != null) {
				authentication.setFlatmateId(flatMate.getId());
				authenticationService.getRepository().save(authentication);
			}

			AuthenticationDto authenticationDto = new AuthenticationDto(flatMate.getName(),
					authentication.getAccessToken(), authentication.getTokenTimeout());
			
			return new ResponseEntity<AuthenticationDto>(authenticationDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.OK);
		}

		

	}

	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> modifyFlatmate(@RequestBody @Valid FlatMate flatMate) {
		return new ResponseEntity<FlatMate>(service.getRepository().save(flatMate), HttpStatus.OK);

	}

	@DeleteMapping({ "id" })
	public ResponseEntity<?> modifyFlatmate(@PathVariable Long id) {
		try {
			service.getRepository().deleteById(id);
			return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
