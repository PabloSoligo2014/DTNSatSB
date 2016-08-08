package org.baikal.dtnsat.model;


import java.util.*;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Simulation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Date creationDate;
	private Date startDate;
	private Date endDate;
	
	public Simulation(Date startDate) {
		super();
		//this.id = id;
		this.creationDate = new Date();
		this.startDate = startDate;
		this.endDate = new Date();
	}
	
	
	protected Simulation() {
		super();
		// PARA JPA
	}
	
	@Override
    public String toString() {
        return String.format(
                "Simulation[id=%d, start date='%s', end date='%s']",
                this.id, this.startDate, this.endDate);
    }



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

}
