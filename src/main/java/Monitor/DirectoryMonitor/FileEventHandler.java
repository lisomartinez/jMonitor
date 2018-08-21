package Monitor.DirectoryMonitor;

import Monitor.Event;
import Monitor.EventHandler;
import Monitor.EventQueue;
import Monitor.RunnableEvent.RunnableEvent;

import java.util.Set;



public class FileEventHandler implements EventHandler {
    private EventQueue queue;
    private Set<RunnableEvent> targets;
    private Event event;
    private FileCommandReceiver fileCommandReceiver;

    public FileEventHandler(EventQueue queue, Set<RunnableEvent> targets) {
        this.queue = queue;
        this.targets = targets;
        this.event = new Event();
        this.fileCommandReceiver = new FileCommandReceiver();
    }

    @Override
    public void handle() {
        event = getEvent();
        fileCommandReceiver.setSource(event.getDirectory());

        targets.stream()
                .filter(target -> target.match(event))
                .forEach(target -> {
                        fileCommandReceiver.setDestination(target.getDestination());
                        target.getCommand().setCommandReceiver(fileCommandReceiver);
                });

    }

    private Event getEvent() {
        return event;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println("handle");
            handle();
        }
    }

    @Override
    public Set<RunnableEvent> getTargets() {

        return targets;
    }
}
