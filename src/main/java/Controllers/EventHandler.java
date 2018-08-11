package Controllers;

import Models.RunnableEvent;
import Models.SetteableEvent;
import Models.SourceEvent;
import Models.SetteableEventQueue;

import java.util.Set;
import java.util.function.Predicate;


public class EventHandler implements Runnable{
    private SetteableEventQueue queue;
    private Set<RunnableEvent> targets;

    public EventHandler(SetteableEventQueue queue, Set<RunnableEvent> targets) {
        this.queue = queue;
        this.targets = targets;
    }

    public void handle() {
                Predicate<RunnableEvent> matchSource = target -> target.match(getEvent());
                targets.stream().filter(matchSource).forEach(RunnableEvent::runCommand);
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
