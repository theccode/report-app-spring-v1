package com.reporter.reportapp.account.balance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "financial_account")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountBalance {
    @Id
    private Long id;
    private String openBalance;

    public AccountBalance(String openBalance){
        this.openBalance = openBalance;
    }
}
