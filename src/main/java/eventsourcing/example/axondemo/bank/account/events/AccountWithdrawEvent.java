package eventsourcing.example.axondemo.bank.account.events;

import lombok.Value;

@Value
public class AccountWithdrawEvent {
    private final String id;
    private final double amount;

    public AccountWithdrawEvent(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}
