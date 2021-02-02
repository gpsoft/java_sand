package java_sand;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java_sand.sand.JunitSand;

public class JunitSandTest {

	@Test
	public void incrementTest() {
		JunitSand sand = new JunitSand();
		Assertions.assertEquals(4, sand.inc(3));
		Assertions.assertEquals(0, sand.inc(-1));
		Assertions.assertEquals(4502, sand.inc(4501));
	}

	@Test
	public void evenTest() {
		JunitSand sand = new JunitSand();
		Assertions.assertTrue(sand.isEven(0));
		Assertions.assertTrue(sand.isEven(2));
		Assertions.assertTrue(sand.isEven(2008));
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 3, 5, 9, 1285 })
	public void notEvenTest(int n) {
		JunitSand sand = new JunitSand();
		Assertions.assertFalse(sand.isEven(n));
	}

	@Test
	public void screamToStdOutTest() throws IOException {
		// capture stdout
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream orig = System.out;
		System.setOut(new PrintStream(out));

		JunitSand sand = new JunitSand();
		sand.scream("Hello");

		// back to original stdout
		System.setOut(orig);

		// get the result
		out.flush();
		String result = out.toString();

		// assersion
		Assertions.assertEquals("HELLO!", result);
	}

	//@Test
	public void guessTest() {
		JunitSand sand = new JunitSand();
		Assertions.assertTrue(sand.guess(10));
		// ↑正解が予想できないので、テストが書きにくい(書けない)
		// →モックの出番
	}
}
