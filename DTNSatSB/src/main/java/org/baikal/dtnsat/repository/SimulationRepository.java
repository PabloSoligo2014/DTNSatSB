package org.baikal.dtnsat.repository;

import java.util.*;
import java.util.Date;

import org.baikal.dtnsat.model.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface  SimulationRepository extends JpaRepository<Simulation, Long> {
	
	List<Simulation> findById(long Id);

}

/*
public class SimulationRepository {
	public Simulation mfind(){
		return new Simulation(new Date());
	}
	
	public List<Simulation> mfindAll(){
		List<Simulation> result = new ArrayList<Simulation>();
		result.add(new Simulation(new Date()));
		result.add(new Simulation(new Date()));
		return result;
		
	}
	

}
*/
