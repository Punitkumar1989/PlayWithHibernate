/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */

package com.pk.hibernate.learn.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue
	private int userId;
	// @Transient  /* Wont allow to persist the field. */
	private String userName;
	//@Temporal(TemporalType.DATE)   /* Get the Date */
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride(name="city",column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride(name="pinCode",column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
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
