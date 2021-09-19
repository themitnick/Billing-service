package ca.themitnick.billingservice.services;

import ca.themitnick.billingservice.dto.InvoiceReqDTO;
import ca.themitnick.billingservice.dto.InvoiceResDTO;

import java.util.List;

public interface InvoiceService {

    InvoiceResDTO save(InvoiceReqDTO invoiceReqDTO);
    InvoiceResDTO getInvoice(String invoiceId);
    List<InvoiceResDTO> invoiceByCustomerId(String customerId);
}
