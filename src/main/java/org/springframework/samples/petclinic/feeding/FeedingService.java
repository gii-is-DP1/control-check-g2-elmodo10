package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetRepository;
import org.springframework.stereotype.Service;


@Service
public class FeedingService {
	
	@Autowired
	private FeedingRepository feedingRepository;
	
	
	
    public List<Feeding> getAll(){
    	List<Feeding> f = feedingRepository.findAll();
        return f;
    }

    public List<FeedingType> getAllFeedingTypes(){
    	List<FeedingType> ft = feedingRepository.findAllFeedingTypes();
        return ft;
    }

    public FeedingType getFeedingType(String typeName) {
    	FeedingType feedingType = feedingRepository.getFeedingType(typeName);
        return feedingType;
    }

    public void save(Feeding f) {
       feedingRepository.save(f);       
    }

    
}
