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
public class TransactionTypeCustomFieldId {
    @jakarta.persistence.Id
    private Long Id;
    private String value;
    private Long transactionTypeCustomFieldId;
    private Long transactionTypeId;
}
