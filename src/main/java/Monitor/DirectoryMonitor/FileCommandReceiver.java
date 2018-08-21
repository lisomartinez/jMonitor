package Monitor.DirectoryMonitor;

import org.apache.logging.log4j.LogManager;

import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class FileCommandReceiver implements CommandReceiver {
    private Path source;
    private Path destination;


    @Override
    public void copy() {
        Path pathToFile = destination.resolve(source.getFileName());
        try {
            Files.copy(source, pathToFile, REPLACE_EXISTING);
            LogManager.getLogger(this.getClass().getName()).debug(new StringBuilder().append("COPY: ").append(source).append(" TO ").append(pathToFile).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void move() {
        Path pathToFile = destination.resolve(source.getFileName());
        try {
            Files.move(source, pathToFile, REPLACE_EXISTING);
            LogManager.getLogger(this.getClass().getName()).debug(new StringBuilder().append("MOVE: ").append(source).append(" TO ").append(pathToFile).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Path getSource() {
        return source;
    }

    public void setSource(Path source) {
        this.source = source;
    }

    public Path getDestination() {
        return destination;
    }

    public void setDestination(Path destination) {
        this.destination = destination;
    }
}
