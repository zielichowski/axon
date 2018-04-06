package eventsourcing.example.axondemo.bank.account;

import eventsourcing.example.axondemo.bank.account.commands.CloseAccountCommand;
import eventsourcing.example.axondemo.bank.account.commands.CreateAccountCommand;
import eventsourcing.example.axondemo.bank.account.commands.DepositMoneyCommand;
import eventsourcing.example.axondemo.bank.account.commands.WithdrawMoneyCommand;
import eventsourcing.example.axondemo.bank.account.events.AccountCloseEvent;
import eventsourcing.example.axondemo.bank.account.events.AccountCreatedEvent;
import eventsourcing.example.axondemo.bank.account.events.AccountDepositEvent;
import eventsourcing.example.axondemo.bank.account.events.AccountWithdrawEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.springframework.util.Assert;

import java.io.Serializable;

@Aggregate
@Slf4j
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1l;


    @AggregateIdentifier
    private String id;
    private double balance;
    private String owner;

    public BankAccount() {
    }

    @CommandHandler
    public BankAccount(CreateAccountCommand command) {


        String id = command.id;
        String creator = command.accountCreator;

        Assert.hasLength(id, "Missing id");
        Assert.hasLength(creator, "Missing account creator");

        AggregateLifecycle.apply(new AccountCreatedEvent(id, creator, 0));
    }

    @EventSourcingHandler
    private void on(AccountCreatedEvent event) {


        this.id = event.id;
        this.balance = event.balance;
        this.owner = event.accountCreator;
    }

    @CommandHandler
    public void on(DepositMoneyCommand command) {

        if (command.amount > 0)
            AggregateLifecycle.apply(new AccountDepositEvent(command.id, command.amount));
    }

    @EventSourcingHandler
    private void on(AccountDepositEvent event) {
        this.balance += event.getBalance();
    }

    @CommandHandler
    private void on(WithdrawMoneyCommand command) {

        if (command.amount < 0)
            AggregateLifecycle.apply(new AccountWithdrawEvent(command.id, command.amount));
    }

    @EventSourcingHandler
    private void on(AccountWithdrawEvent event) {
        this.balance -= event.getAmount();
    }

    @CommandHandler
    private void on(CloseAccountCommand command){
        AggregateLifecycle.apply(new AccountCloseEvent(command.id));
    }

    @EventSourcingHandler
    private void on(AccountCloseEvent event){

        AggregateLifecycle.markDeleted();
    }
}
