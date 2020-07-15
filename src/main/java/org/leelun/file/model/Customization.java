package org.leelun.file.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Customization {

	private Goback goback;

	public Customization() {
		goback = new Goback();
	}

	public Goback getGoback() {
		return goback;
	}

	public void setGoback(Goback goback) {
		this.goback = goback;
	}

	@JsonInclude(Include.NON_NULL)
	public class Goback {
		
		private String url;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
		
	}
}
