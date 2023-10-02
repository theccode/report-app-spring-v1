package com.reporter.reportapp.account.financial;

import com.reporter.reportapp.account.Account;
import jakarta.persistence.*;
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
public class FinancialAccount {
    @Id
    private Long id;
    private String code;
    private String name;
    private Long accountOwnerId;
    private Long parentId;
}
