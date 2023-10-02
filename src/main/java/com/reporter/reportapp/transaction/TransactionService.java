package com.reporter.reportapp.transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionDataService transactionDataService;
    public List<Transaction> getTransactions(Long id) {
        return transactionDataService.getTransactions(id);
    }
}
