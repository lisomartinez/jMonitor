package Controllers;

import Monitor.RunnableEvent.DirectoryTargetEvent;
import Monitor.RunnableEvent.RunnableEvent;
import Monitor.EventManager;
import Monitor.DirectoryMonitor.MoveCommand;
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
        DirectoryTargetEvent directoryTargetEvent = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "txt", new MoveCommand(Paths.get(System.getProperty("user.home"))));
        eventManager.addTarget(directoryTargetEvent);
        assertThat(eventManager.getTargets(), hasItem(directoryTargetEvent));
    }

    @Test
    public void addTargetNullThrowAssertionError() {
        exception.expect(AssertionError.class);
        eventManager.addTarget(null);
    }

    @Test
    public void loadTargets() {
        Set<RunnableEvent> targets = new HashSet<>();
        DirectoryTargetEvent one = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "txt", new MoveCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent two = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "pdf", new MoveCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent three = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "doc", new MoveCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent four = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "zip", new MoveCommand(Paths.get(System.getProperty("user.home"))));

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