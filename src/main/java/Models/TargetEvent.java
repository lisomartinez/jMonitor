package Models;

import Controllers.OperationCommand;

import java.nio.file.Path;

public class TargetEvent extends Event implements RunnableEvent {

    private OperationCommand command;

    public TargetEvent(Path source, String extension, OperationCommand command) {
        super(source, extension);
        this.command = command;
    }

    @Override
    public boolean match(SetteableEvent event) {
        return source.equals(event.getDirectory()) && extension.equals(event.getExtension());

    }
    @Override
    public void runCommand() {
        command.execute();
    }

    @Override
    public Path getDirectory() {
        return super.getDirectory();
    }
}
