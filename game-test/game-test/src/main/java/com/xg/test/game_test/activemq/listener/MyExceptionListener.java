package com.xg.test.game_test.activemq.listener;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import com.xg.test.game_test.log.MyLoggerFactory;

/**
 *
 * @auther qikai
 * @date 2016年8月4日
 */
public class MyExceptionListener implements ExceptionListener {

	@Override
	public void onException(JMSException exception) {
		MyLoggerFactory.errorlog.error("", exception);
	}
}
