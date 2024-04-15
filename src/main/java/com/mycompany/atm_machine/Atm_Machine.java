package com.mycompany.atm_machine;


import java.util.Scanner;

/**
 *
 * @author Taimoor Manzoor
 */
public class Atm_Machine {

    float total_amount = 20000;

    public void Task1() {
        System.out.println("-------Welcome to ATM-------");
        System.out.println("Enter 1: Balance Enquiry");
        System.out.println("Enter  2 : Cash Transfer");
        System.out.println("Enter  3 : Withdraw Cash");
        System.out.println("Enter  4 : Deposit Cash");
        System.out.println("Enter  0 : Exit");

        Scanner inputs = new Scanner(System.in);
        int n = inputs.nextInt();
        switch (n) {
            case 1:
                System.out.println("Welcome to Balance Enquiry");
                break;
            case 2:
                System.out.println("Welcome to Cash Transfer");
                break;
            case 3:
                System.out.println("Welcome to Withdraw Cash");
                break;
            case 4:
                System.out.println("Welcome to Deposit Cash");
                break;
            case 0:
                System.out.println("ATM Exit");
                break;
            default:
                System.out.println("Incorrect Option");
                break;
        }
    }

    public void Task2() {
        int n = 1;
        while (n != 0) {
            System.out.println("-------Welcome to ATM-------");
            System.out.println("Enter 1: Balance Enquiry");
            System.out.println("Enter  2 : Cash Transfer");
            System.out.println("Enter  3 : Withdraw Cash");
            System.out.println("Enter  4 : Deposit Cash");
            System.out.println("Enter  0 : Exit");

            Scanner inputs = new Scanner(System.in);
            n = inputs.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Welcome to Balance Enquiry");
                    Balance_Inquiry();
                    break;
                case 2:
                    System.out.println("Welcome to Cash Transfer");
                    CashTransfer();
                    break;

                case 3:
                    System.out.println("Welcome to Withdraw Cash");
                    Withdraw();
                    break;

                case 4:
                    System.out.println("Welcome to Deposit Cash");
                    Deposit();
                    break;

                case 0:
                    System.out.println("ATM Exit");
                    break;
                default:
                    System.out.println("Incorrect Option");
                    break;
            }

        }
    }

    public void Balance_Inquiry() {
        System.out.println("Your Current Amount : " + total_amount + " Rs");
    }

    public void Deposit() {
        float deposit;
        System.out.println("How much money do you wanted to deposit?");
        Scanner inputs = new Scanner(System.in);
        deposit = inputs.nextFloat();
        if (deposit < 0) {
            System.out.println("Alert: Negative value is not Allow");
        } else {
            total_amount += deposit;
            System.out.println("Money has deposited sucessfully");
            Balance_Inquiry();
        }
    }

    public void Withdraw() {
        float withdraw;
        System.out.println("How much money do you wanted to withdraw?");
        Scanner inputs = new Scanner(System.in);
        withdraw = inputs.nextFloat();
        if (withdraw < 0) {
            System.out.println("Alert: Negative value is not Allow");
        } else {
            if (withdraw > total_amount) {
                System.out.println("Insufficient Balance. Unable to complete withdrawal");
            } else {
                total_amount -= withdraw;
                System.out.println("Money has withdraw sucessfully");
                Balance_Inquiry();
            }
        }
    }

    public void CashTransfer() {
        float CashTransfer;
        System.out.println("How much money do you wanted to Cash Transfer?");
        Scanner inputs = new Scanner(System.in);
        CashTransfer = inputs.nextFloat();
        if (CashTransfer < 0) {
            System.out.println("Alert: Negative value is not Allow");
        } else {
            if (CashTransfer > total_amount) {
                System.out.println("Insufficient Balance. Unable to complete CashTransfer");
            } else {
                total_amount -= CashTransfer;
                System.out.println("Money has Transfer sucessfully");
                Balance_Inquiry();
            }
        }
    }

    public static void main(String[] args) {

       Crude_Operation_Generic obj=new Crude_Operation_Generic();
       obj.MenuBar();
       
    }
      }
