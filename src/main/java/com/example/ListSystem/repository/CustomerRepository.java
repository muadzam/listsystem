package com.example.ListSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ListSystem.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
