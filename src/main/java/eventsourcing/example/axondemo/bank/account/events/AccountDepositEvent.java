package eventsourcing.example.axondemo.bank.account.events;

import lombok.Value;

@Value
public class AccountDepositEvent {
    private final String id;
    private final double balance;

    public AccountDepositEvent(String id, double amount) {
        this.id = id;
        this.balance = amount;
    }
}
