package Models;

import Monitor.DirectoryMonitor.MoveCommand;
import Monitor.RunnableEvent.DirectoryTarget;
import Monitor.RunnableEvent.Target;
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

public class DirectoryTargetTest {
    private Set<Target> targets;

    @Before
    public void create(){
       targets = new HashSet<>();

    }

    @Test
    public void getDirectory() {
//
//        Path pone = Paths.get(System.getProperty("user.home"));
//        Path ptwo = Paths.get(System.getProperty("user.home"));
//        Path pthree = Paths.get(System.getProperty("user.home"));
//        Path pfour = Paths.get(System.getProperty("user.home"));
//
//        List<Path> paths =  new ArrayList<>();
//        paths.add(pone);
//        paths.add(ptwo);
//        paths.add(pthree);
//        paths.add(pfour);
//
//        DirectoryTarget one = new DirectoryTarget(pone, "txt", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//        DirectoryTarget two = new DirectoryTarget(ptwo, "pdf", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//        DirectoryTarget three = new DirectoryTarget(pthree, "doc", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//        DirectoryTarget four = new DirectoryTarget(pfour,"zip", new MoveCommand(Paths.get(System.getProperty("user.home"))));
//
//
//        targets.add(one);
//        targets.add(two);
//        targets.add(three);
//        targets.add(four);
//
//
//        paths.forEach(System.out::println);
//        assertThat(paths, equalTo(targets.stream().map(Target::getDirectory).collect(Collectors.toList())));

    }
}