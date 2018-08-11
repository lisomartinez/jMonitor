package Models;

import java.nio.file.Path;

public interface RunnableEvent{
    void runCommand(Path fullSourcePath);
    boolean match(SetteableEvent event);
    Path getDirectory();
}
