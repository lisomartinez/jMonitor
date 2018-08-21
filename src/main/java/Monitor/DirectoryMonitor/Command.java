package Monitor.DirectoryMonitor;


public interface Command {
    void execute();
    void setCommandReceiver(CommandReceiver CommandReceiver);

}
