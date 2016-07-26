package com.xg.test.game_test.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用于区分iterator.remove和Collection/Map 自带的remove方法区别的类
 * @auther qikai
 * @date 2016年7月25日
 */
public class CollectionOrMapRemove {

	public static void main(String[] args) {

		List<String> ramdomFilledList = ramdomFilledList();
		//		error Code start 	
		//		for (String string : ramdomFilledList) {
		//			if(string.endsWith("3")){
		//				ramdomFilledList.remove(string);
		//			}
		//		}
		//	   error code end
		for (int i = 0; i < ramdomFilledList.size(); i++) {
			String string = ramdomFilledList.get(i);
			if (string.endsWith("3")) {
				ramdomFilledList.remove(i);
			}
		}
		System.out.println(ramdomFilledList);
		for (Iterator<String> iterator = ramdomFilledList.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if (string.endsWith("4")) {
				System.out.println("remove");
				iterator.remove();
			}
		}
		System.out.println(ramdomFilledList);
		Iterator<String> iterator = ramdomFilledList.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (next.endsWith("5")) {
				System.out.println("remove");
				iterator.remove();
			}
		}
		System.out.println(ramdomFilledList);
	}

	private static List<String> ramdomFilledList() {
		List<String> stringLists = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			stringLists.add("test" + i);
		}
		return stringLists;
	}
}
