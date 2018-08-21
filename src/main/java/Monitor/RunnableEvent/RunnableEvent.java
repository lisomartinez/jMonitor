package Monitor.RunnableEvent;

import Monitor.DirectoryMonitor.Command;
import Monitor.Event;

import java.nio.file.Path;

public interface RunnableEvent{
    Command getCommand();
    boolean match(Event event);
    RunnableEvent setSource(Path source);
    RunnableEvent setDestination(Path destination);
    RunnableEvent setExtension(String extension);
    RunnableEvent setCommand(Command command);
    Path getDestination();
    Path getSource();
}
