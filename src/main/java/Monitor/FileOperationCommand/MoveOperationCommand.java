package Monitor.FileOperationCommand;

import java.nio.file.Path;

public class MoveOperationCommand implements FileOperationCommand {
    private Path monitoredDirectory;
    private Path destination;

    public MoveOperationCommand(Path destination) {

        this.destination = destination;
    }

    @Override
    public void execute(Path source) {

        System.out.println("MoveOperationCommand");
    }

    @Override
    public void setMonitoredDirectory(Path monitoredDirectory) {
        this.monitoredDirectory = monitoredDirectory;
    }

}
