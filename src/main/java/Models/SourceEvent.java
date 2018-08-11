package Models;

import java.nio.file.Path;
import java.util.Objects;

public class SourceEvent extends Event implements SetteableEvent{
    public SourceEvent() {
        super();
    }

    @Override
    public SourceEvent setDirectory(Path source) {
        this.source = source;
        return this;
    }

    @Override
    public SourceEvent setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    @Override
    public Path getDirectory() {
        return source;
    }

    @Override
    public String getExtension() {
        return extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceEvent that = (SourceEvent) o;
        return Objects.equals(source, that.source) &&
                Objects.equals(extension, that.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, extension);
    }

    @Override
    public String toString() {
        return "SourceEvent{" +
                "source=" + source +
                ", extension='" + extension + '\'' +
                '}';
    }
}
