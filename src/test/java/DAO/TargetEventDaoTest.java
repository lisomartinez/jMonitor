package DAO;

import Controllers.MoveOperationCommand;
import Models.RunnableEvent;
import Models.TargetEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;

public class TargetEventDaoTest {
    private TargetDao targetDao;

    @Before
    public void create(){
        targetDao = new CollectionDao();
    }

    @Test
    public void createTarget(){

        Set<RunnableEvent> targets = new HashSet<>();

        TargetEvent one = new TargetEvent(Paths.get(System.getProperty("user.home")), "txt", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent two = new TargetEvent(Paths.get(System.getProperty("user.home")), "pdf", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent three = new TargetEvent(Paths.get(System.getProperty("user.home")), "doc", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent four = new TargetEvent(Paths.get(System.getProperty("user.home")), "zip", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));


        targets.add(one);
        targets.add(two);
        targets.add(three);
        targets.add(four);

        targetDao.createTarget(one);
        targetDao.createTarget(two);
        targetDao.createTarget(three);
        targetDao.createTarget(four);

        Assert.assertThat(targets, equalTo(targetDao.loadTargets()));
    }
}