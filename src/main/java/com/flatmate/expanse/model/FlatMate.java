/**
 * 
 */
package com.flatmate.expanse.model;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * @author jitendra Sagroiya
 *
 */
@Entity
@Table(name="FLATMATE")
public class FlatMate implements Serializable {	
	 
	private static final long serialVersionUID = -3374257955428863643L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	@NotNull
	private String Name;
	
	@Column(name="NICKNAME")
	@NotNull
	private String nickName;
	
	
	@Column(name="EMAIL")
	@NotNull
	private String email;
	
	@Column(name="PHONE")
	@NotNull
	private String phoneNumber;
	
	
	@Column(name="JOININGDATE") 
	private Timestamp joingDate;

	/**
	 * 
	 */
	public FlatMate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param nickName
	 * @param email
	 * @param phoneNumber
	 * @param joingDate
	 */
	public FlatMate(Long id, String name, String nickName, String email, String phoneNumber, Timestamp joingDate) {
		super();
		this.id = id;
		Name = name;
		this.nickName = nickName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.joingDate = joingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getJoingDate() {
		return joingDate;
	}

	public void setJoingDate(Timestamp joingDate) {
		this.joingDate = joingDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joingDate == null) ? 0 : joingDate.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlatMate other = (FlatMate) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joingDate == null) {
			if (other.joingDate != null)
				return false;
		} else if (!joingDate.equals(other.joingDate))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlatMate [id=" + id + ", Name=" + Name + ", nickName=" + nickName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", joingDate=" + joingDate + "]";
	} 
	
	
	

}
