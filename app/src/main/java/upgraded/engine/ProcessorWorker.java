package upgraded.engine;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessorWorker extends CoWorker<String> {
	
	int delay; 
	int delayCounter = 0;
	int capacity;

	public ProcessorWorker(List<CoWorker<String>> handovers, int delay, int capacity) {
		super();
		this.handovers = handovers;
		this.delay = delay;
		this.capacity = capacity;
	}

	public void runProcess() {
		if(delayCounter <= 0 && workItems.size() > 0) {
			for(int i=0; i<Math.min(workItems.size(), capacity); i++) {
				String moveThrough = workItems.remove(0);


				handovers.get(new Random().nextInt(handovers.size())).addWorkItem(moveThrough);
			}
			
			delayCounter = delay;

		} else {
			delayCounter--;
		}
	}

}
