package org.leelun.file.eventbus.handle;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.leelun.file.eventbus.IEvent;
import org.leelun.file.eventbus.model.MethodInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * 	事件容器   存放事件
 * 	
 * @author leelun
 * @date 2020年6月30日
 *
 */
public class EventContainer {
	
	private static final Logger log = LoggerFactory.getLogger(EventContainer.class);
	
	private static Map<Class<? extends IEvent>, List<MethodInfo>> container = new ConcurrentHashMap<>();
	
	/**
	 * 	提交事件到容器
	 * @param cls
	 * @param method
	 * @param object
	 */
	public static void addEvent(Class<? extends IEvent> cls,Method method,Object object) {
		MethodInfo methodInfo = new MethodInfo(method,object);
		List<MethodInfo> infos = container.get(cls);
		if (CollectionUtils.isEmpty(infos)) {
			infos = new ArrayList<MethodInfo>();
		}
		infos.add(methodInfo);
		container.put(cls, infos);
	}
	
	/**
	 * 	处理事件
	 * @param cls
	 */
	public static void handleEvent(Class<? extends IEvent> cls) {
		List<MethodInfo> infos = container.get(cls);
		if (CollectionUtils.isEmpty(infos)) {
			return ;
		}
		for (MethodInfo methodInfo : infos) {
			try {
				Method method = methodInfo.getMethod();
				method.setAccessible(true);
				Object object = methodInfo.getObject();
				method.invoke(object);
			} catch (Exception e) {
				log.error("执行事件方法失败",e);
			}
		}
	}
	
}
