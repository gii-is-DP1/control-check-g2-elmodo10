package org.springframework.samples.petclinic.feeding;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {
	
	@Autowired
	private FeedingService feedingService;
	
	
	private static final String VIEW_PRODUCT_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";
    
	@GetMapping(path = "/create")
	public String initCreationForm(@Valid Feeding feeding , BindingResult result, ModelMap modelMap) {
		String view = "welcome";
		if(result.hasErrors()) {
			modelMap.addAttribute("feeding", new Feeding());
			modelMap.addAttribute("feedingType", feedingService.getAllFeedingTypes());
			return VIEW_PRODUCT_CREATE_OR_UPDATE_FORM;
			
		} else {
			feedingService.save(feeding);
			modelMap.addAttribute("message", "feeding succesfully saved!");
		}
		return view;
				
		
		
	}
}
