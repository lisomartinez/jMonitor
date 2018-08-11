import Controllers.*;
import Models.Event;
import Models.RunnableEvent;
import Models.SetteableEventQueue;
import Models.TargetEvent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.lang.annotation.Target;
import java.net.URL;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {

        ObjectMapper objectMapper = new ObjectMapper();

        EventManager eventManager = EventManager.getEventManager();

       Path path = Paths.get("/Users/liso/test");



        Set<TargetEvent> targets = new HashSet<>();

        CopyCommand cmd1 = new CopyCommand(Paths.get("/Users/liso/Documents"));
        CopyCommand cmd2 = new CopyCommand(Paths.get("/Users/liso/Downloads"));


        TargetEvent targetEvent1 = new TargetEvent(path, "txt", cmd1);
        TargetEvent targetEvent2 = new TargetEvent(path, "txt", cmd2);

        targets.add(new TargetEvent(path, "txt", cmd1));
        targets.add(new TargetEvent(path, "txt", cmd2));


        eventManager.addTarget(new TargetEvent(path, "txt", cmd1));
        eventManager.addTarget(new TargetEvent(path, "txt", cmd2));

        SetteableEventQueue queue = new SetteableEventQueue();

        EventHandler eventHandler = new EventHandler(queue, eventManager.getTargets());

        Watcher watcher = new WatcherImpl(queue, FileSystems.getDefault());

        DirectoryMonitor directoryMonitor = new DirectoryMonitor(eventHandler, watcher);

        System.out.println(targets);
        TargetEvent targets1 = null;

        try  {

          objectMapper.writeValue(Files.newOutputStream(Paths.get(this.getClass().getResource("test.json").getPath())), targetEvent1);
       } catch (Exception ex ) {
           ex.printStackTrace();
       }

        try {
                targets1 = objectMapper.readValue(Files.newInputStream(Paths.get(this.getClass().getResource("test.json").getPath())), TargetEvent.class);

        } catch (Exception ex) {
ex.printStackTrace();
        }
        System.out.println(targets1);


//        directoryMonitor.start();
    }
}
