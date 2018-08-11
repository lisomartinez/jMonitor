package Models;

import Controllers.OperationCommand;

import java.util.List;

public interface RunnableEvent{
    void runCommands();
    boolean match(SourceEvent event);
    List<OperationCommand> getCommands();
}
