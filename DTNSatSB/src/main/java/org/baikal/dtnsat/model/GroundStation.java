package org.baikal.dtnsat.model;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.baikal.dtnsat.model.Node;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class GroundStation extends Node {
	
	@NotNull
    @Value("0")
    @DecimalMin("-90")
    @DecimalMax("90")
    private Double latitude;
	
	@NotNull
    @Value("0")
    @DecimalMin("-180")
    @DecimalMax("180")
    private Double longitude;
    
    @NotNull
    @Value("0")
    @DecimalMin("-200")
    @DecimalMax("8000")
    private Double altitude;
    
    public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}





	public GroundStation(String name, Double latitude, Double longitude, Double altitude) {
		super(name);
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	public GroundStation() {
		
		super();
	}

}
