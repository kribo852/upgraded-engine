package upgraded.engine;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.atomic.AtomicInteger;

public class Worker<T> extends SubmissionPublisher<T> implements Subscriber<T> {

    private Subscription subscription;
    private int delay;

    public Worker(int delay) {
        this.delay = delay;
    }
    
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }


    @Override
    public void onNext(T item) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        
        submit(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        
    }

}
