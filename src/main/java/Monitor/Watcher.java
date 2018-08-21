package Monitor;


import java.nio.file.Path;
import java.util.List;


public interface Watcher extends Runnable {
    void process();
    void registerTargets(List<Path> targetPaths);
}
