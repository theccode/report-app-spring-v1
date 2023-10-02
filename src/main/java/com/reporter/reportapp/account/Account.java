package com.reporter.reportapp.account;

import com.reporter.reportapp.account.financial.FinancialAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "account_owner")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
    @Id
    private Long id;
    private String name;
    private String company;
    private String phone;
    private String email;
    private String address;
    private String banke_account;
    private String tax_registration;
    @ManyToOne
    private FinancialAccount financialAccount;
}
