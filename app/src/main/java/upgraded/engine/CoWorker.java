package upgraded.engine;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CoWorker<T> {
	
	List<T> workItems;
	List<CoWorker<T>> handovers;

	public CoWorker() {
		workItems = new ArrayList<>();
		handovers = new ArrayList<>();
	}

	public void addWorkItem(T item) {
		workItems.add(item);
	} 

	public abstract void runProcess();

}
