package ca.themitnick.billingservice.services.impl;

import ca.themitnick.billingservice.dto.InvoiceReqDTO;
import ca.themitnick.billingservice.dto.InvoiceResDTO;
import ca.themitnick.billingservice.entities.Customer;
import ca.themitnick.billingservice.entities.Invoice;
import ca.themitnick.billingservice.mappers.InvoiceMapper;
import ca.themitnick.billingservice.openfeign.CustomerRestClient;
import ca.themitnick.billingservice.repositories.InvoiceRepository;
import ca.themitnick.billingservice.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CustomerRestClient customerRestClient;

    @Override
    public InvoiceResDTO save(InvoiceReqDTO invoiceReqDTO) {
        Invoice invoice = invoiceMapper.invoiceReqDTOToInvoice(invoiceReqDTO);
        invoice.setId(UUID.randomUUID().toString());
        Invoice invoiceSave = invoiceRepository.save(invoice);

        return invoiceMapper.invoiceToInvoiceResDTO(invoiceSave);
    }

    @Override
    public InvoiceResDTO getInvoice(String invoiceId) {

        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        //Call customerRestClient to retrieve customer data
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setInvoiceDate(new Date());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResDTO(invoice);
    }

    @Override
    public List<InvoiceResDTO> invoiceByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);

        return invoices.stream()
                .map(invoice -> invoiceMapper.invoiceToInvoiceResDTO(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResDTO> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        invoices.forEach(invoice -> {
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        });
        return invoices.stream()
                .map( invoice -> invoiceMapper.invoiceToInvoiceResDTO(invoice))
                .collect(Collectors.toList());
    }
}
