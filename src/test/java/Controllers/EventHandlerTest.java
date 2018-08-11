package Controllers;

import Models.RunnableEvent;
import Models.SourceEvent;
import Models.SetteableEventQueue;
import Models.TargetEvent;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class EventHandlerTest {
    private EventManager eventManager;
    private EventHandler eventHandler;
    private SourceEvent sourceEvent;

    @Before
    public void create(){
        eventManager = EventManager.getEventManager();

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

        sourceEvent = new SourceEvent();
        sourceEvent.setDirectory(Paths.get(System.getProperty("user.home")));
        sourceEvent.setExtension("txt");

        SetteableEventQueue queue = new SetteableEventQueue();

        eventHandler = new EventHandler(queue, targets);
    }

    @Test
    public void handleEvent() {



        eventHandler.handle();
    }



}