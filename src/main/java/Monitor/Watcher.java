package Monitor;

import Monitor.RunnableEvent.RunnableEvent;

import java.util.Set;

public interface Watcher extends Runnable {
    void process();
    void registerTargets(Set<RunnableEvent> targets);
}
