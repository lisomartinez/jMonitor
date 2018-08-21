package Models;

import Monitor.DirectoryMonitor.MoveCommand;
import Monitor.RunnableEvent.DirectoryTargetEvent;
import Monitor.RunnableEvent.RunnableEvent;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class DirectoryTargetEventTest {
    private Set<RunnableEvent> targets;

    @Before
    public void create(){
       targets = new HashSet<>();

    }

    @Test
    public void getDirectory() {

        Path pone = Paths.get(System.getProperty("user.home"));
        Path ptwo = Paths.get(System.getProperty("user.home"));
        Path pthree = Paths.get(System.getProperty("user.home"));
        Path pfour = Paths.get(System.getProperty("user.home"));

        List<Path> paths =  new ArrayList<>();
        paths.add(pone);
        paths.add(ptwo);
        paths.add(pthree);
        paths.add(pfour);

        DirectoryTargetEvent one = new DirectoryTargetEvent(pone, "txt", new MoveCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent two = new DirectoryTargetEvent(ptwo, "pdf", new MoveCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent three = new DirectoryTargetEvent(pthree, "doc", new MoveCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent four = new DirectoryTargetEvent(pfour,"zip", new MoveCommand(Paths.get(System.getProperty("user.home"))));


        targets.add(one);
        targets.add(two);
        targets.add(three);
        targets.add(four);


        paths.forEach(System.out::println);
        assertThat(paths, equalTo(targets.stream().map(RunnableEvent::getDirectory).collect(Collectors.toList())));

    }
}