package Monitor.DirectoryMonitor;


public interface Command {
    void execute();
    Command setCommandReceiver(CommandReceiver CommandReceiver);

}
