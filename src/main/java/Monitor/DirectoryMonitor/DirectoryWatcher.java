package Monitor.DirectoryMonitor;

import Monitor.RunnableEvent.RunnableEvent;
import Monitor.Event;
import Monitor.EventQueue;
import Monitor.Watcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;
import java.util.Set;


import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class DirectoryWatcher implements Watcher {
    private WatchService watchService;
    private WatchKey key;
    private Event sourceEvent;
    private EventQueue queue;


    public DirectoryWatcher(EventQueue queue, FileSystem fileSystem) {
        this.sourceEvent = new Event();
        this.queue = queue;
        try {
            watchService = fileSystem.newWatchService();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void register(Path target) {
        try {
            System.out.println(target);
            target.register(watchService, ENTRY_CREATE, ENTRY_MODIFY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerTargets(Set<RunnableEvent> targets) {
        targets.stream().map(RunnableEvent::getDirectory).forEach(this::register);
    }

    public void process() {
        read();
        produceSourceEvent();
        reset();
    }

    private void read() {
        try {
            key = watchService.take();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void produceSourceEvent() {
        key.pollEvents().forEach(this::processEvent);
    }

    void processEvent(WatchEvent<?> event) {
        setSourceEvent(event);
        addQueue(sourceEvent);
    }

    private void setSourceEvent(WatchEvent<?> event){
        Path path = Paths.get(key.watchable() + FileSystems.getDefault().getSeparator() + event.context());

        LogManager.getLogger(this.getClass().getName()).debug(path);
        LogManager.getLogger(this.getClass().getName()).debug(path.getParent());

        String filename = event.context().toString();
        String extension = filename.substring(filename.lastIndexOf(".") + 1);

        sourceEvent.setDirectory(path).setExtension(extension);
    }

    private void addQueue(Event event) {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.debug(event);

        queue.putEvent(event);
    }

    @Override
    public void run() {
        while (true) {

            process();
        }
    }

    private void reset(){
        key.reset();
    }
}
