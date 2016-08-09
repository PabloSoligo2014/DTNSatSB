package org.baikal.dtnsat.controller;

import org.baikal.dtnsat.model.GroundStation;
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
		//Satellite sat = new Satellite("Completar aqui!");
		//modelMap.put("satellite", sat);
		return "Satellite/SatList";
	}
	
	
	@RequestMapping(value="delete/{id}")
	public String deleteSatellite(@PathVariable Long id,  ModelMap modelMap) {
		
		repo.delete(id);
		modelMap.put("satellites", repo.findAll());
		return "Satellite/SatList";

	}	
	
	@RequestMapping(value="view/{id}")
	public String viewSatellite(@PathVariable Long id,  ModelMap modelMap) {
		
		Satellite satellite = repo.findOne(id) ;
		modelMap.put("satellite", satellite);
		return "Satellite/SatForm";

	}	
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String editSatellite(@PathVariable Long id, ModelMap modelMap) {
		
		Satellite satellite = repo.findOne(id);		
		//repo.save(satellite);
		modelMap.put("satellite", satellite);
		return "Satellite/SatForm";
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newSatellite(ModelMap modelMap) {
		
		Satellite satellite = new Satellite();		
		//repo.save(satellite);
		modelMap.put("satellite", satellite);
		return "Satellite/SatForm";
	}
	
	@RequestMapping(value = "SatForm", method = RequestMethod.POST)
	public String SaveSatellite(Satellite satellite){
		
		//System.out.println(satellite.getOrbit().get);
        this.repo.save(satellite);
        //return "redirect:/product/" + product.getId();
        return "Satellite/SatList";
    }
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/fail")
	public void fail() {
	  throw new RuntimeException();
	}
	

}
