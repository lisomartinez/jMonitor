package Models;

import java.nio.file.Path;

public interface RunnableEvent{
    void runCommand();
    boolean match(SetteableEvent event);
    Path getDirectory();
}
