package ca.themitnick.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Invoice {

    @Id
    private String id;
    private Instant invoiceDate;
    private BigDecimal amount;
    private String customerId;
    @Transient
    private Customer customer;

}
