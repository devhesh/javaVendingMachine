javaVendingMachine
==================

Java Vending Machine
/*
 * A program that prints out vending machine choices to the user, receives input as to their selection,
 * receives input as to the amount paid by user, and determines their change (with denominations in $1 bills
 *  and coins). A sentinal value to end the program is also provided in the code below, as well as exception handling
 * for user input which cannot be used within the program.
 *  NOTE: This program does not keep inventory of the bills, change, or item inventory.
 */

/**
 *
 * @author Dev Heshmatpour, May 2013
 */

import java.util.Scanner;
import java.lang.Integer;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        String[] choices = {"(1): Chewing Gum ", "(2): Kit Kat  ", "(3): Snickers  ", "(4): Pop Tarts  "};
        int[] priceI = {40,75,80,95};
        String[] priceS = {"40","75","80","95"};
        Scanner input = new Scanner(System.in);
        int coin = 0;
        int add = 0;
        int change = 0;
        int cost,paid;//total cost, amount paid, difference of the 2
        int dollars,quarters,dimes,nickels,pennies;//denomination variables
        Scanner addi = new Scanner(System.in);
        Scanner insert = new Scanner(System.in);
        int selection = 0;
 
        while(selection != 4 ){
        System.out.println("Java Vending Machine");
        for (int c = 0; c < choices.length; c++){
                showMenu(choices[c], priceS[c]);
            }
        System.out.println("");
        System.out.println("Please make your selection 1, 2, 3, 4, or type 5 to EXIT");
        while (!input.hasNextInt())
        {
        input.next();
        System.err.print("Please enter a valid integer between 1-4 to purchase an item, or 5 to quit: ");
        }
        selection = input.nextInt()-1;
        if (selection == 4){
            System.out.println("Thanks for shopping with us today, come again!");
            System.exit(0);
        }
        while (selection > 4){
            System.err.print("Please enter a valid integer between 1-4 to purchase an item, or 5 to quit: ");
            selection = input.nextInt()-1;
            if (selection == 4){
            System.out.println("Thanks for shopping with us today, come again!");
            System.exit(0);
        }
            }
        menuSelect(choices[selection], priceI[selection]);
        paymentChange(priceI[selection],choices[selection]);
        }
        }
        
        /**Prints out user selection from menu of items, and gives them price
        * @param m A string value from an array of choices, based on user input
        * @param n An integer value from an array of choices, based on user input
        */
    private static void menuSelect (String m, int n){
        System.out.println("You've selected " + m + ". Please insert " +n +"¢ to purchase this item");
        }
        
         /** Prints out menu of items, and gives user the prices
        * @param x A String value from an array of choices, to be passed into a for loop
        * @param p A String value from an array of choices, to be passed into a for loop
        */
    private static void showMenu(String x, String p) {
        System.out.println(x + "--- " + p+"¢");;
    }
    
      /** Receives user input as to how much money has been inserted to purchase an item
        * and determines how much more is needed or how much changed is owed.
        * Also determines the denominations of $1 bills, quarters, dimes, nickels,
        * and pennies which are owed to the user. 
        * @param prix An Integer value based on user's selection, and fetched from an array
        * @param item An String value based on user's selection, and fetched from an array
        */
    public static int paymentChange(int prix, String item){
        int dollars,quarters,dimes,nickels,pennies;
        Scanner addi = new Scanner(System.in);
        Scanner insert = new Scanner(System.in);
        String itemName = item;
        int change = 0;
        int add = 0;
        int price = prix;
        int paid = insert.nextInt();
        System.out.println("You entered: " + paid + "¢ for "+itemName);
                  while (paid < price){
                      System.out.println("You must enter " + (price-paid) + "¢ more to complete your transaction. Please do so now");
                      System.out.println("Please enter additional change for your item: ");
                      add = addi.nextInt();
                      paid += add;
                  }
                      if (paid == price){
                      System.out.println("Thank you for your purchase! Please grab your item below, and continue shopping :)\n");
                      }
                      else if(paid > price){
                          change = paid - price;
                          System.out.printf("Change is: %d%n ", change);
                          pennies = (int)Math.round(change * 1);//convert change to pennies
                          dollars = pennies/100;
                          pennies = pennies % 100;//find remainder of pennies
                          quarters = pennies / 25;//find the number of quarters
                          pennies = pennies % 25;//find remainder of pennies
                          dimes = pennies / 10;//find the number of dimes
                          pennies = pennies % 10;//find remainder of pennies
                          nickels = pennies / 5;//find the number of nickels
                          pennies = pennies % 5;//find the remainder of pennies
                          System.out.printf("That is %d dollar bill(s) %d quarter(s), %d dime(s), " +
                           "%d nickel(s),and %d penny(s).\n",  dollars, quarters, dimes, nickels, pennies);
                          System.out.println("");
                    }
        return change;
    }
    }
