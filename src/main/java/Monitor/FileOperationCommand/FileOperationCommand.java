package Monitor.FileOperationCommand;

import java.nio.file.Path;

public interface FileOperationCommand {

    void setMonitoredDirectory(Path monitoredDirectory);

    void execute(Path source);

}
