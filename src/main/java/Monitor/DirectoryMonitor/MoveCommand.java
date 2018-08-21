package Monitor.DirectoryMonitor;

public class MoveCommand implements Command {
    private CommandReceiver fileCommandReceiver;

    @Override
    public void execute() {
        fileCommandReceiver.move();
    }

    @Override
    public Command setCommandReceiver(CommandReceiver commandReceiver) {
        this.fileCommandReceiver = commandReceiver;
        return this;
    }
}
