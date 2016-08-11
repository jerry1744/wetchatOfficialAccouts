package com.xg.game.provider.gen;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.xg.game.spring.SpringContextContainer;

/**
 * 用户ID生成器
 * @auther qikai
 * @date 2016年8月12日
 */
@Component
public final class IdGenerator {

	private final AtomicInteger generator = new AtomicInteger(0);

	
	public final static IdGenerator getInstance(){
		return SpringContextContainer.getBean(IdGenerator.class);
	}
	
	/**
	 * 获取新的用户ID
	 * @return
	 */
	public final int getNewUserID() {
		return generator.incrementAndGet();
	}

}
