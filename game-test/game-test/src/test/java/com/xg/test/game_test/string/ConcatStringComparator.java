package com.xg.test.game_test.string;

/**
 * 测试几种 String 拼接字符串的效率
 * @auther qikai
 * @date 2016年7月25日
 */
public class ConcatStringComparator {

	private final static String initString = "test";
	/**循环次数*/
	private final static int cyclySize = 10000;

	public static void main(String[] args) {
		ConcatStringComparator comparator = new ConcatStringComparator();
		comparator.testPlus();
		comparator.testConcat();
		comparator.testStringBuffer();
		comparator.testStringBuilder();
		comparator.testStringFormat();
	}

	@SuppressWarnings("unused")
	public void testPlus() {
		String s;
		long ts = System.currentTimeMillis();
		for (int i = 0; i < cyclySize; i++) {
			s = initString + String.valueOf(i);
		}
		long te = System.currentTimeMillis();
		System.out.println(String.format("+ cost {%s} ms", te - ts));
	}

	@SuppressWarnings("unused")
	public void testConcat() {
		String s;
		long ts = System.currentTimeMillis();
		for (int i = 0; i < cyclySize; i++) {
			s = initString.concat(String.valueOf(i));
		}
		long te = System.currentTimeMillis();
		System.out.println(String.format("concat cost {%s} ms", te - ts));
	}
	//
	//	public void testJoin() {
	//		List<String> list = new ArrayList<String>();
	//		long ts = System.currentTimeMillis();
	//		for (int i = 0; i < cyclySize; i++) {
	//			list.add(String.valueOf(i));
	//		}
	//		StringUtils.join(list, "");
	//		long te = System.currentTimeMillis();
	//		System.out.println(String.format("StringUtils.join cost {%s} ms", te - ts));
	//	}

	@SuppressWarnings("unused")
	public void testStringBuffer() {
		String s;
		long ts = System.currentTimeMillis();
		for (int i = 0; i < cyclySize; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(initString).append(String.valueOf(i));
			s = sb.toString();
		}
		long te = System.currentTimeMillis();
		System.out.println(String.format("StringBuffer cost {%s} ms", te - ts));
	}

	@SuppressWarnings("unused")
	public void testStringBuilder() {
		String s;
		long ts = System.currentTimeMillis();
		for (int i = 0; i < cyclySize; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(initString).append(String.valueOf(i));
			s = sb.toString();
		}
		long te = System.currentTimeMillis();
		System.out.println(String.format("StringBuilder cost {%s} ms", te - ts));
	}

	@SuppressWarnings("unused")
	public void testStringFormat() {
		String str;
		long ts = System.currentTimeMillis();
		for (int i = 0; i < cyclySize; i++) {
			str = String.format("%s%s", initString, String.valueOf(i));

		}
		long te = System.currentTimeMillis();
		System.out.println(String.format("StringFormat cost {%s} ms", te - ts));
	}
}
