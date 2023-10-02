package com.reporter.reportapp.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reporter.reportapp.account.balance.AccountBalance;
import com.reporter.reportapp.transaction.details.TransactionDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@Table(name = "account_owner")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {
    @Id
    private Long id;
    private String description;
    private Date date;
    private Long typeId;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastMofifiedDate;
    private Long currencyRateId;
    private Long reference;
    private Long fiscalYearId;
    private boolean mounted;
    private Long oldReference;
    private Date dateValue;
    private String supplierInvoiceNumber;
    private Number discount;
    private Number status;
    private Date dateStatus;
    @ManyToOne
    private TransactionDetails transactionDetails;
    @ManyToOne
    private AccountBalance accountBalance;
}
