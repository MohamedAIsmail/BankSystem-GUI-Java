/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.probanksystem;

/**
 *
 * @author Msi gl
 */
public class VIPBankAccount extends BankAccount {
    private double CreditCardLimit;
    private double CreditCardBalance;
    
    public VIPBankAccount() {
    super(CheckingClass.getAccountName(),CheckingClass.getPassword(),CheckingClass.getEmailAddress(),CheckingClass.getBalance(),CheckingClass.getIncome(),CheckingClass.getPhoneNumber());
    CreditCardLimit=20000;
    CreditCardBalance=20000;
    }
    
    public double getCreditCardLimit() {
        return CreditCardLimit;
    }
    public double getCreditCardBalance() {
        return CreditCardBalance;
    }
    public void DepositCCBalance(double x){
        CreditCardBalance += x;
    }    
    public void Purchase(double x){
        CreditCardBalance -=x;
    }
}
