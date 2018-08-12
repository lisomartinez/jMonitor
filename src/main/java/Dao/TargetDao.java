package Dao;

import Monitor.RunnableEvent.RunnableEvent;
import Monitor.RunnableEvent.DirectoryTargetEvent;

import java.util.Set;

public interface TargetDao {
    void createTarget(RunnableEvent target);
    DirectoryTargetEvent getTarget(int id);
    void updateTarget(RunnableEvent target);
    void deleteTarget(RunnableEvent target);
    Set<RunnableEvent> loadTargets();
}
