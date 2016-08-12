package com.xg.game.provider.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @auther qikai
 * @date 2016年8月12日
 */
public class StartMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = null;
		Scanner scanner = null;
		try {
			//classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
			System.out.println("please input any key to quit");
			scanner = new Scanner(System.in);
			String nextLine = scanner.nextLine();
			System.out.println("Input  " + nextLine);
			System.out.println("bye!");
		} finally {
			if (null != scanner) {
				scanner.close();
			}
			if (null != classPathXmlApplicationContext) {
				classPathXmlApplicationContext.close();
			}
		}
	}
}
