package com.amigosode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

//    record Person(String name, int age, double savings){}

//    record GreetResponse(
//            String greet,
//            List<String> FavProgrammingLanguages,
//            Person person
//            ){} 

    record NewCostumerRequest(
            String name,
            Integer age,
            String email
            ){}

    @PostMapping
    public void addCustomer(@RequestBody NewCostumerRequest request)
    {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setAge(request.age);
        customer.setEmail(request.email);
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id)  {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void putCustomer(@PathVariable("customerId") Integer id, @RequestBody NewCostumerRequest request)
    {
        Customer customer = customerRepository.findById(id).get();
        customer.setEmail(request.email);
        customer.setName(request.name);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

//    class GreetResponse
//    {
//        private final String greet;
//
//        GreetResponse(String greet) {
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" + "greet='" + greet + "'" + "}";
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }
}

