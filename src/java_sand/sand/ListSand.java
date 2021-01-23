package java_sand.sand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import java_sand.Utils;

public class ListSand implements Sand {

	@Override
	public void run() {
		// Listを作る
		Utils.prn("Listを作る。");
		List<String> lis = createList();
		prnList(lis);

		// Listの各アイテムに対して、何かする
		Utils.prn("Listの各アイテムに対して、何かする。");
		doSomethingList(lis);

		// Listをふるいにかける
		Utils.prn("Listをふるいにかける。");
		List<String> filtered = filterList(lis);
		prnList(filtered);

		// Listの各アイテムを加工する
		Utils.prn("Listの各アイテムを加工する。");
		List<String> mapped = mapList(lis);
		prnList(mapped);

		// Listの全アイテムをまとめる
		Utils.prn("Listの全アイテムをまとめる。");
		String reduced = reduceList(lis);
		Utils.prn(reduced);

		// Listから、条件に合うアイテムを削除する
		Utils.prn("Listから、条件に合うアイテムを削除する。");
		lis = new ArrayList<String>(lis);
		// ↑Listの作り方によっては、削除処理に対応してないかもしれないので、
		// まず、作り直す。
		prnList(lis); // before
		removeFromList(lis);
		prnList(lis); // after
	}

	private List<String> createList() {
		// Listを作る方法

		// (a)
		List<String> lis = new ArrayList<String>();
		lis.add("apple");
		lis.add("orange");
		lis.add("banana");
		lis.add("melon");
		lis.add("lemon");
		lis.add("peach");
		lis.add("cherry");
		lis.add("grape");
		lis.add("kiwi");

		// (b)
		lis = Arrays.asList("apple", "orange", "banana", "melon", "lemon", "peach",
				"cherry", "grape", "kiwi");

		return lis;
	}

	private void doSomethingList(List<String> lis) {
		// Listの各アイテムに対して、何かする方法
		// 「何かする」とは、例えば、「表示する」とか

		// (a)
		Utils.prn("(a)");
		for (int i = 0; i < lis.size(); i++) {
			String item = lis.get(i);
			doSomething(item);
		}

		// (b)
		Utils.prn("(b)");
		for (String item : lis) {
			doSomething(item);
		}

		// (c)
		Utils.prn("(c)");
		Iterator<String> ite = lis.iterator();
		while (ite.hasNext()) {
			String item = ite.next();
			doSomething(item);
		}

		// (d)
		Utils.prn("(d)");
		lis.stream().forEach(this::doSomething);

		// (e)
		Utils.prn("(e)");
		lis.stream().forEach(s -> {
			Utils.prn(s);
		});
	}

	private List<String> filterList(List<String> lis) {
		// Listを、ある条件で、ふるいにかける方法
		// 「ある条件」とは、例えば、「長さが4文字を超える」とか

		// (a)
		List<String> filtered = new ArrayList<String>();
		for (String item : lis) {
			if (!isTooLong(item)) continue;
			filtered.add(item);
		}

		// (b)
		filtered = lis.stream().filter(this::isTooLong).collect(Collectors.toList());

		// (c)
		filtered = lis.stream().filter(s -> s.length() > 4).collect(Collectors.toList());

		return filtered;
	}

	private List<String> mapList(List<String> lis) {
		// Listの各アイテムを加工する方法
		// 「加工する」とは、例えば、「末尾にビックリマークを付ける」とか

		// (a)
		List<String> mapped = new ArrayList<String>();
		for (String item : lis) {
			String mappedItem = wow(item);
			mapped.add(mappedItem);
		}

		// (b)
		mapped = lis.stream().map(this::wow).collect(Collectors.toList());

		// (c)
		mapped = lis.stream().map(s -> s + "!").collect(Collectors.toList());

		return mapped;
	}

	private String reduceList(List<String> lis) {
		// Listの全アイテムをまとめる方法
		// 「まとめる」とは、例えば、「カンマ区切りで連結する」とか

		// (a)
		String reduced = "";
		for (String item : lis) {
			if (reduced.isEmpty()) {
				reduced = item;
			} else {
				reduced += ", " + item;
			}
		}

		// (b)
		reduced = lis.stream().reduce(this::append).orElse("");

		// (c)
		reduced = lis.stream().reduce((acc, one) -> acc + ", " + one).orElse("");

		// (d)
		reduced = lis.stream().collect(Collectors.joining(", "));

		return reduced;
	}

	private List<String> removeFromList(List<String> lis) {
		// Listから、条件に合うアイテムを削除する方法
		// 「条件に合う」とは、例えば、「長さが4文字を超える」とか

		// (a)
		Iterator<String> ite = lis.iterator();
		while (ite.hasNext()) {
			String item = ite.next();
			if (isTooLong(item)) ite.remove();
		}

		// (b)
		lis.removeIf(this::isTooLong);

		// (c)
		lis.removeIf(s -> s.length() > 4);

		return lis;
	}

	// - - -

	private void prnList(List<String> lis) {
		String items = lis.stream().collect(Collectors.joining(", "));
		Utils.prn(items);
	}

	private void doSomething(String item) {
		Utils.prn(item);
	}

	private boolean isTooLong(String item) {
		return item.length() > 4;
	}

	private String wow(String item) {
		return item + "!";
	}

	private String append(String acc, String one) {
		return acc + ", " + one;
	}
}
