package Monitor.DirectoryMonitor;

import Monitor.Event;
import Monitor.EventHandler;
import Monitor.EventQueue;
import Monitor.RunnableEvent.Target;

import java.util.Set;



public class FileEventHandler implements EventHandler {
    private EventQueue queue;
    private Set<Target> targets;
    private Event event;
    private FileCommandReceiver fileCommandReceiver;

    public FileEventHandler(EventQueue queue, Set<Target> targets) {
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
                        target.getCommand().setCommandReceiver(fileCommandReceiver).execute();

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
    public Set<Target> getTargets() {

        return targets;
    }
}
