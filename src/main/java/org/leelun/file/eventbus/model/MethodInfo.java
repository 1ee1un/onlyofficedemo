package org.leelun.file.eventbus.model;

import java.lang.reflect.Method;

public class MethodInfo {

	private Method method;
	
	private Object object;
	
	public MethodInfo(Method method, Object object) {
		super();
		this.method = method;
		this.object = object;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
