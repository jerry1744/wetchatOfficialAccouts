package com.xg.test.game_test.rsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @auther qikai
 * @date 2016年8月5日
 */
public class ReadFile {

	public static void main(String[] args) throws Exception {
		String publicKey = readKey("D:\\test1.txt");
		String privateKey = readKey("D:\\test2.txt");
		System.out.println("result----");
		System.out.println(publicKey);
		System.out.println(privateKey);
	}

	private static String readKey(String fileName) throws Exception {
		List<String> result = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			String row;
			while ((row = bufferedReader.readLine()) != null) {
				result.add(row);
			}
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String string : result) {
			string = string.trim();
			System.out.println(string);
			if (null == string || "".equals(string) || string.length() == 0) {
			} else {
				sb.append(string);
			}
		}
		return sb.toString();
	}
}
