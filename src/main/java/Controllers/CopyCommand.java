package Controllers;

import org.apache.logging.log4j.LogManager;

import java.nio.file.Path;

public class CopyCommand implements OperationCommand {
    private Path destination;

    public CopyCommand(Path destination) {
        this.destination = destination;
    }

    @Override
    public void execute() {
        LogManager.getLogger(this.getClass().getName()).debug("Copy " + destination);
        System.out.println("CopyOperationCommand");

    }
}
