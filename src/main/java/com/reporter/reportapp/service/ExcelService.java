package com.reporter.reportapp.service;

import com.reporter.reportapp.account.financial.FinancialAccount;
import com.reporter.reportapp.account.financial.FinancialAccountRepository;
import com.reporter.reportapp.helper.ExcelHelper;
import com.reporter.reportapp.transaction.Transaction;
import com.reporter.reportapp.transaction.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    TransactionRepository repository;
    FinancialAccountRepository financialAccountRepository;
    public void save(MultipartFile file){
        System.out.println("FILE: " + file.getOriginalFilename());
        try {
            List<Transaction> transactions = ExcelHelper.excelTransaction(file.getInputStream());
//            List<FinancialAccount> financialAccounts = ExcelH
            System.out.println("Transaction: " +transactions);
            repository.saveAll(transactions);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store excel data: " + e.getMessage());
        }
    }

    public List<Transaction> getAllTransactions(){
        return repository.findAll();
    }
}
