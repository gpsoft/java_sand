package java_sand.sand;

import java.time.LocalDateTime;

import java_sand.Utils;

public class StaticSand implements Sand {
	@Override
	public void run() {
		Ant ant1 = Ant.newAnt();
		ant1.sayHi();

		Utils.sleep(3, true);
		Ant ant2 = Ant.newAnt();
		ant2.sayHi();

		Utils.sleep(2, true);
		Ant ant3 = Ant.newAnt();
		ant3.sayHi();
	}
}

class Ant {
	private static int numInstances = 0;
	private LocalDateTime createdAt;
	private int no;

	public static Ant newAnt() {
		numInstances++;
		int newNo = numInstances;
		return new Ant(newNo);
	}

	private Ant(int no) {
		createdAt = LocalDateTime.now();
		this.no = no;
	}

	public void sayHi() {
		Utils.prn("Hi, I'm ant #" + no + ", created at " + Utils.timestr(createdAt));
	}
}