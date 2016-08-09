package org.baikal.dtnsat.controller;


import java.nio.channels.FileChannel.MapMode;

import org.baikal.dtnsat.model.GroundStation;
import org.baikal.dtnsat.repository.GroundStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("GroundStation")
public class GroundStationController {

	private GroundStationRepository repo;
	
	@Autowired 
	public GroundStationController(GroundStationRepository groundStationRepository){
		this.repo = groundStationRepository;
	}
	
	@RequestMapping(value="GroundStationList", method = RequestMethod.GET)
	public String GroundStationList(ModelMap modelMap){		
		modelMap.put("groundStations", repo.findAll());
		//GroundStation gs = new GroundStation();
		//modelMap.put("satellite", sat);
		return "GroundStation/GroundStationList";
	}
	
	@RequestMapping(value="GroundStationForm", method = RequestMethod.GET)
	public String GroundStationForm(ModelMap modelMap){
		GroundStation gs = new GroundStation();
		modelMap.put("groundStation", gs);
		return "GroundStation/GroundStationForm";
	}
	
    // Afficher le formulaire de modification du Product
    @RequestMapping(value="GroundStation/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id,  ModelMap modelMap){
    	GroundStation gs = repo.findOne(id);
    	System.out.println("Ground station encontrada: "+gs.getId());
    	modelMap.put("groundStation", gs);
    	return "GroundStation/GroundStationForm";
    }
	
    // Producto agregado o modificado
    @RequestMapping(value = "GroundStationForm", method = RequestMethod.POST)
    public String saveGroundStation(GroundStation gs){
        this.repo.save(gs);
        //return "redirect:/product/" + product.getId();
        return "GroundStation/GroundStationList";
    }
	

    /*
    // Afficher le formulaire de modification du Product
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    // Afficher le formulaire d'ajout du Product
    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    // Sauvegarder ou modifier un Product
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

    // Supprimer un produit
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

	*/

}
