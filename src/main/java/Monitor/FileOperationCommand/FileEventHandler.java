package Monitor.FileOperationCommand;

import Monitor.Event;
import Monitor.EventHandler;
import Monitor.EventQueue;
import Monitor.RunnableEvent.RunnableEvent;

import java.util.Set;
import java.util.function.Predicate;


public class FileEventHandler implements EventHandler {
    private EventQueue queue;
    private Set<RunnableEvent> targets;
    private Event event;

    public FileEventHandler(EventQueue queue, Set<RunnableEvent> targets) {
        this.queue = queue;
        this.targets = targets;
        this.event = new Event();
    }

    @Override
    public void handle() {
                event = getEvent();
                Predicate<RunnableEvent> matchSource = target -> target.match(event);
                targets.stream().filter(matchSource).forEach(target -> target.runCommand(event.getDirectory()));
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
