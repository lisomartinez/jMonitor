package Models;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SetteableEventQueue {

    private BlockingQueue<SetteableEvent> queue;

    public SetteableEventQueue() {
        queue = new LinkedBlockingQueue<>(10);
    }

    public void putEvent(SetteableEvent event) {
        try {
            queue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SetteableEvent getEvent() {

        SetteableEvent event = null;
        try {
            event = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return event;
    }
}
