package org.leelun.file.eventbus.demo;

import org.leelun.file.eventbus.annatation.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class B {

	private static final Logger log = LoggerFactory.getLogger(B.class);

	@Subscribe(cls = LoginEvent.class)
	public void listenLogin() {
		log.info("监听到登陆事件");
	}
}
