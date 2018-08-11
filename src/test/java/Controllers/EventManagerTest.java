package Controllers;

import DAO.CollectionDao;
import Models.RunnableEvent;
import Models.Target;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

public class EventManagerTest {
    private EventManager eventManager;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void create() {
        eventManager = EventManager.getEventManager();
    }

    @Test
    public void addTarget(){
        Target target = new Target(Paths.get(System.getProperty("user.home")), "txt", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));
        eventManager.addTarget(target);
        assertThat(eventManager.getTargets(), hasItem(target));
    }

    @Test
    public void addTargetNullThrowAssertionError() {
        exception.expect(AssertionError.class);
        eventManager.addTarget(null);
    }

    @Test
    public void loadTargets() {
        Set<RunnableEvent> targets = new HashSet<>();
        Target one = new Target(Paths.get(System.getProperty("user.home")), "txt", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));
        Target three = new  Target(Paths.get(System.getProperty("user.home")), "doc", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));
        Target four = new Target(Paths.get(System.getProperty("user.home")), "zip", Arrays.asList(new MoveOperationCommand(), new MoveOperationCommand()));

        targets.add(one);
        targets.add(three);
        targets.add(four);

        eventManager.addTarget(one);
        eventManager.addTarget(three);
        eventManager.addTarget(four);


        targets = eventManager.getTargets();
        assertThat(targets, equalTo(eventManager.getTargets()));
    }
}