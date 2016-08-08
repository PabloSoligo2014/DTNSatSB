package org.baikal.dtnsat.controller;

import org.baikal.dtnsat.model.Satellite;
import org.baikal.dtnsat.repository.SatelliteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("Satellite")
public class SatelliteController {
	
	private SatelliteRepository repo;
	
	@Autowired 
	public SatelliteController(SatelliteRepository satelliteRepository){
		this.repo = satelliteRepository;
	}
	
	@RequestMapping(value="SatList", method = RequestMethod.GET)
	public String SatList(ModelMap modelMap){
		
		modelMap.put("satellites", repo.findAll());
		Satellite sat = new Satellite("Completar aqui!");
		modelMap.put("satellite", sat);
		return "Satellite/SatList";
	}
	
	@RequestMapping(value="SatList", method=RequestMethod.POST)
	public String addSatellite(@ModelAttribute Satellite satellite, ModelMap modelMap) {
		//satellite.setName(name);
		//satellite.setName("default");
		
		repo.save(satellite);
		modelMap.put("satellite", satellite);
		
		return "Satellite/Result";
		//return "redirect:/";	
		//return "Satellite/SatList";
	}	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/fail")
	public void fail() {
	  throw new RuntimeException();
	}
	

}
