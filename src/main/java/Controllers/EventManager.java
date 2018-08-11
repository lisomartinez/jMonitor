package Controllers;

import DAO.TargetDao;
import Models.RunnableEvent;

import java.util.HashSet;
import java.util.Set;

public class EventManager {
    private static EventManager eventManager = new EventManager();
    private Set<RunnableEvent> targets = new HashSet<>();
    private TargetDao targetDao;

    private EventManager() {
    }

    public void loadTargets(TargetDao targetDao){
        this.targetDao = targetDao;
        targets = targetDao.loadTargets();
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public void addTarget(RunnableEvent target) {
        assert target != null : "TargetEvent can not be null";
            targets.add(target);
    }

    public void removeTarget(RunnableEvent target) {
        targets.remove(target);
    }

    public  Set<RunnableEvent> getTargets() {
        return targets;
    }

}
