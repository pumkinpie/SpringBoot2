package com.tts.subscriberlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.subscriberlist.Subscriber;

@Controller
public class SubscriberController {

@Autowired	
private SubscriberRepository subscriberRepository;

@GetMapping(value= "/")	
	public String index(Subscriber subscriber) {
		return "index";
	}
private Subscriber subscriber;

@PostMapping(value = "/")

// this method will post the info to the database and display a "confirmation" on a new template "result"
public String addNewSubscriber(Subscriber Subscriber, Model model) {
	Subscriber.save(new Subscriber(Subscriber.getFirstName(), 
        Subscriber.getLastName(), Subscriber.getSignedUp()));
	model.addAttribute("firstName", subscriber.getFirstName());
	model.addAttribute("lastName", subscriber.getLastName());
	model.addAttribute("signedUp", subscriber.getSignedUp());
	return "result";

}

public Subscriber getSubscriber() {
	return subscriber;
}

public void setSubscriber(Subscriber subscriber) {
	this.subscriber = subscriber;
}
}
