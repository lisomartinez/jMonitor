package Controllers;

import Models.RunnableEvent;
import Models.SourceEvent;

import java.util.Set;


public class EventHandler {
    private SourceEvent source;
    private Set<RunnableEvent> targets;

    public EventHandler(Set<RunnableEvent> targets) {
        this.targets = targets;
    }

    public void handleEvent(SourceEvent source) {
        targets.stream().filter(target -> target.match(source)).forEach(RunnableEvent::runCommands);
    }
}
