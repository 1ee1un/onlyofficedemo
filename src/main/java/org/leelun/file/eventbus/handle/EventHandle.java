package org.leelun.file.eventbus.handle;

import java.util.Objects;

import org.leelun.file.eventbus.annatation.Subscribe;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * 	事件处理
 * 	扫描类里面加有事件注解标记的类  加入事件容器中
 * @author leelun
 * @date 2020年6月30日
 *
 */
@Component
public class EventHandle extends InstantiationAwareBeanPostProcessorAdapter {

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		ReflectionUtils.doWithLocalMethods(bean.getClass(), method -> {
			Subscribe subscribe = method.getAnnotation(Subscribe.class);
			if (Objects.isNull(subscribe)) {
				return ;
			}
			EventContainer.addEvent(subscribe.cls(), method, bean);
		});
		return super.postProcessAfterInstantiation(bean, beanName);
	}
	
}
