import Monitor.DirectoryMonitor.CopyCommand;
import Monitor.EventQueue;
import Monitor.RunnableEvent.DirectoryTarget;
import Monitor.*;
import Monitor.DirectoryMonitor.DirectoryMonitor;
import Monitor.DirectoryMonitor.DirectoryWatcher;
import Monitor.DirectoryMonitor.FileEventHandler;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {

//        ObjectMapper objectMapper = new ObjectMapper();
//
//        EventManager eventManager = EventManager.getEventManager();
//
//       Path path = Paths.get("/Users/liso/test");
//
//
//
//        Set<DirectoryTarget> targets = new HashSet<>();
//
//        CopyCommand cmd1 = new CopyCommand(Paths.get("/Users/liso/Documents"));
//        CopyCommand cmd2 = new CopyCommand(Paths.get("/Users/liso/Downloads"));
//
//
//        DirectoryTarget directoryTarget1 = new DirectoryTarget(path, "txt", cmd1);
//        DirectoryTarget directoryTarget2 = new DirectoryTarget(path, "txt", cmd2);
//
//        targets.add(new DirectoryTarget(path, "txt", cmd1));
//        targets.add(new DirectoryTarget(path, "txt", cmd2));
//
//
//        eventManager.addTarget(new DirectoryTarget(path, "txt", cmd1));
//        eventManager.addTarget(new DirectoryTarget(path, "txt", cmd2));
//
//        EventQueue queue = new EventQueue();
//
//        FileEventHandler fileEventHandler = new FileEventHandler(queue, eventManager.getTargets());
//
//        Watcher watcher = new DirectoryWatcher(queue, FileSystems.getDefault());
//
//        DirectoryMonitor directoryMonitor = new DirectoryMonitor(fileEventHandler, watcher);
//
//        System.out.println(targets);
//        DirectoryTarget targets1 = null;
//
//        try  {
//
//          objectMapper.writeValue(Files.newOutputStream(Paths.get(this.getClass().getResource("test.json").getPath())), directoryTarget1);
//       } catch (Exception ex ) {
//           ex.printStackTrace();
//       }
//
//        try {
//                targets1 = objectMapper.readValue(Files.newInputStream(Paths.get(this.getClass().getResource("test.json").getPath())), DirectoryTarget.class);
//
//        } catch (Exception ex) {
//ex.printStackTrace();
//        }
//        System.out.println(targets1);
//

//        directoryMonitor.start();
    }
}
