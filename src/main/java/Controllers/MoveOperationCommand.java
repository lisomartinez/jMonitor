package Controllers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

public class MoveOperationCommand implements OperationCommand {
    private Path destination;

    public MoveOperationCommand(Path destination) {
        this.destination = destination;
    }

    @Override
    public void execute(Path source) {
        System.out.println("MoveOperationCommand");
    }
}
