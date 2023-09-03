/**
 * This is a Customer Controller class to invoke customer services like opening accounts, deposit/withdraw amount
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.controller;
import com.abc.banking.model.*;
import com.abc.banking.service.CustomerService;

public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    public boolean openAccount(Account account) {
       return  customerService.openAccount(account);
    }
    public void deposit(Account account,double amount) {
        customerService.deposit(account,amount);
    }
    public void withdraw(Account account,double amount) {
        customerService.withdraw(account,amount);
    }
    public String getStatement(Customer customer) {
      return  customerService.getStatement(customer);
    }
}
