package java_sand;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Consumer;

public class OptionalSand implements Sand {
	private int[] vals = { 1, 20, 3, 480, 52 };
	private int[] empty = new int[0];

	@Override
	public void run() {
		trial("TRY1", vals -> {
			// TRY1:
			// 空配列に対応してないケース。
			// 例外が発生してしまうので、try/catchが必要。
			try {
				int max = maxOf(vals);
				prnResult(max);
			} catch (Throwable ex) {
				prnResult("失敗");
			}
		});

		trial("TRY2", vals -> {
			// TRY2:
			// 空配列に対応したケース(その1)。
			// 失敗したらnullが返るので、nullチェックが必要。
			Integer max = maxOfOrNull(vals);
			if (max != null) {
				prnResult(max);
			} else {
				prnResult("失敗");
			}
		});

		trial("TRY3", vals -> {
			// TRY3:
			// 空配列に対応したケース(その2)。
			// OptionalIntで返る。
			// isPresent()で、値の有無をチェック。
			OptionalInt maybeMax = maybeMaxOf(vals);
			if (maybeMax.isPresent()) {
				prnResult(maybeMax.getAsInt());
			} else {
				prnResult("失敗");
			}
		});

		trial("TRY4", vals -> {
			// TRY4:
			// 空配列に対応したケース(その3)。
			// OptionalIntで返る。
			// 値があるときだけ、表示したい場合。
			OptionalInt maybeMax = maybeMaxOf(vals);
			maybeMax.ifPresent(this::prnResult);
		});
	}

	private void trial(String name, Consumer<int[]> c) {
		Utils.prn("=== " + name + " ===");
		Utils.prn("max of " + Arrays.toString(vals));
		c.accept(vals);

		Utils.prn("max of []");
		c.accept(empty);
	}

	private void prnResult(int i) {
		prnResult(String.valueOf(i));
	}

	private void prnResult(String s) {
		Utils.prn("  => " + s);
	}

	// 最大値を返す。
	// 空っぽの配列を指定しちゃダメ。
	private int maxOf(int[] values) {
		int max = values[0];
		for (int v : values) {
			if (max > v) continue;
			max = v;
		}
		return max;
	}

	// 最大値を返す。
	// 空っぽの配列の場合は、nullを返す。
	private Integer maxOfOrNull(int[] values) {
		if (values.length <= 0) return null;

		return maxOf(values);
	}

	// 最大値を返す(かもしれないし、返さないかも)。
	private OptionalInt maybeMaxOf(int[] values) {
		if (values.length <= 0) return OptionalInt.empty();

		return OptionalInt.of(maxOf(values));
	}
}
