package upgraded.engine;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Manager {

	List<CoWorker> coworkers;

	BooleanSupplier stopCondition;

	int timeUnitsUsed = 0;

	public Manager(List<CoWorker> coworkers, BooleanSupplier stopCondition) {

		this.coworkers = coworkers;
		this.stopCondition = stopCondition;

	}

	public void run() {
		while(!stopCondition.getAsBoolean()) {
			coworkers.stream().forEach(co -> co.runProcess());
			timeUnitsUsed++;
		}
	}

	public int getTime() {
		return timeUnitsUsed;
	}
	
}