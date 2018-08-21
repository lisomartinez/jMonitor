package Monitor.DirectoryMonitor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class FileCommandReceiverTest {
    private FileCommandReceiver fileCommandReceiver;
    private Path path;
    private Path source;
    private Path copiedDestination;
    private Path movedDestination;
    private final static String FILENAME = "text.txt";


    @Before
    public void setUp() throws Exception {
        fileCommandReceiver = new FileCommandReceiver();
        path = Paths.get(System.getProperty("user.home"));
        source = Paths.get("src","test","files", FILENAME);
        Files.createFile(source);
        copiedDestination = Paths.get("src","test","files","copied");
        movedDestination = Paths.get("src","test","files","moved");
    }

    @After
    public void tearDown() throws Exception {
        Files.deleteIfExists(source);


        Files.deleteIfExists(copiedDestination.resolve(FILENAME));
        Files.deleteIfExists(movedDestination.resolve(FILENAME));
    }

    @Test
    public void copy() {
        Command cmd = new CopyCommand();
        fileCommandReceiver.setSource(source);
        fileCommandReceiver.setDestination(copiedDestination);
        cmd.setCommandReceiver(fileCommandReceiver);

        cmd.execute();
        assertThat(Files.exists(source), equalTo(true));
        assertThat(Files.exists(copiedDestination.resolve(FILENAME)), equalTo(true));
    }

    @Test
    public void move() {
        Command cmd = new MoveCommand();
        fileCommandReceiver.setSource(source);
        fileCommandReceiver.setDestination(movedDestination);
        cmd.setCommandReceiver(fileCommandReceiver);

        cmd.execute();
        assertThat(Files.exists(source), equalTo(false));
        assertThat(Files.exists(movedDestination.resolve(FILENAME)), equalTo(true));

    }

    @Test
    public void getSource() {
        fileCommandReceiver.setSource(path);
        assertThat(fileCommandReceiver.getSource(), equalTo(path));
    }

    @Test
    public void setSource() {
        fileCommandReceiver.setSource(path);
        assertThat(fileCommandReceiver.getSource(), equalTo(path));
    }

    @Test
    public void getDestination() {
        fileCommandReceiver.setDestination(path);
        assertThat(fileCommandReceiver.getDestination(), equalTo(path));
    }

    @Test
    public void setDestination() {
        fileCommandReceiver.setDestination(path);
        assertThat(fileCommandReceiver.getDestination(), equalTo(path));
    }
}