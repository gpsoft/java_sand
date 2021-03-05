package java_sand.sand;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import java_sand.Utils;

public class FutureSand implements Sand {

	@Override
	public void run() {
		Utils.prn("パターン1: 終わるまで帰って来るな。");
		BigData data = queryBigDataSync();
		Utils.prn("終わった: " + data.size + "件ヒット。");

		Utils.prn("パターン2: 着火したら、さっさと帰ってこい。");
		CompletableFuture<?> future = queryBigDataAsync((BigData dataAsync) -> {
			Utils.prn("終わった: " + dataAsync.size + "件ヒット。");
		});
		Utils.prn("着火完了: 結果は、まだ分からん。");

		// このままreturnすると、プログラム自体が終わってしまうので
		// 非同期処理が終わるまで待つ。
		future.join();
	}

	// 時間のかかる架空の処理を、同期的に実行する。
	private BigData queryBigDataSync() {
		// どこかのサーバで、ビッグデータを検索したつもり。
		// 3秒かかる。
		Utils.sleep(3);

		// 検索完了。
		return new BigData(Long.MAX_VALUE);
	}

	// 時間のかかる処理を、非同期に実行する。
	// 「処理が終わったときに何をしたいか」を引数で指定。
	private CompletableFuture<Void> queryBigDataAsync(Consumer<BigData> comsumer) {
		return CompletableFuture
				.supplyAsync(() -> queryBigDataSync())
				.thenAccept(comsumer);
	}

	class BigData {
		public long size;

		public BigData(long size) {
			this.size = size;
		}
	}
}
