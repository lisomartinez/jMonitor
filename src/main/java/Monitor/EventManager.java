package Monitor;

import Monitor.RunnableEvent.RunnableEvent;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EventManager {
    private static EventManager eventManager = new EventManager();
    private Set<RunnableEvent> targets = new HashSet<>();


    private EventManager() {
    }

    public void loadTargets(){

    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public void addTarget(RunnableEvent target) {
        assert target != null : "DirectoryTargetEvent can not be null";
            targets.add(target);
    }

    public void removeTarget(RunnableEvent target) {
        targets.remove(target);
    }

    public  Set<RunnableEvent> getTargets() {
        return targets;
    }

    public List<Path> getTargetsPaths() {
        return targets.stream().map(RunnableEvent::getSource).collect(Collectors.toList());
    }

}
