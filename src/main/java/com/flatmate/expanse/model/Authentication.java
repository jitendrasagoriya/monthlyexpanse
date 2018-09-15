package com.flatmate.expanse.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="AUTHENTICATION")
public class Authentication implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="USERNAME",length=100)
	@NotNull
	@Id
	private String userName;
	
	@Column(name="PASSWORD",length=100) 
	private String password;
	
	@Column(name="LASTLOGIN")
	private Timestamp lastLogin;
	
	@Column(name="ACCESSTOKEN",length=100,unique=true)	 
	private String accessToken;

	// In millisecond
	@Column(name="TIMEOUT")
	private Long tokenTimeout;
	
	
	@Column(name="FID")
	private Long flatmateId;

	/**
	 * 
	 */
	public Authentication() {
		super();
	}

	/**
	 * @param userName
	 * @param password
	 * @param lastLogin
	 * @param accessToken
	 * @param tokenTimeout
	 */
	public Authentication(@NotNull String userName, String password, Timestamp lastLogin, String accessToken,
			Long tokenTimeout) {
		super();
		this.userName = userName;
		this.password = password;
		this.lastLogin = lastLogin;
		this.accessToken = accessToken;
		this.tokenTimeout = tokenTimeout;
	}
	

	/**
	 * @param userName
	 * @param password
	 * @param lastLogin
	 * @param accessToken
	 * @param tokenTimeout
	 * @param flatmateId
	 */
	public Authentication(@NotNull String userName, String password, Timestamp lastLogin, String accessToken,
			Long tokenTimeout, Long flatmateId) {
		super();
		this.userName = userName;
		this.password = password;
		this.lastLogin = lastLogin;
		this.accessToken = accessToken;
		this.tokenTimeout = tokenTimeout;
		this.flatmateId = flatmateId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getTokenTimeout() {
		return tokenTimeout;
	}

	public void setTokenTimeout(Long tokenTimeout) {
		this.tokenTimeout = tokenTimeout;
	}

	public Long getFlatmateId() {
		return flatmateId;
	}

	public void setFlatmateId(Long flatmateId) {
		this.flatmateId = flatmateId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
		result = prime * result + ((flatmateId == null) ? 0 : flatmateId.hashCode());
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tokenTimeout == null) ? 0 : tokenTimeout.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Authentication other = (Authentication) obj;
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		if (flatmateId == null) {
			if (other.flatmateId != null)
				return false;
		} else if (!flatmateId.equals(other.flatmateId))
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tokenTimeout == null) {
			if (other.tokenTimeout != null)
				return false;
		} else if (!tokenTimeout.equals(other.tokenTimeout))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authentication [userName=" + userName + ", password=" + password + ", lastLogin=" + lastLogin
				+ ", accessToken=" + accessToken + ", tokenTimeout=" + tokenTimeout + ", flatmateId=" + flatmateId
				+ "]";
	}
	
	
}
