package ca.themitnick.billingservice.mappers;

import ca.themitnick.billingservice.dto.InvoiceReqDTO;
import ca.themitnick.billingservice.dto.InvoiceResDTO;
import ca.themitnick.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface InvoiceMapper {

    Invoice invoiceReqDTOToInvoice(InvoiceReqDTO invoiceReqDTO);
    InvoiceResDTO invoiceToInvoiceResDTO(Invoice invoice);
}
