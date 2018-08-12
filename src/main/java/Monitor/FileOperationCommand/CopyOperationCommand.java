package Monitor.FileOperationCommand;

import org.apache.logging.log4j.LogManager;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyOperationCommand implements FileOperationCommand {
    private Path monitoredDirectory:
    private Path destination;

    public CopyOperationCommand(Path destination) {
        this.destination = destination;
    }

    @Override
    public void execute(Path source) {
        Path pathToFile = destination.resolve(source.getFileName());


        try {
            Files.copy(source, pathToFile, REPLACE_EXISTING);
            LogManager.getLogger(this.getClass().getName()).debug(new StringBuilder().append("COPY: ").append(source).append(" TO ").append(pathToFile).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Path getMonitoredDirectory() {
        return monitoredDirectory;
    }

    public void setMonitoredDirectory(Path monitoredDirectory) {
        this.monitoredDirectory = monitoredDirectory;
    }

    public Path getDestination() {
        return destination;
    }

    public void setDestination(Path destination) {
        this.destination = destination;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CopyOperationCommand that = (CopyOperationCommand) o;
        return Objects.equals(monitoredDirectory, that.monitoredDirectory) &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monitoredDirectory, destination);
    }
}
