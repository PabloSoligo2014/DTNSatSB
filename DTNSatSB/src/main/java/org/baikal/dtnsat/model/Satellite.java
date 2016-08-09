package org.baikal.dtnsat.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.baikal.dtnsat.model.Orbit;

@Entity
public class Satellite extends Node {
	public String noradId;
	
	//@OneToOne(orphanRemoval=true)
	 
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) //<or> @OneToOne(cascade=CascadeType.ALL) <-- for all operation
    private Orbit orbit;
	
	public Orbit getOrbit() {
		return orbit;
	}

	public void setOrbit(Orbit orbit) {
		this.orbit = orbit;
		
	}

	public Satellite(){
		super();
		this.orbit = new Orbit(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		this.setCreationDate(new Date());
	}
	
	public Satellite(String name){
		super(name);
		this.orbit = new Orbit(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		this.setCreationDate(new Date());
		
	}
	
	public Satellite(String name, Double eccentricity, Double semimajorAxis, Double inclination, Double longitudeAscendingNode,
			Double argumentPeriapsis, Double meanAnomaly){
		super(name);
		this.orbit = new Orbit(eccentricity, semimajorAxis, inclination, longitudeAscendingNode, argumentPeriapsis, meanAnomaly);
		this.setCreationDate(new Date());
		
	}
	
	public String getNoradId() {
		return noradId;
	}

	public void setNoradId(String noradId) {
		this.noradId = noradId;
	}
	
	
	
}
