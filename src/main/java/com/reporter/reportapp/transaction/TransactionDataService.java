package com.reporter.reportapp.transaction;

import com.reporter.reportapp.account.balance.AccountBalance;
import com.reporter.reportapp.transaction.details.TransactionDetails;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class TransactionDataService {
    private final JdbcTemplate jdbcTemplate;
    public List<Transaction> getTransactions(Long id) {
        String sql = "SELECT * FROM transaction_details INNER JOIN transaction t on transaction_details.transaction_id = t.id LEFT JOIN account_balance ab ON ab.account_id = transaction_details.account_id RIGHT JOIN financial_account fa on transaction_details.account_id = fa.account_owner_id WHERE transaction_details.account_id = '" + id + "'";
        return jdbcTemplate.query(sql, mapTransactionDB());
    }

    private static RowMapper<Transaction> mapTransactionDB(){
        return ((rs, rowNo) ->{
            Long id = rs.getLong("id");
            Long transId = rs.getLong("account_id");
            Date date = rs.getDate("date");
            String supplierInvoiceNumber = rs.getString("supplier_invoice_number");
            Number amount = rs.getLong("amount");
            String description = rs.getString("description");
            String openBalance = rs.getString("open_balance");
            boolean isCredit = rs.getBoolean("is_credit");
            Long accountId = rs.getLong("account_id");
            Long transactionId = rs.getLong("transaction_id");
            Long customerProjectId = rs.getLong("customer_project_id");
            Long assetId = rs.getLong("asset_id");
            Long detailOrder = rs.getLong("detail_order");

            TransactionDetails transactionDetails = new TransactionDetails(id, amount, isCredit, accountId, transactionId, description, customerProjectId, assetId, detailOrder);
            AccountBalance accountBalance = new AccountBalance(openBalance);
            return new Transaction(transId, null, date, null, null, null, null, null, null, null, null, false, null, null, supplierInvoiceNumber, null, null, null, transactionDetails, accountBalance);
        });
    }
}
