/**
 * This is a Banking Controller class to invoke banking services to get Customer Summary and Total Interest Paid for all customers
 * Author : Tamal Kanti Ghose
 * Date:9/3/2023
 */
package com.abc.banking.controller;
import com.abc.banking.service.BankingService;
public class BankingController {
    private final BankingService bankingService;
    public BankingController(BankingService bankingService) {this.bankingService = bankingService;}
    public String getCustomerSummary() {return bankingService.customerSummary();}
    public double totalInterestPaid() {return bankingService.totalInterestPaid();}
}
