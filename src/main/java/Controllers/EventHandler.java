package Controllers;

import Models.RunnableEvent;
import Models.SetteableEvent;
import Models.SourceEvent;
import Models.SetteableEventQueue;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Predicate;


public class EventHandler implements Runnable{
    private SetteableEventQueue queue;
    private Set<RunnableEvent> targets;
    private SetteableEvent event;

    public EventHandler(SetteableEventQueue queue, Set<RunnableEvent> targets) {
        this.queue = queue;
        this.targets = targets;
        this.event = new SourceEvent();
    }

    public void handle() {
                SetteableEvent event = getEvent();
                Predicate<RunnableEvent> matchSource = target -> target.match(event);
                targets.stream().filter(matchSource).forEach(target -> target.runCommand(event.getDirectory()));
    }

    private SetteableEvent getEvent() {
        return queue.getEvent();
    }


    @Override
    public void run() {
        while (true) {
            System.out.println("handle");
            handle();
        }
    }

    public Set<RunnableEvent> getTargets() {
        return targets;
    }
}
