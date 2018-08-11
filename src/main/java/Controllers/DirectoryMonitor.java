package Controllers;

import Models.RunnableEvent;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DirectoryMonitor {
    private EventHandler eventHandler;
    private Watcher watcher;

    public DirectoryMonitor(EventHandler eventHandler, Watcher watcher) {
        this.eventHandler = eventHandler;
        this.watcher = watcher;
    }

    public void start() {
        watcher.registerTargets(eventHandler.getTargets());
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(watcher);
        executor.execute(eventHandler);
    }

}
