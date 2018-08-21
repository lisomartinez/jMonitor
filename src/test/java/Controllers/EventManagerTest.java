package Controllers;

import Monitor.DirectoryMonitor.CopyCommand;
import Monitor.RunnableEvent.DirectoryTarget;
import Monitor.RunnableEvent.Target;
import Monitor.EventManager;
import Monitor.DirectoryMonitor.MoveCommand;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

public class EventManagerTest {
    private EventManager eventManager;
    private Path source;
    private Path destination;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void create() {
        eventManager = EventManager.getEventManager();
        source = Paths.get(System.getProperty("user.home"));
        destination = Paths.get(System.getProperty("user.home"));
    }

    @Test
    public void addTarget(){

        Target directoryTarget = new DirectoryTarget()
                                                    .source(source)
                                                    .extension("txt")
                                                    .destination(destination)
                                                    .command(new CopyCommand());
        eventManager.addTarget(directoryTarget);
        List<Path> targetsPath = eventManager.getTargetsPaths();
        assertThat(targetsPath, hasItem(directoryTarget.getSource()));
    }

    @Test
    public void addTargetNullThrowAssertionError() {
        exception.expect(AssertionError.class);
        eventManager.addTarget(null);
    }

    @Test
    public void loadTargets() {
//        Set<Target> targets = new HashSet<>();
//        DirectoryTarget one = new DirectoryTarget(Paths.get(System.getProperty("user.home")), "txt", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//        DirectoryTarget two = new DirectoryTarget(Paths.get(System.getProperty("user.home")), "pdf", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//        DirectoryTarget three = new DirectoryTarget(Paths.get(System.getProperty("user.home")), "doc", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//        DirectoryTarget four = new DirectoryTarget(Paths.get(System.getProperty("user.home")), "zip", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//
//        targets.add(one);
//        targets.add(three);
//        targets.add(four);
//
//        eventManager.addTarget(one);
//        eventManager.addTarget(three);
//        eventManager.addTarget(four);
//
//        targets = eventManager.getTargets();
//        assertThat(targets, equalTo(eventManager.getTargets()));
    }
}