package com.learn.spring.service.v5;


import com.learn.spring.beans.factory.annotation.Autowired;
import com.learn.spring.dao.v5.AccountDao;
import com.learn.spring.dao.v5.ItemDao;
import com.learn.spring.stereotype.Component;
import com.learn.spring.util.MessageTracker;

@Component(value="petStore")
public class PetStoreService {		
	@Autowired
    AccountDao accountDao;
	@Autowired
    ItemDao itemDao;
	
	public PetStoreService() {		
		
	}
	
	public ItemDao getItemDao() {
		return itemDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}
	
	public void placeOrder(){
		System.out.println("place order");
		MessageTracker.addMsg("place order");
		
	}	
	public void placeOrderWithException(){
		throw new NullPointerException();
	}
}
