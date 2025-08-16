package com.example.tsu_jv250211_md04_session06_tonghop_controller.repository;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Customer;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Role;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

@Repository
public class CustomerRepository {
    public Customer login(String email, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        Customer customer = null;
        try {
            conn = ConnectionDB.getConnection();
            callSt = conn.prepareCall("{call login(?,?)}");
            callSt.setString(1, email);
            callSt.setString(2, password);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getLong("customer_id"));
                customer.setUsername(rs.getString("user_name"));
                customer.setPhoneNumber(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setGender(rs.getString("gender"));
                customer.setEmail(rs.getString("email"));
                customer.setRole(Role.valueOf(rs.getString("role")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return customer;
    }
}
