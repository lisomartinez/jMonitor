package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.nio.file.Path;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    private int id;

    @Column(name = "source")
    private Path source;

    @Column(name = "extension")
    private String extension;

    @Column(name = "command")
    private OperationCommand command;


    public Profile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Path getSource() {
        return source;
    }

    public void setSource(Path source) {
        this.source = source;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public OperationCommand getCommand() {
        return command;
    }

    public void setCommand(OperationCommand command) {
        this.command = command;
    }
}
