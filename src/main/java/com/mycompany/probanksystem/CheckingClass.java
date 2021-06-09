/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.probanksystem;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Random;
import org.apache.commons.validator.routines.EmailValidator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Msi gl
 */
public class CheckingClass {
            static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            static BankAccount[] bankAccounts = new BankAccount[2000];
            static VIPBankAccount[] vipbankAccounts = new VIPBankAccount[2000];
            static long daysBetween;
            static long Remainingdays=0;
            static long RemainingdaysVIP=0;
            static int i; 
    
    
 /////}////////////////////////////////////////////////////////////////////////
 ///////////////////////ACCOUNT CREATION//////////////////////////////////////
   
    public static void getinputs(String name, String password, String emailAddress, double balance, double income,String phoneNumber){
        bankAccounts[i] = new BankAccount(name, password, emailAddress, balance ,income ,phoneNumber);
        vipbankAccounts[i]=new VIPBankAccount();
 
    }

    public static boolean checkPhonenumber(){
        boolean Pn;
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            try {
                phoneNumberUtil.parse(bankAccounts[i].getPhoneNumber(), null);
                return true;
                
            } catch (NumberParseException e) {
                return false;
            }
    }
    public static boolean checkPassword(){
          if (bankAccounts[i].getPassword().length() >= 8) {
              return true;
            }
            return false;
    }
    public static boolean checkEmail(){
        EmailValidator emailValidator= EmailValidator.getInstance();
         if(emailValidator.isValid(bankAccounts[i].getEmailAddress()))
         {
             return true;
         }
         else{
             return false;
         }
    }
    public static boolean checkBalance(){
         if(bankAccounts[i].getBalance() <= 0)
         {
             return false;
         }
         else{
             return true;
         }
    }
    public static boolean checkIncome(){
         if(bankAccounts[i].getIncome() <0){
             return false;
         }
         else{
             return true;
         }
    }
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////LOGIN///////////////////////////////////////////
 public static boolean getlogininputs(String email,String password ,int x){
        if(email.equals(bankAccounts[x].getEmailAddress()) && password.equals(bankAccounts[x].getPassword()))
        {
            return true;
        }
        else{
            return false;
        }
    }
///////////////////////////////////////////////////////////////////////////////
//////////////////////GETTING VARIABLES FROM CLASS/////////////////////////////
    public static void setAccountName(String a){
        bankAccounts[i].setName(a);
    }
    public static void setPhoneNumber(String a){
        bankAccounts[i].setPhoneNumber(a);
    }
    public static void setEmaiLAddress(String a){
        bankAccounts[i].setEmailAddress(a);
    }
    public static void setPassword(String a){
        bankAccounts[i].setPassword(a);
    }
    public static String getPassword(){
        return bankAccounts[i].getPassword();
    }
    public static String getAccountName(){
        return bankAccounts[i].getName();
    }
     public static String getPhoneNumber() {
        return bankAccounts[i].getPhoneNumber();
    } 

    public static String getEmailAddress() {
        return bankAccounts[i].getEmailAddress();
    }
    public static double getCCBalance(){
        return bankAccounts[i].getCreditCardBalance();
    }
    public static double getCCLimit(){
        return bankAccounts[i].getCreditCardLimit();
    }
    public static double getVIPCCBalance(){
        return vipbankAccounts[i].getCreditCardBalance();
    }
     public static double getVIPCCLimit(){
        return vipbankAccounts[i].getCreditCardLimit();
    }

    public static double getBalance() {
        return bankAccounts[i].getBalance();
    }


    public static double getIncome() {
        return bankAccounts[i].getIncome();
    }
    public static void getAccountNumber(int x){
        CheckingClass.i=x;
    }
    public static int getAccNumber(){
        return i;
    }
 //////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    public static void Withdrawbalance(double x){
        bankAccounts[i].WithdrawalBalance(x);
    }
    public static void Depositbalance(double x){
        bankAccounts[i].DepositBalance(x);
    }
    public static void DepositCCbalance(double x){
        bankAccounts[i].DepositCCBalance(x);
    }
    public static void DepositVIPCCbalance(double x){
        vipbankAccounts[i].DepositCCBalance(x);
    }
    
    
    public static String VIPorStandard(){
        if(bankAccounts[i].getBalance() > 500000){
            return("VIP Account");
        }
        else{
            return("Standard Account");
        }
    }

    public static void PurchaseVal(double x){
        bankAccounts[i].Purchase(x);
    }
    public static void PurchaseValVIP(double x){
        vipbankAccounts[i].Purchase(x);
    }
    public static void DateStatusStandard(String DateofPurchase){
        LocalDate DateIndept = LocalDate.parse(DateofPurchase,dtf);
        daysBetween = ChronoUnit.DAYS.between(DateIndept,LocalDate.now());
        RemainingdaysVIP=120-daysBetween;
        Remainingdays=60-daysBetween;
    }
    public static void TransferCash(int x,double Balance){
        bankAccounts[x].DepositBalance(Balance);
        bankAccounts[i].WithdrawalBalance(Balance);
    }
}
