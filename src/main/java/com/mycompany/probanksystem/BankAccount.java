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
public class BankAccount {
     private String name;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private double balance;
    private double income;
    private double creditCardLimit;
    private double creditCardBalance;
    ////////////////////////////////////CONSTRUCTOR////////////////////////////
    /////////////////////////////////////////////////////////////////////////// 
     public BankAccount(String name, String password, String emailAddress, double balance, double income,String phoneNumber) {
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.balance = balance;
        this.income = income;
        this.phoneNumber=phoneNumber;
        this.creditCardLimit= 10000.0;
        this.creditCardBalance=creditCardLimit;
        
    }
    ///////////////////////////////////SETTERS AND GETTERS/////////////////////
     /////////////////////////////////////////////////////////////////////////
     public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


       
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

  

    public String getEmailAddress() {
        return emailAddress;
    }


    public double getBalance() {
        return balance;
    }

    public double getCreditCardLimit() {
        return creditCardLimit;
    }
    public double getCreditCardBalance() {
        return creditCardBalance;
    }

    public double getIncome() {
        return income;
    }
    /////////////////////////////////OPERATIONS/////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public void WithdrawalBalance(double x){
        balance=balance-x;
    }
    public void DepositBalance(double x){
        balance=balance+x;
    }
    public void DepositCCBalance(double x){
        creditCardBalance += x;
    }
    public void Purchase(double x){
        creditCardBalance -=x;
    }
   
}
