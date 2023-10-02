package com.reporter.reportapp.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "transaction_type_custom_field")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionTypeAccount {
    @Id
    private Long id;
    private boolean credit;
    private Long transactionTypeId;
    private Long financialAccountId;
}