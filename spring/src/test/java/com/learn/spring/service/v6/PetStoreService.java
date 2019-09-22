package com.learn.spring.service.v6;


import com.learn.spring.stereotype.Component;
import com.learn.spring.util.MessageTracker;

@Component(value="petStore")
public class PetStoreService implements IPetStoreService {
	
	public PetStoreService() {		
		
	}
	
	public void placeOrder(){
		System.out.println("place order");
		MessageTracker.addMsg("place order");
	}
	
	
	
}
