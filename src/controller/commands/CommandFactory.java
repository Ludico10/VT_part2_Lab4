package controller.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {
    private static final CommandFactory instance = new CommandFactory();
    private static final Map<String, Command> commandsMap = new HashMap<>();

    private CommandFactory() {
        //add list of controller.commands here
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(String name) {
        return Optional.ofNullable(commandsMap.get(name));
    }
}
