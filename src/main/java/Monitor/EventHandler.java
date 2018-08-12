package Monitor;

import Monitor.RunnableEvent.RunnableEvent;

import java.util.Set;

public interface EventHandler extends Runnable {
    void handle();

    @Override
    void run();

    Set<RunnableEvent> getTargets();
}
