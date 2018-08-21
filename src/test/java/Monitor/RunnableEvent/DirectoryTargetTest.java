package Monitor.RunnableEvent;

import Monitor.DirectoryMonitor.Command;
import Monitor.DirectoryMonitor.CopyCommand;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class DirectoryTargetTest {
    private DirectoryTarget directoryTarget;
    private Path path;

    @Before
    public void setUp() throws Exception {
        directoryTarget = new DirectoryTarget();
        path = Paths.get(System.getProperty("user.home"));
    }

    @Test
    public void match() {
    }

    @Test
    public void getCommand() {
        directoryTarget.command(new CopyCommand());
        Command command = directoryTarget.getCommand();
        assertThat(command, notNullValue());
    }

    @Test
    public void source() {
        directoryTarget.source(path);
        Path source = directoryTarget.getSource();
        assertThat(source, equalTo(path));
    }

    @Test
    public void destination() {
        directoryTarget.destination(path);
        Path destination = directoryTarget.getDestination();
        assertThat(destination, equalTo(path));
    }

    @Test
    public void extension() {
        directoryTarget.extension("txt");
        assertThat(directoryTarget.getExtension(), equalTo("txt"));
    }

    @Test
    public void command() {
        directoryTarget.command(new CopyCommand());
        Command command = directoryTarget.getCommand();
        assertThat(command, notNullValue());
    }

    @Test
    public void getDestination() {
        directoryTarget.destination(path);
        Path destination = directoryTarget.getDestination();
        assertThat(destination, equalTo(path));
    }

    @Test
    public void getSource() {
        directoryTarget.source(path);
        Path source = directoryTarget.getSource();
        assertThat(source, equalTo(path));
    }
}