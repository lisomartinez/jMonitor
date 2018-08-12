package Monitor.RunnableEvent;

import Monitor.Event;

import java.nio.file.Path;

public interface RunnableEvent{
    void runCommand(Path fullSourcePath);
    boolean match(Event event);
    Path getDirectory();
}
