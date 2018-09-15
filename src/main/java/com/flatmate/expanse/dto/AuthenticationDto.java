package com.flatmate.expanse.dto;

public class AuthenticationDto {

	private String flatmate;
	
	private String accessToken;
	
	private Long timeout;

	/**
	 * 
	 */
	public AuthenticationDto() {
		super();
	}

	/**
	 * @param flatmate
	 * @param accessToken
	 * @param timeout
	 */
	public AuthenticationDto(String flatmate, String accessToken, Long timeout) {
		super();
		this.flatmate = flatmate;
		this.accessToken = accessToken;
		this.timeout = timeout;
	}

	public String getFlatmate() {
		return flatmate;
	}

	public void setFlatmate(String flatmate) {
		this.flatmate = flatmate;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
		result = prime * result + ((flatmate == null) ? 0 : flatmate.hashCode());
		result = prime * result + ((timeout == null) ? 0 : timeout.hashCode());
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
		AuthenticationDto other = (AuthenticationDto) obj;
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		if (flatmate == null) {
			if (other.flatmate != null)
				return false;
		} else if (!flatmate.equals(other.flatmate))
			return false;
		if (timeout == null) {
			if (other.timeout != null)
				return false;
		} else if (!timeout.equals(other.timeout))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthenticationDto [flatmate=" + flatmate + ", accessToken=" + accessToken + ", timeout=" + timeout
				+ "]";
	}
	
	
}
