package com.xg.test.game_test.activemq.sender;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.xg.test.game_test.spring.SpringContextContainer;

/**
 * 发送者端
 * 使用spring继承 
 * 直接使用spring的jmsTemplate发送消息
 * @auther qikai
 * @date 2016年8月2日
 */
@Component
public class ActivemqSender {

	public final static ActivemqSender getInstance() {
		return SpringContextContainer.getBean(ActivemqSender.class);
	}

	@Autowired
	@Qualifier("jmsTemplate_sender")
	private JmsTemplate jmsTemplate;

	public void senderMsg(String messageStr) throws JMSException {
		jmsTemplate.convertAndSend(messageStr);
	}
}
