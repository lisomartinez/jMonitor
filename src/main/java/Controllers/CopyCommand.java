package Controllers;

import org.apache.logging.log4j.LogManager;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyCommand implements OperationCommand {
    private Path destination;

    public CopyCommand(Path destination) {
        this.destination = destination;
    }

    @Override
    public void execute(Path source) {
        Path pathToFile = destination.resolve(source.getFileName());
        LogManager.getLogger(this.getClass().getName()).debug(new StringBuilder().append("COPY: ").append(source).append(" TO ").append(pathToFile).toString());
        try {
            Files.copy(source, pathToFile, REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CopyCommand{" +
                "destination=" + destination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CopyCommand that = (CopyCommand) o;
        return Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }
}
