package com.flatmate.expanse.builder;

import java.sql.Timestamp;

import com.flatmate.expanse.dto.FlatmateDto;
import com.flatmate.expanse.model.FlatMate;

public class FlatmateBuilder {
	
	private FlatMate flatMate;

	/**
	 * @param flatMate
	 */
	public FlatmateBuilder() {
		this.flatMate = new FlatMate();
	}
	
	public FlatmateBuilder(FlatmateDto flatmateDto) {
		this.flatMate = new FlatMate();
		this.flatMate.setEmail(flatmateDto.getEmail());
		this.flatMate.setName(flatmateDto.getName());
		this.flatMate.setNickName(flatmateDto.getNickName());
		this.flatMate.setPhoneNumber(flatmateDto.getPhoneNumber());
		this.flatMate.setJoingDate(new Timestamp(System.currentTimeMillis()));
	}

	public FlatMate build() {
		return this.flatMate;
	}
	
}
