package ca.themitnick.billingservice.repositories;

import ca.themitnick.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

    List<Invoice> findByCustomerId(String id);
}
