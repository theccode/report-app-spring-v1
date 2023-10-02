package com.reporter.reportapp.account;

import com.reporter.reportapp.account.financial.FinancialAccount;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountDataService {
    private final JdbcTemplate jdbcTemplate;
    public List<Account>  getAccountOwners(){
        String sql = "SELECT * FROM account_owner INNER JOIN financial_account fa on account_owner.id = fa.account_owner_id";
        return jdbcTemplate.query(sql, mapAccountFromDB());
    }

    private static RowMapper<Account> mapAccountFromDB(){
        return ((rs, rowNum) -> {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String company = rs.getString("company");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String bankAccount = rs.getString("banke_account");
            String taxRegistration = rs.getString("tax_registration");
            String code = rs.getString("code");
            String fname = rs.getString("name");
            FinancialAccount financialAccount = new FinancialAccount(null, code, null, null, null);
            return new Account(id, name, company, phone, email, address, bankAccount, taxRegistration, financialAccount);
        });
    }
}
