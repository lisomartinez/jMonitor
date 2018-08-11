import Controllers.*;
import Models.SetteableEventQueue;
import Models.TargetEvent;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        EventManager eventManager = EventManager.getEventManager();
        Path path = Paths.get("/Users/liso/test");
        System.out.println(path);
        eventManager.addTarget(new TargetEvent(path, "txt", new CopyCommand(Paths.get("/Users/liso/Documents"))));
        SetteableEventQueue queue = new SetteableEventQueue();
        EventHandler eventHandler = new EventHandler(queue, eventManager.getTargets());
        Watcher watcher = new WatcherImpl(queue, FileSystems.getDefault());
        DirectoryMonitor directoryMonitor = new DirectoryMonitor(eventHandler, watcher);
        directoryMonitor.initialize();
        directoryMonitor.start();
    }
}
