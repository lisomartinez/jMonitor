package Monitor.DirectoryMonitor;

import Monitor.Monitor;
import Monitor.Watcher;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DirectoryMonitor implements Monitor {
    private FileEventHandler fileEventHandler;
    private Watcher watcher;
    private List<Path> targets;

    public DirectoryMonitor(FileEventHandler fileEventHandler, Watcher watcher, List<Path> targets) {
        this.fileEventHandler = fileEventHandler;
        this.watcher = watcher;
        this.targets = targets;
    }

    @Override
    public void start() {
        watcher.registerTargets(targets);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(watcher);
        executor.execute(fileEventHandler);
    }

}
