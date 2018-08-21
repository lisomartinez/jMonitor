package Monitor.RunnableEvent;

import Monitor.DirectoryMonitor.Command;
import Monitor.Event;

import java.nio.file.Path;

public interface Target {
    Command getCommand();
    boolean match(Event event);
    Target source(Path source);
    Target destination(Path destination);
    Target extension(String extension);
    Target command(Command command);
    Path getDestination();
    Path getSource();
    String getExtension();
}
