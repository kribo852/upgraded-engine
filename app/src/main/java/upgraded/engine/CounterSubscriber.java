package upgraded.engine;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

/**
 * Counts occurences (for instance finished product) 
 */
public class CounterSubscriber<T> implements Subscriber<T> {

    private Subscription subscription;
    private final AtomicInteger counter = new AtomicInteger(0);
    private Predicate<Integer> shallPrint;
    
    public CounterSubscriber(Predicate<Integer> shallPrint) {
        this.shallPrint = shallPrint;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }


    @Override
    public void onNext(T item) {
        int current = counter.incrementAndGet();
        if(shallPrint.test(current)) {
            System.out.println("counted: " + current);
        }
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
    
    }

    public int getCount() {
        return counter.get();
    }

}
