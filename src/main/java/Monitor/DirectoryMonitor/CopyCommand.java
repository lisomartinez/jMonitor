package Monitor.DirectoryMonitor;



public class CopyCommand extends FileCommand {
    private CommandReceiver fileCommandReceiver;

    @Override
    public void execute() {
        fileCommandReceiver.copy();
    }

    @Override
    public Command setCommandReceiver(CommandReceiver commandReceiver) {
        this.fileCommandReceiver = commandReceiver;
        return this;
    }


}
