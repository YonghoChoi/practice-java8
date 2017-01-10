package java8_in_action.chap06;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class DiffImperativeAndFunctional {
    List<Transaction> transactions;

    @Before
    public void setUp() throws Exception {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    public void testCurrencyUsingCollection() {
        // 그룹화한 트랜잭션을 저장할 맵을 생성.
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

        for(Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();	// 트랜잭션의 통화 추출.
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);

            // 현재 통화를 그룹화하는 맵에 항목이 없으면 항목을 만든다.
            if(transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }

            // 같은 통화를 가진 트랜잭션 리스트에 현재 탐색 중인 트랙잭션 추가.
            transactionsForCurrency.add(transaction);
        }

        System.out.println(transactionsByCurrencies);
    }

    @Test
    public void testCurrencyUsingStream() {
        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(groupingBy(Transaction::getCurrency));

        System.out.println(transactionsByCurrencies);
    }
}
