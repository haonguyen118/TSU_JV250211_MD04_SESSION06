package com.example.tsu_jv250211_md04_session06_tonghop_controller.service;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Customer;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer login(String email,String password){
        return customerRepository.login(email,password);
    }
}
