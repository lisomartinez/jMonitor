package Models;

import java.nio.file.Path;

public class SourceEvent{
    private Path source;
    private String extension;

    public SourceEvent() {

    }

    public void setSource(Path source) {
        this.source = source;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Path getSource() {
        return source;
    }

    public String getExtension() {
        return extension;
    }
}
