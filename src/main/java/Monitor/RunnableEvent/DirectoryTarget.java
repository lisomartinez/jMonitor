package Monitor.RunnableEvent;

import Monitor.DirectoryMonitor.Command;

import Monitor.Event;

import java.nio.file.Path;


public class DirectoryTarget implements Target {
    private Path source;
    private Path destination;
    private String extension;
    private Command command;

    public DirectoryTarget() {
    }

    @Override
    public boolean match(Event event) {

        return source.equals(event.getDirectory().getParent()) && extension.equals(event.getExtension());

    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public Target source(Path source) {
        this.source = source;
        return this;
    }

    @Override
    public Target destination(Path destination) {
        this.destination = destination;
        return this;
    }

    @Override
    public Target extension(String extension) {
        this.extension = extension;
        return this;
    }

    @Override
    public Target command(Command command) {
        this.command = command;
        return this;
    }

    @Override
    public Path getDestination() {
        return destination;
    }

    @Override
    public Path getSource() {
        return source;
    }

    @Override
    public String getExtension() {
        return extension;
    }
}
