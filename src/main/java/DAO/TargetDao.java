package DAO;

import Models.RunnableEvent;
import Models.Target;

import java.util.Set;

public interface TargetDao {
    void createTarget(RunnableEvent target);
    Target getTarget(int id);
    void updateTarget(RunnableEvent target);
    void deleteTarget(RunnableEvent target);
    Set<RunnableEvent> loadTargets();
}
