package com.example.demo.customer;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
  List<CustomerEntity> findByLastName(String lastName);
  CustomerEntity findById(long id);
  List<CustomerEntity> findByEmail(String email);
}
