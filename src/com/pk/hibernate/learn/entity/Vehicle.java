package com.pk.hibernate.learn.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="VEHICLE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
//	@ManyToOne
//	@NotFound(action=NotFoundAction.IGNORE)


	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
