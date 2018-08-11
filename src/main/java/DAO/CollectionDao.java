package DAO;


import Models.RunnableEvent;
import Models.TargetEvent;

import java.util.HashSet;
import java.util.Set;

public class CollectionDao implements TargetDao {
    private Set<RunnableEvent> targets = new HashSet<>();

    @Override
    public void createTarget(RunnableEvent target) {
        targets.add(target);
    }

    @Override
    public TargetEvent getTarget(int id) {
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
