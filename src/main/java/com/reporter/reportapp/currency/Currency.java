package com.reporter.reportapp.currency;

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
public class Currency {
    @Id
    private Long id;
    private String name;
    private String code;
    private String symbol;
    private String country;
    private boolean isMain;
    private String fraction;
}
