package Controllers;

import Monitor.RunnableEvent.RunnableEvent;
import Monitor.EventQueue;
import Monitor.RunnableEvent.DirectoryTargetEvent;
import Monitor.DirectoryMonitor.DirectoryWatcher;
import Monitor.FileOperationCommand.MoveOperationCommand;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class WatcherImplTest {
    private DirectoryWatcher watcher;
    private Set<RunnableEvent> targets;

    private EventQueue queue;

    @Before
    public void create() {
        queue = new EventQueue();
        watcher = new DirectoryWatcher(queue, FileSystems.getDefault());
        targets = new HashSet<>();


    }

    @Test
    public void registerPath(){
        FileSystem fileSystem = FileSystems.getDefault();
        String homeDir = System.getProperty("user.home");
        StringBuilder folder = new StringBuilder();
        folder.append(homeDir);
        folder.append(fileSystem.getSeparator());
        folder.append("test");

        Path folderPath = Paths.get(folder.toString());

        DirectoryTargetEvent one = new DirectoryTargetEvent(Paths.get(folder.toString()), "txt", new MoveOperationCommand(Paths.get(System.getProperty("user.home"))));
        targets.add(one);

        Path path = Paths.get(System.getProperty("user.home"));
        watcher.registerTargets(targets);

    }


    @Test
    public void testProcess() {
        FileSystem fileSystem = FileSystems.getDefault();
        String homeDir = System.getProperty("user.home");
        StringBuilder folder = new StringBuilder();
        folder.append(homeDir);
        folder.append(fileSystem.getSeparator());
        folder.append("test");

        Path folderPath = Paths.get(folder.toString());
        Path path = Paths.get(folderPath.toString() + FileSystems.getDefault().getSeparator() + "text.txt");
        SourceEvent sourceEvent = new SourceEvent().setDirectory(folderPath).setExtension("txt");


        WatchEvent<Path> event = new WatchEvent<Path>() {
            @Override
            public Kind kind() {
                return ENTRY_CREATE;
            }

            @Override
            public int count() {
                return 0;
            }

            @Override
            public Path context() {
                return path;
            }
        };

        watcher.processEvent(event);

        assertThat(queue.getEvent(), equalTo(sourceEvent));

    }

}