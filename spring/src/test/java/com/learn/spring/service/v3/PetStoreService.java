package com.learn.spring.service.v3;

import com.learn.spring.dao.v3.AccountDao;
import com.learn.spring.dao.v3.ItemDao;

public class PetStoreService {
	
	private AccountDao accountDao;
	private ItemDao  itemDao;
	private int version;
	
	public PetStoreService(AccountDao accountDao, ItemDao itemDao){
		this.accountDao = accountDao;
		this.itemDao = itemDao;
		this.version = -1;
	}
	public PetStoreService(AccountDao accountDao, ItemDao itemDao,int version){
		this.accountDao = accountDao;
		this.itemDao = itemDao;
		this.version = version;
	}
	public int getVersion() {
		return version;
	}
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}
	
	
}