package ca.themitnick.billingservice.dto;

import ca.themitnick.billingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor @AllArgsConstructor
public class InvoiceResDTO {

    private String id;
    private Instant invoiceDate;
    private BigDecimal amount;
    private Customer customer;

}
