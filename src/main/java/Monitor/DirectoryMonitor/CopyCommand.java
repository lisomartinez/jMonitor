package Monitor.DirectoryMonitor;



public class CopyCommand extends FileCommand {
    private CommandReceiver fileCommandReceiver;

    @Override
    public void execute() {
        fileCommandReceiver.copy();
    }

    @Override
    public void setCommandReceiver(CommandReceiver commandReceiver) {
        this.fileCommandReceiver = commandReceiver;
    }


}
