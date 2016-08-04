package com.xg.test.game_test.activemq.convert;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 *
 * @auther qikai
 * @date 2016年8月4日
 */
public class NoticeBeanMessageConvert implements MessageConverter {

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		return message;
	}

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		return session.createObjectMessage((Serializable) object);
	}
}
