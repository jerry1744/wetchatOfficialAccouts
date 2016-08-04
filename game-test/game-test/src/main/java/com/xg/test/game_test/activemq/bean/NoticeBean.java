package com.xg.test.game_test.activemq.bean;

import java.io.Serializable;

/**
 * 自定义消息通知
 * @auther qikai
 * @date 2016年8月4日
 */
public class NoticeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -111826759073226344L;

	private int id;

	private int index;

	private String content;

	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
