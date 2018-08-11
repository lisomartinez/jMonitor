package Controllers;

import Models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;
import java.util.Set;


import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WatcherImpl implements Watcher {
    private WatchService watchService;
    private WatchKey key;
    private SetteableEvent sourceEvent;
    private SetteableEventQueue queue;


    public WatcherImpl(SetteableEventQueue queue, FileSystem fileSystem) {
        this.sourceEvent = new SourceEvent();
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
        LogManager.getLogger(this.getClass().getName()).debug(key.watchable());
        Path path = ((Path) key.watchable());
        String filename = event.context().toString();
        String extension = filename.substring(filename.lastIndexOf(".") + 1);

        sourceEvent.setDirectory(path).setExtension(extension);
    }

    private void addQueue(SetteableEvent event) {
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
