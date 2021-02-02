package java_sand.sand;

import java_sand.misc.GuessingGame;

public class JunitSand implements Sand {
	private GuessingGame game = new GuessingGame();

	@Override
	public void run() {
		// nothing to do.
	}

	/**
	 * 引数をインクリメントして返す。
	 */
	public int inc(int n) {
		return n + 1;
	}

	/**
	 * 引数が偶数かどうかを返す。
	 */
	public boolean isEven(int n) {
		return n % 2 == 0;
	}

	/**
	 * 大文字に変換し、末尾に ! を付けて出力する。
	 */
	public void scream(String m) {
		System.out.print(m.toUpperCase() + "!");
	}

	/**
	 * 数あてゲーム。正解かどうかを返す。
	 */
	public boolean guess(int n) {
		return game.makeGame() == n;
	}
}
