package Controllers;

import Models.RunnableEvent;
import Models.TargetEvent;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Paths;
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
        TargetEvent targetEvent = new TargetEvent(Paths.get(System.getProperty("user.home")), "txt", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        eventManager.addTarget(targetEvent);
        assertThat(eventManager.getTargets(), hasItem(targetEvent));
    }

    @Test
    public void addTargetNullThrowAssertionError() {
        exception.expect(AssertionError.class);
        eventManager.addTarget(null);
    }

    @Test
    public void loadTargets() {
        Set<RunnableEvent> targets = new HashSet<>();
        TargetEvent one = new TargetEvent(Paths.get(System.getProperty("user.home")), "txt", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent two = new TargetEvent(Paths.get(System.getProperty("user.home")), "pdf", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent three = new TargetEvent(Paths.get(System.getProperty("user.home")), "doc", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent four = new TargetEvent(Paths.get(System.getProperty("user.home")), "zip", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));

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