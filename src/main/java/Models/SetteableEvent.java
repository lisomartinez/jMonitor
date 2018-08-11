package Models;

import java.nio.file.Path;

public interface SetteableEvent {
    Path getDirectory();
    String getExtension();
    SetteableEvent setDirectory(Path directory);
    SetteableEvent setExtension(String extension);
}
