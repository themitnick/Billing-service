package ca.themitnick.billingservice.web;

import ca.themitnick.billingservice.dto.InvoiceReqDTO;
import ca.themitnick.billingservice.dto.InvoiceResDTO;
import ca.themitnick.billingservice.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/invoice/{id}")
    public InvoiceResDTO getInvoice(@PathVariable(name = "id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }

    @PostMapping("/invoice")
    public InvoiceResDTO save(@RequestBody InvoiceReqDTO invoiceReqDTO){
        return invoiceService.save(invoiceReqDTO);
    }

    @GetMapping("/customer/{id}")
    public List<InvoiceResDTO> getInvoiceByCustomer(@PathVariable(name = "id") String customerId){
        return invoiceService.invoiceByCustomerId(customerId);
    }

    @GetMapping("/invoices")
    public List<InvoiceResDTO> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }
}
