package eventsourcing.example.axondemo.bank.account.commands;


import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CloseAccountCommand {
    @TargetAggregateIdentifier
    public final String id;

    public CloseAccountCommand(String id) {
        this.id = id;
    }
}
