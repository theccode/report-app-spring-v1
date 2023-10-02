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
public class TransactionType {
    @jakarta.persistence.Id
    private Long Id;
    private String name;
    private boolean isTaxable;
    private String prefix;
    private boolean hasDetails;
    private boolean hasText;
    private Long categoryId;
    private Long realTypeId;
    private boolean hasDateValue;
    private boolean projectBase;
    private boolean detailedDescription;
    private boolean productProjectBase;
    private boolean withStatus;
}
