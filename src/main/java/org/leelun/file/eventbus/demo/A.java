package org.leelun.file.eventbus.demo;

import org.leelun.file.eventbus.handle.EventContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class A {
	
	private static final Logger log = LoggerFactory.getLogger(A.class);
	
	public void login() {
		log.info("执行登录操作");
		EventContainer.handleEvent(LoginEvent.class);
	}
	
}
