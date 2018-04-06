package eventsourcing.example.axondemo.bank.account.events;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountCreatedEvent {
    public final String id;
    public final String accountCreator;
    public final double balance;

    public AccountCreatedEvent(String id, String accountCreator, double balance) {


        this.id = id;
        this.accountCreator = accountCreator;
        this.balance = balance;
    }
}
