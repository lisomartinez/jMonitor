package Models;

import Controllers.MoveOperationCommand;
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

public class TargetEventTest {
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

        TargetEvent one = new TargetEvent(pone, "txt", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent two = new TargetEvent(ptwo, "pdf", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent three = new TargetEvent(pthree, "doc", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        TargetEvent four = new TargetEvent(pfour,"zip", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));


        targets.add(one);
        targets.add(two);
        targets.add(three);
        targets.add(four);


        paths.forEach(System.out::println);
        assertThat(paths, equalTo(targets.stream().map(RunnableEvent::getDirectory).collect(Collectors.toList())));

    }
}