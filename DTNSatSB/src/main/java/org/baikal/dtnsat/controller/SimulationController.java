package org.baikal.dtnsat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

import org.baikal.dtnsat.model.*;
import org.baikal.dtnsat.repository.SimulationRepository;

@Controller
@RequestMapping("Simulation")
public class SimulationController {
	
	private SimulationRepository repo;
	
	@Autowired 
	public SimulationController(SimulationRepository simulationRepository){
		this.repo = simulationRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String Index(){
		return "Simulation/Index";
	}
	
	@RequestMapping(value="Detail", method = RequestMethod.GET)
	public String Detail(ModelMap modelMap){
		
		modelMap.put("clave1", "valor1");
		modelMap.put("clave2", "valor2");
		
		return "Simulation/Detail";
	}
	
	@RequestMapping(value="SimDetail", method = RequestMethod.GET)
	public String SimDetail(ModelMap modelMap){
		//SimulationRepository repo = new SimulationRepository();
		Simulation sim = new Simulation(new Date());
		//List<Simulation> sims = repo.findById(0);
		repo.save(sim);
		modelMap.put("simulation", sim);
		

		
		return "Simulation/SimDetail";
	}
	
	@RequestMapping(value="SimList", method = RequestMethod.GET)
	public String SimList(ModelMap modelMap){
		//SimulationRepository repo = new SimulationRepository();
		modelMap.put("simulationList", repo.findAll());
		

		
		return "Simulation/SimList";
	}
}
