package java_sand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java_sand.misc.GuessingGame;
import java_sand.sand.JunitSand;

/**
 * - @ExtendWithで、Mockitoを有効化
 * - @InjectMocksを付けたオブジェクトが、モックを仕込むターゲット
 * - @Mockを付けたオブジェクトが、モック本体
 */
@ExtendWith(MockitoExtension.class)
public class JunitSandMockTest {
	@InjectMocks
	private JunitSand sand = new JunitSand();

	@Mock
	private GuessingGame game;

	@Test
	public void guessRight() {
		Mockito.doReturn(12).when(game).makeGame();
		// ↑「makeGame()が呼ばれたら12を返す」ようなモックを仕込んだ。

		Assertions.assertTrue(sand.guess(12));
	}

	@Test
	public void guessWrong() {
		Mockito.doReturn(12).when(game).makeGame();
		Assertions.assertFalse(sand.guess(10));
	}
}
