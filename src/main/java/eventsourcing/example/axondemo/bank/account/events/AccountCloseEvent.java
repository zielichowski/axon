package eventsourcing.example.axondemo.bank.account.events;

import lombok.Value;

@Value
public class AccountCloseEvent {
    private final String id;

    public AccountCloseEvent(String id) {
        this.id = id;
    }
}
