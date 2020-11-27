package common;

import java.io.Serializable;

public class command implements Serializable {
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    private String command;
    public command(String command)
    {
        this.command = command;
    }
}
