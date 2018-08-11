package DAO;

import Models.RunnableEvent;
import Models.TargetEvent;

import java.util.Set;

public interface TargetDao {
    void createTarget(RunnableEvent target);
    TargetEvent getTarget(int id);
    void updateTarget(RunnableEvent target);
    void deleteTarget(RunnableEvent target);
    Set<RunnableEvent> loadTargets();
}
