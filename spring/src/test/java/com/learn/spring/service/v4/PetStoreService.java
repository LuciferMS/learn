package com.learn.spring.service.v4;

import com.learn.spring.beans.factory.annotation.Autowired;
import com.learn.spring.dao.v4.AccountDao;
import com.learn.spring.dao.v4.ItemDao;
import com.learn.spring.stereotype.Component;

@Component(value="petStore")
public class PetStoreService {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao itemDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}
	
	
}