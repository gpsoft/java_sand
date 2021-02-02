package java_sand;

import java_sand.sand.JacksonSand;
import java_sand.sand.JunitSand;
import java_sand.sand.ListSand;
import java_sand.sand.OptionalSand;
import java_sand.sand.Sand;
import java_sand.sand.StaticSand;
import java_sand.sand.UriSand;

public class Main {
	public static void main(String[] args) {
		Sand[] sands = new Sand[] {
				new OptionalSand(),
				new UriSand(),
				new StaticSand(),
				new ListSand(),
				new JacksonSand(),
				new JunitSand(),
		};
		int ix = sands.length - 1;
		if (args.length > 0) ix = Utils.parseInt(args[0], ix);
		sands[ix].run();
	}
}
