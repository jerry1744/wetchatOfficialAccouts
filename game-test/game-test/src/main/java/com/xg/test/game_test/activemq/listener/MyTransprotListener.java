package com.xg.test.game_test.activemq.listener;

import java.io.IOException;

import org.apache.activemq.transport.TransportListener;

/**
 *
 * @auther qikai
 * @date 2016年8月4日
 */
public class MyTransprotListener implements TransportListener {
	//private final static Logger logger = MyLoggerFactory.commonLog;
	
	
	@Override
	public void onCommand(Object command) {
		//logger.info("onCommand " + command);
	}
	
	@Override
	public void onException(IOException error) {
		//logger.info("onException " + error);
	}
	
	@Override
	public void transportInterupted() {
		//logger.info("transportInterupted ");
	}
	
	@Override
	public void transportResumed() {
		//logger.info("transportResumed ");
	}
}
