package com.xg.game.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志
 * @auther qikai
 * @date 2016年8月2日
 */
public class MyLoggerFactory {

	/**普通日志 后台打印+记录文档*/
	public final static Logger commonLog = LoggerFactory.getLogger("loggers.commonlog");
	
	public final static Logger errorlog = LoggerFactory.getLogger("loggers.errorlog");
	
	public final static Logger consoleLog = LoggerFactory.getLogger("loggers.consolelog");
}
