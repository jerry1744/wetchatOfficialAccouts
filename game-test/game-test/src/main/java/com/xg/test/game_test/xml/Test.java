package com.xg.test.game_test.xml;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @auther qikai
 * @date 2016年8月12日
 */
public class Test {

	public static void main(String[] args) {

		try {
			JAXBContext context = JAXBContext.newInstance(User.class);

			Marshaller marshaller = context.createMarshaller();

			User boy = new User();
			boy.setName(null);
			marshaller.marshal(boy, System.out);
			System.out.println();
			
			Unmarshaller createUnmarshaller = context.createUnmarshaller();
			
			String xml = "<user><id>0</id></user>";  
			User User2 = (User) createUnmarshaller.unmarshal(new StringReader(xml));  
	        System.out.println(User2.getName() + User2.getId()); 
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
