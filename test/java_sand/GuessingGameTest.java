package java_sand;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java_sand.misc.GuessingGame;

class GuessingGameTest {

	@Test
	public void gameRangeTest() {
		GuessingGame game = new GuessingGame();

		IntStream.range(0, 1000).forEach(n -> {
			int answer = game.makeGame();
			Assertions.assertTrue(answer >= 0);
			Assertions.assertTrue(answer < 100);
		});
	}
}
