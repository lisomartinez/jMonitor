package Controllers;

import java.nio.file.Path;

public interface OperationCommand {
    void execute(Path source);
}
