/*
 * @Author - Punit Kumar
 * @Email - punit.kumar1989@gmail.com
 */

package com.pk.hibernate.learn.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	// @Transient /* Wont allow to persist the field. */
	private String userName;
	// @Temporal(TemporalType.DATE) /* Get the Date */
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	
	/* Code for adding the keys in collection object as well as a sequence generator.
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 
	 "seq_generator") /* Use this line code or next line code it will result
	 same 
	@GenericGenerator(name = "seq_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "seq_generator", type = @Type(type = "long"))
	
	*/
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	// private Set<Address> listOfAddress = new HashSet<Address>();

	public int getUserId() {
		return userId;
	}

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
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
