package DAO;


import Controllers.MoveOperationCommand;
import Models.RunnableEvent;
import Models.Target;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CollectionDao implements TargetDao {
    private Set<RunnableEvent> targets = new HashSet<>();

    @Override
    public void createTarget(RunnableEvent target) {
        targets.add(target);
    }

    @Override
    public Target getTarget(int id) {
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
