package com.learn.spring.context.support;

import com.learn.spring.core.io.FileSystemResource;
import com.learn.spring.core.io.Resource;

/**
 * 从文件系统中获取bean
 * @author Ellito
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

	public FileSystemXmlApplicationContext(String path) {
		super(path);		
	}

	@Override
	protected Resource getResourceByPath(String path) {
		return new FileSystemResource(path);
	}	

}
