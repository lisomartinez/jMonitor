import Monitor.FileOperationCommand.CopyOperationCommand;
import Monitor.EventQueue;
import Monitor.RunnableEvent.DirectoryTargetEvent;
import Monitor.*;
import Monitor.DirectoryMonitor.DirectoryMonitor;
import Monitor.DirectoryMonitor.DirectoryWatcher;
import Monitor.FileOperationCommand.FileEventHandler;
import com.fasterxml.jackson.databind.ObjectMapper;


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



        Set<DirectoryTargetEvent> targets = new HashSet<>();

        CopyOperationCommand cmd1 = new CopyOperationCommand(Paths.get("/Users/liso/Documents"));
        CopyOperationCommand cmd2 = new CopyOperationCommand(Paths.get("/Users/liso/Downloads"));


        DirectoryTargetEvent directoryTargetEvent1 = new DirectoryTargetEvent(path, "txt", cmd1);
        DirectoryTargetEvent directoryTargetEvent2 = new DirectoryTargetEvent(path, "txt", cmd2);

        targets.add(new DirectoryTargetEvent(path, "txt", cmd1));
        targets.add(new DirectoryTargetEvent(path, "txt", cmd2));


        eventManager.addTarget(new DirectoryTargetEvent(path, "txt", cmd1));
        eventManager.addTarget(new DirectoryTargetEvent(path, "txt", cmd2));

        EventQueue queue = new EventQueue();

        FileEventHandler fileEventHandler = new FileEventHandler(queue, eventManager.getTargets());

        Watcher watcher = new DirectoryWatcher(queue, FileSystems.getDefault());

        DirectoryMonitor directoryMonitor = new DirectoryMonitor(fileEventHandler, watcher);

        System.out.println(targets);
        DirectoryTargetEvent targets1 = null;

        try  {

          objectMapper.writeValue(Files.newOutputStream(Paths.get(this.getClass().getResource("test.json").getPath())), directoryTargetEvent1);
       } catch (Exception ex ) {
           ex.printStackTrace();
       }

        try {
                targets1 = objectMapper.readValue(Files.newInputStream(Paths.get(this.getClass().getResource("test.json").getPath())), DirectoryTargetEvent.class);

        } catch (Exception ex) {
ex.printStackTrace();
        }
        System.out.println(targets1);


//        directoryMonitor.start();
    }
}
