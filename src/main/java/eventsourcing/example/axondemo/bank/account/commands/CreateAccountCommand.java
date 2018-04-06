package eventsourcing.example.axondemo.bank.account.commands;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Slf4j
public class CreateAccountCommand {

    @TargetAggregateIdentifier
    public final String id;
    public final String accountCreator;

    public CreateAccountCommand(String id, String accountCreator) {
        this.id = id;
        this.accountCreator = accountCreator;

    }
}
