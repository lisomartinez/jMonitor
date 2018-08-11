package Controllers;

import DAO.CollectionDao;
import Models.RunnableEvent;
import Models.SourceEvent;
import Models.Target;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EventHandlerTest {
    private EventManager eventManager;
    private EventHandler eventHandler;
    private SourceEvent sourceEvent;

    @Before
    public void create(){
        eventManager = EventManager.getEventManager();

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

        sourceEvent = new SourceEvent();
        sourceEvent.setSource(Paths.get(System.getProperty("user.home")));
        sourceEvent.setExtension("txt");

        eventHandler = new EventHandler(eventManager.getTargets());


    }

    @Test
    public void handleEvent() {
        eventHandler.handleEvent(sourceEvent);
    }
}