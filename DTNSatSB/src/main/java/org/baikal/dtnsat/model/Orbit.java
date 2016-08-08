package org.baikal.dtnsat.model;

import java.util.*;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.io.File;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import org.orekit.data.DataProvidersManager;
import org.orekit.data.DirectoryCrawler;
import org.orekit.errors.OrekitException;
import org.orekit.propagation.SpacecraftState;
import org.orekit.propagation.analytical.KeplerianPropagator;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScale;
import org.orekit.time.TimeScalesFactory;
import org.orekit.time.UTCScale;



@Entity
public class Orbit {
    /**
     * e
     */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    @NotNull
    @Value("0.5")
    @DecimalMin("0.0")
    @DecimalMax("0.99")
    private Double eccentricity;
    
    /**
     * a
     */
    @NotNull
    @Value("0")
    @DecimalMin("0")
    @DecimalMax("100000")
    private Double semimajorAxis;
    
    /**
     * i
     */
    @NotNull
    @Value("0")
    @DecimalMin("0")
    @DecimalMax("100000")
    private Double inclination;
    
    
    /**
     * raan
     */
    @NotNull
    @Value("0")
    @DecimalMin("0")
    @DecimalMax("100000")
    private Double longitudeAscendingNode;
    
    /**
     * omega
     */
    @NotNull
    @Value("0")
    @DecimalMin("0")
    @DecimalMax("100000")
    private Double argumentPeriapsis;
    
    /**
     * Ml
     */
    @NotNull
    @Value("0")
    @DecimalMin("0")
    @DecimalMax("100000")
    private Double meanAnomaly;
    
    @Transient
    private KeplerianPropagator propagator;	



    public Orbit(Double eccentricity, Double semimajorAxis, Double inclination, Double longitudeAscendingNode,
			Double argumentPeriapsis, Double meanAnomaly) {
		super();
		
		
		File orekitData = new File("./data/");
		DataProvidersManager mmanager = DataProvidersManager.getInstance();
		try {
			mmanager.addProvider(new DirectoryCrawler(orekitData) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.eccentricity = eccentricity;
		this.semimajorAxis = semimajorAxis;
		this.inclination = inclination;
		this.longitudeAscendingNode = longitudeAscendingNode;
		this.argumentPeriapsis = argumentPeriapsis;
		this.meanAnomaly = meanAnomaly;
	}

	public Orbit(){
    	super();
    	File orekitData = new File("./data/");
		DataProvidersManager mmanager = DataProvidersManager.getInstance();
		try {
			mmanager.addProvider(new DirectoryCrawler(orekitData) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public SpacecraftState getCurrentState(AbsoluteDate date) throws Exception{
		TimeScale utc;
		utc = TimeScalesFactory.getUTC();
		if(date==null){
		 date  = new AbsoluteDate(new Date(), utc);
		}
		
		SpacecraftState currentState;
		try {
			
			currentState = this.propagator.propagate(date);
			return currentState;
		
		} catch (Exception e) {
			//	 TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception(e);
		}
		
	}
}
