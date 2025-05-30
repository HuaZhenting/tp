package command;

import event.EventManager;
import exception.SyncException;
import participant.ParticipantManager;
import ui.UI;
import java.util.logging.Logger;

/**
 * Represents a command to display the help menu to the user.
 * The help menu contains information on how to interact with the application.
 */
public class HelpCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(HelpCommand.class.getName());

    /**
     * Executes the help command, which displays the help menu to the user.
     *
     * @param events the EventManager instance that manages the events
     * @param ui the UI instance used to display messages to the user
     * @param participants the ParticipantManager instance that manages participants
     * @throws SyncException if an error occurs during the execution of the command
     */
    @Override
    public void execute(EventManager events, UI ui, ParticipantManager participants) throws SyncException {
        assert ui != null : "UI cannot be null";
        LOGGER.info("Displaying help menu");
        ui.showMenu();
    }
}
