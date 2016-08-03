package com.xg.test.game_test.activemq.convert;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.xg.test.game_test.log.MyLoggerFactory;

/**
 * String类型消息转换器
 * @auther qikai
 * @date 2016年8月2日
 */
@Component
public class StringMessageConvert implements MessageConverter {

	@Override
	public Object fromMessage(Message arg0) throws JMSException, MessageConversionException {
		return arg0;
	}

	@Override
	public Message toMessage(Object arg0, Session arg1) throws JMSException, MessageConversionException {
		MyLoggerFactory.commonLog.info("发送日志: " + arg0);
		return arg1.createTextMessage((String) arg0);
	}
}
