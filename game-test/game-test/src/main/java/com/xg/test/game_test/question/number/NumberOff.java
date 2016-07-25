package com.xg.test.game_test.question.number;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * N个人报数 1-3的报数 报到3的退出
 * 请问最后还剩几个玩家 并打印出来
 * @auther qikai
 * @date 2016年7月25日
 */
public class NumberOff {

	public static void main(String[] args) {
		NumberOff numberOff = new NumberOff();
		numberOff.startPlay();
	}

	public void startPlay() {
		int playerSize = new Random().nextInt(10);
		List<String> randomFilledPlayers = randomFilledPlayers(playerSize);
		System.out.println("本次共有" + playerSize + " 个玩家玩游戏");
		Iterator<String> iterator = randomFilledPlayers.iterator();
		while (true) {
			int index = 0;
			boolean isRemove = false;
			while (iterator.hasNext()) {
				index++;
				iterator.next();
				if (index == 3) {
					index = 0;
					isRemove = true;
					iterator.remove();
				}
			}
			if (!isRemove) {
				break;
			}
			iterator = randomFilledPlayers.iterator();
		}
		System.out.println(randomFilledPlayers);
	}

	private List<String> randomFilledPlayers(int playerSize) {
		List<String> stringLists = new ArrayList<String>();
		for (int i = 0; i < playerSize; i++) {
			stringLists.add("player_" + i);
		}
		return stringLists;
	}
}
