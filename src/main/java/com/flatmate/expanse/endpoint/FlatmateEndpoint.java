/**
 * 
 */
package com.flatmate.expanse.endpoint;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import org.apache.commons.lang3.math.NumberUtils;
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

import com.flatmate.expanse.builder.AuthenticationBuilder;
import com.flatmate.expanse.builder.FlatmateBuilder;
import com.flatmate.expanse.dto.AuthenticationDto;
import com.flatmate.expanse.dto.FlatmateDto;
import com.flatmate.expanse.model.Authentication;
import com.flatmate.expanse.model.FlatMate;
import com.flatmate.expanse.service.AuthenticationService;
import com.flatmate.expanse.service.FlatmateService;
import com.flatmate.expanse.utils.CommonUtils;
import com.flatmate.expanse.validate.CommonValidator;

/**
 * @author Jitendra Sagoriya
 *
 */
@RestController
@RequestMapping(path = "/api/flatmate/", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE })
public class FlatmateEndpoint {

	@Value("${authenticate.salt}")
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

	@PostMapping(path = "add/", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addFlatmate(@RequestBody @Valid FlatMate flatMate) {
		return new ResponseEntity<FlatMate>(flatmateService.save(flatMate), HttpStatus.OK);

	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addFlatmate(@RequestBody FlatmateDto flatmateDto) {

		if (!NumberUtils.isNumber(flatmateDto.getPhoneNumber())) {
			return new ResponseEntity<String>("Phone number is not vaild",
					HttpStatus.PARTIAL_CONTENT);
		}
		
		if ( CommonUtils.isValidEmail(flatmateDto.getEmail())) {
			return new ResponseEntity<String>("Email is not vaild",
					HttpStatus.PARTIAL_CONTENT);
		}

		if ( flatmateService.checkEmail(flatmateDto.getEmail())) {
			return new ResponseEntity<String>("Email is already register. Please try with some other email",
					HttpStatus.PARTIAL_CONTENT);
		}

		if (flatmateService.checkNickname(flatmateDto.getNickName())) {
			return new ResponseEntity<String>("Nickname is already present. Please try with some other nickname",
					HttpStatus.PARTIAL_CONTENT);
		}
		
		FlatMate flatMate = new FlatmateBuilder(flatmateDto).build();

		Authentication authentication = new AuthenticationBuilder(flatmateDto, salt).build();

		CommonValidator<FlatMate> commonValidator = new CommonValidator<>();
		Set<ConstraintViolation<FlatMate>> violations = commonValidator.validate(flatMate);

		if (!violations.isEmpty()) {
			return new ResponseEntity<>(violations, HttpStatus.PARTIAL_CONTENT);
		}
		
		

		try {
			flatMate = flatmateService.save(flatMate);
			if (flatMate.getId() != null) {
				authentication.setFlatmateId(flatMate.getId());
				authenticationService.save(authentication);
			}

			AuthenticationDto authenticationDto = new AuthenticationDto(flatMate.getName(),
					authentication.getAccessToken(), authentication.getTokenTimeout());

			return new ResponseEntity<AuthenticationDto>(authenticationDto, HttpStatus.OK);
		} catch (DbException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> modifyFlatmate(@RequestBody @Valid FlatMate flatMate) {
		return new ResponseEntity<FlatMate>(flatmateService.save(flatMate), HttpStatus.OK);

	}

	@DeleteMapping({"id"})
	public ResponseEntity<?> modifyFlatmate(@PathVariable Long id) {
		try {
			flatmateService.deleteById(id);
			return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
