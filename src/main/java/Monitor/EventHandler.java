package Monitor;

import Monitor.RunnableEvent.Target;

import java.util.Set;

public interface EventHandler extends Runnable {
    void handle();

    @Override
    void run();

    Set<Target> getTargets();
}
