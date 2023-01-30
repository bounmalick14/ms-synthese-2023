package ma.enset.billingservice.web;

import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.model.Customer;
import ma.enset.billingservice.repositories.BillRepository;
import ma.enset.billingservice.repositories.ProductItemRepository;
import ma.enset.billingservice.services.CustomerRestClient;
import ma.enset.billingservice.services.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping(path="/fullBill/{id}")
    public Bill bill(@PathVariable Long id){
      Bill bill=billRepository.findById(id).get();
      bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
      bill.getProductItems().forEach(pi->{
          pi.setProduit(productRestClient.findProductById(pi.getProductId()));
      });
      return bill;
    }
}
