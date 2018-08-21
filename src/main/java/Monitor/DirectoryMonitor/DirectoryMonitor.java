package Monitor.DirectoryMonitor;

import Monitor.Monitor;
import Monitor.Watcher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DirectoryMonitor implements Monitor {
    private FileEventHandler fileEventHandler;
    private Watcher watcher;

    public DirectoryMonitor(FileEventHandler fileEventHandler, Watcher watcher) {
        this.fileEventHandler = fileEventHandler;
        this.watcher = watcher;
    }

    @Override
    public void start() {
        watcher.registerTargets(fileEventHandler.getTargets());
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(watcher);
        executor.execute(fileEventHandler);
    }

}
