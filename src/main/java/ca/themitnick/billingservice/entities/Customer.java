package ca.themitnick.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Customer {
    private String customerId;
    private String name;
    private String email;
}
