package com.reporter.reportapp.transaction.details;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "transaction_details")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDetails {
    @Id
    private Long id;
    private Number amount;
    private boolean isCredit;
    private Long accountId;
    private Long transactionId;
    private String description;
    private Long customerProjectId;
    private Long assetId;
    private Long detailOrder;
}
