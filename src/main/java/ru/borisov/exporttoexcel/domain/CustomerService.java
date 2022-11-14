package ru.borisov.exporttoexcel.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> exportCustomerToExcel(HttpServletResponse response) throws IOException {
        List<Customer> customers = customerRepository.findAll();
        ExcelExportUtil exportUtil = new ExcelExportUtil(customers);
        exportUtil.exportDataToExcel(response);

        return customers;
    }
}
