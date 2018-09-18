/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */

package com.pk.hibernate.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
