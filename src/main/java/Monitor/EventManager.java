package Monitor;

import Monitor.RunnableEvent.Target;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EventManager {
    private static EventManager eventManager = new EventManager();
    private Set<Target> targets = new HashSet<>();


    private EventManager() {
    }

    public void loadTargets(){

    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public void addTarget(Target target) {
        assert target != null : "DirectoryTarget can not be null";
            targets.add(target);
    }

    public void removeTarget(Target target) {
        targets.remove(target);
    }

    public List<Path> getTargetsPaths() {
        return targets.stream().map(Target::getSource).collect(Collectors.toList());
    }

}
