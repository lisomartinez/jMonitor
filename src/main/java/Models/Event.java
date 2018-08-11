package Models;

import java.nio.file.Path;

public abstract class Event {
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
    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", extension='" + extension + '\'' +
                '}';
    }
}
