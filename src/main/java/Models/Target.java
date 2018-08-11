package Models;

import Controllers.OperationCommand;

import java.nio.file.Path;
import java.util.List;

public class Target implements RunnableEvent {
    private int id;
    private Path source;
    private String extension;
    private List<OperationCommand> commands;

    public Target(Path source, String extension, List<OperationCommand> commands) {
        this.extension = extension;
        this.source = source;
        this.commands = commands;
    }


    public Path getSource() {
        return source;
    }


    public String getExtension() {
        return extension;
    }

    @Override
    public List<OperationCommand> getCommands() {
        return commands;
    }

    @Override
    public boolean match(SourceEvent event) {
        return false;

    }
    @Override
    public void runCommands() {
        commands.forEach(OperationCommand::execute);
    }
}
