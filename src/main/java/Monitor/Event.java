package Monitor;

import java.nio.file.Path;

public class Event {
    protected Path source;
    protected String extension;

    public Event(Path source, String extension) {
        this.source = source;
        this.extension = extension;
    }

    public Event() {
        this.source = null;
        this.extension = null;
    }

    public Path getDirectory() {
        return source;
    }

    public Event setDirectory(Path source) {
        this.source = source;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public Event setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", extension='" + extension + '\'' +
                '}';
    }
}
