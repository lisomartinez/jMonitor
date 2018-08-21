package Monitor.RunnableEvent;

import Monitor.DirectoryMonitor.Command;

import Monitor.Event;

import java.nio.file.Path;


public class DirectoryTargetEvent implements RunnableEvent {
    private Path source;
    private Path destination;
    private String extension;
    private Command command;

    public DirectoryTargetEvent() {
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
    public RunnableEvent setSource(Path source) {
        this.source = source;
        return this;
    }

    @Override
    public RunnableEvent setDestination(Path destination) {
        this.destination = destination;
        return this;
    }

    @Override
    public RunnableEvent setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    @Override
    public RunnableEvent setCommand(Command command) {
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
}
