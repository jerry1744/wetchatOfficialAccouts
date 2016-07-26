package com.xg.test.game_test.pattern;

import java.util.Iterator;

/**
 * 书架 
 * 可以返回书架上的所有书籍
 * (为了方便 使用String 代替书籍)
 * @auther qikai
 * @date 2016年7月26日
 */
public class BookShelf {

	private final String[] books;

	private int last;

	public BookShelf(int maxSize) {
		this.books = new String[maxSize];
	}

	public String getBook(int index) {
		if (index < 0 || index >= last) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return books[index];
	}
	
	public int getbookCounts() {
		return last;
	}

	public void appendBook(String book) {
		if (last >= books.length) {
			//方便 使用nullpoint代替
			throw new NullPointerException();
		}
		this.books[last] = book;
		last++;
	}

	public Iterator<String> iterator() {
		return new BookShelfIterator();
	}

	private class BookShelfIterator implements Iterator<String> {
		private int mark = 0;

		public boolean hasNext() {
			return mark < BookShelf.this.getbookCounts();
		}

		public String next() {
			String book = BookShelf.this.getBook(mark);
			mark++;
			return book;
		}

		public void remove() {
			//暂未实现 需要用数组的复制之类的东西
		}
	}
}
