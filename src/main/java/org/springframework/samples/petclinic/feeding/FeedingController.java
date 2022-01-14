package org.springframework.samples.petclinic.feeding;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.game.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {
	
	@Autowired
	private FeedingService feedingService;
	
	
	private static final String VIEW_PRODUCT_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";
    
	@GetMapping(path = "/create")
	public String initCreationForm(ModelMap modelMap) {
		String view = VIEW_PRODUCT_CREATE_OR_UPDATE_FORM;
		
		modelMap.addAttribute("feeding", new Feeding());
		modelMap.addAttribute("feedingType", feedingService.getAllFeedingTypes());
		return view;
	}
}
