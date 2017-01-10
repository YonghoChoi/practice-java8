package java8_in_action.chap06;

import lombok.Getter;

@Getter
public class Transaction{
    private final Trader trader;
    private int year;
    private int value;
    private Currency currency;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
        this.currency = new Currency();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}