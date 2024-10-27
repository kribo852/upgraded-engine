package upgraded.engine;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;


public class Counter<T> extends CoWorker<T> {

	int counter;


	public void runProcess() {
		counter += workItems.size();
		workItems.clear();
	}

	public int getCount() {
		return counter;
	}

}
