package Controllers;

import Monitor.RunnableEvent.RunnableEvent;
import Monitor.EventQueue;
import Monitor.RunnableEvent.DirectoryTargetEvent;
import Monitor.EventManager;
import Monitor.FileOperationCommand.FileEventHandler;
import Monitor.FileOperationCommand.MoveOperationCommand;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileEventHandlerTest {
    private EventManager eventManager;
    private FileEventHandler fileEventHandler;
    private SourceEvent sourceEvent;

    @Before
    public void create(){
        eventManager = EventManager.getEventManager();

        Set<RunnableEvent> targets = new HashSet<>();
        DirectoryTargetEvent one = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "txt", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent two = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "pdf", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent three = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "doc", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        DirectoryTargetEvent four = new DirectoryTargetEvent(Paths.get(System.getProperty("user.home")), "zip", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));

        targets.add(one);
        targets.add(three);
        targets.add(four);

        eventManager.addTarget(one);
        eventManager.addTarget(three);
        eventManager.addTarget(four);

        sourceEvent = new SourceEvent();
        sourceEvent.setDirectory(Paths.get(System.getProperty("user.home")));
        sourceEvent.setExtension("txt");

        EventQueue queue = new EventQueue();

        fileEventHandler = new FileEventHandler(queue, targets);
    }

    @Test
    public void handleEvent() {



        fileEventHandler.handle();
    }



}