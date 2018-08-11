package DAO;

import Controllers.MoveOperationCommand;
import Models.RunnableEvent;
import Models.Target;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;

public class TargetDaoTest {
    private TargetDao targetDao;

    @Before
    public void create(){
        targetDao = new CollectionDao();
    }

    @Test
    public void createTarget(){

        Set<RunnableEvent> targets = new HashSet<>();

        Models.Target one = new Models.Target(Paths.get(System.getProperty("user.home")), "txt", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));
        Models.Target two = new Models.Target(Paths.get(System.getProperty("user.home")), "pdf", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));
        Models.Target three = new Models.Target(Paths.get(System.getProperty("user.home")), "doc", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));
        Models.Target four = new Target(Paths.get(System.getProperty("user.home")), "zip", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));


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