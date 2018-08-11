package Models;

import Controllers.OperationCommand;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.nio.file.Path;
import java.util.Objects;

public class TargetEvent extends Event implements RunnableEvent {

    private OperationCommand command;

    public TargetEvent(Path source, String extension, OperationCommand command) {
        super(source, extension);
        this.command = command;
    }


    public TargetEvent() {
    }

    @Override
    public boolean match(SetteableEvent event) {

        return source.equals(event.getDirectory().getParent()) && extension.equals(event.getExtension());

    }
    @Override
    public void runCommand(Path fullSourcePath) {
        command.execute(fullSourcePath);
    }

    @Override
    public Path getDirectory() {
        return super.getDirectory();
    }

    @Override
    public String toString() {
        return "TargetEvent{" +
                "source=" + source +
                ", extension=" + extension +
                ", command=" + command + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetEvent that = (TargetEvent) o;
        return Objects.equals(command, that.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }
}
