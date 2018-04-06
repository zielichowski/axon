package eventsourcing.example.axondemo.bank.account.commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class WithdrawMoneyCommand {
    @TargetAggregateIdentifier
    public final String id;
    public final double amount;

    public WithdrawMoneyCommand(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}