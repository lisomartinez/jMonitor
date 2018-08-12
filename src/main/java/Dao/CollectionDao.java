package Dao;


import Monitor.RunnableEvent.DirectoryTargetEvent;
import Monitor.RunnableEvent.RunnableEvent;

import java.util.HashSet;
import java.util.Set;

public class CollectionDao implements TargetDao {
    private Set<RunnableEvent> targets = new HashSet<>();

    @Override
    public void createTarget(RunnableEvent target) {
        targets.add(target);
    }

    @Override
    public DirectoryTargetEvent getTarget(int id) {
        return null;
    }

    @Override
    public void updateTarget(RunnableEvent target) {

    }

    @Override
    public void deleteTarget(RunnableEvent target) {

    }

    @Override
    public Set<RunnableEvent> loadTargets() {


        return targets;
    }
}
