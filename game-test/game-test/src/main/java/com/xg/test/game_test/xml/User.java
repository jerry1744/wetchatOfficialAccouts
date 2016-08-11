package com.xg.test.game_test.xml;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @auther qikai
 * @date 2016年8月12日
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class User {

	@Min(1)
	private int id;
	
	@NotNull
	@Size(min = 6, max = 50)
	private String name;
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
