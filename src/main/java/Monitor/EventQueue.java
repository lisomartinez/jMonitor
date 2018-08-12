package Monitor;

import Monitor.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventQueue {

    private BlockingQueue<Event> queue;

    public EventQueue() {
        queue = new LinkedBlockingQueue<>(10);
    }

    public void putEvent(Event event) {
        try {
            queue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Event getEvent() {

        Event event = null;
        try {
            event = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return event;
    }
}
