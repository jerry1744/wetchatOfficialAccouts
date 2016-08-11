package com.xg.game.spring;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.xg.game.log.MyLoggerFactory;

/**
 * Spring容器管理器
 * @auther qikai
 * @date 2016年8月2日
 */
public class SpringContextContainer implements ApplicationContextAware, DisposableBean {

	private final static Logger logger = MyLoggerFactory.commonLog;
	private static ApplicationContext applicationContext;

	@Override
	public void destroy() throws Exception {
		cleanApplicationContext();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringContextContainer.applicationContext != null) {
			throw new IllegalStateException("ApplicationContextHolder already holded 'applicationContext'.");
		}
		SpringContextContainer.applicationContext = applicationContext;
		logger.info("holded applicationContext,displayName:" + applicationContext.getDisplayName());
	}

	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"'applicationContext' property is null,ApplicationContextHolder not yet init.");
		}
		return applicationContext;
	}

	/**
	 * 获取bean
	 * @param <T>
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		Object obj = applicationContext.getBean(name);
		return (T) obj;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 如果有多个Bean符合Class, 取出第一个.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		checkApplicationContext();
		return applicationContext.getBean(requiredType);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		checkApplicationContext();
		return applicationContext.getBean(name, requiredType);
	}

	public static <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		checkApplicationContext();
		return applicationContext.getBeansOfType(type);
	}

	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

	/**
	* 清除applicationContext静态变量.
	*/
	public static void cleanApplicationContext() {
		applicationContext = null;
	}
}
