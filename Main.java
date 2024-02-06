package myProjects;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String sessionAdminUsername;
    static int sessionAdminPassword;
    static int session = 0;
    static Data fileData;
    static Payment payment;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        fileData = new Data();
        payment = new Payment();

        ArrayList<Food> foodArrayList =new ArrayList<>();
        int foodIndex = 1;
        for (String foodPrice : fileData.FoodReturn().split(",")){
            switch (foodIndex){
                case 1:
                    foodArrayList.add(new Food("Pizza",Double.parseDouble(foodPrice)));
                    break;
                case 2:
                    foodArrayList.add(new Food("Hamburger",Double.parseDouble(foodPrice)));
                    break;
                case 3:
                    foodArrayList.add(new Food("Pastaa",Double.parseDouble(foodPrice)));
                    break;
                case 4:
                    foodArrayList.add(new Food("Chicken",Double.parseDouble(foodPrice)));
                    break;
                case 5:
                    foodArrayList.add(new Food("Salad",Double.parseDouble(foodPrice)));
                    break;
            }
            foodIndex++;
        }
        ArrayList<Admin> adminArrayList = new ArrayList<>();
        adminArrayList.add(new Admin("admin",123));
        firstChoose:
        while (true){
            int firstChoose = 0;
            if(session == 1) {
               firstChoose = 2;
            } else if (session==0) {
                System.out.println("WELCOME TO THE FOOD ORDER SYSTEM");
                System.out.println("OPTIONS DISPLAYING");
                System.out.println("1.FOOD MENU\n2.ADMIN LOGIN\n3.EXIT\n");
                firstChoose = input.nextInt();
            }
            if (firstChoose == 1){
                double total = 0;
                int again = 0;
                againChoose:
                while (again == 0){
                    System.out.println("Food Menu, Please Select your Food");
                    int foodOutIndex = 1;
                    for (Food foodobj : foodArrayList){
                        System.out.println("Press "+foodOutIndex + " for " + foodobj.getName() + " . Price is " + foodobj.getPrice());
                        foodOutIndex++;
                    }
                    System.out.println("What's your choose ?");
                    int CostumerChoosed = input.nextInt();
                    int piece = 0;

                    switch (CostumerChoosed){
                        case 1:
                            System.out.println("you Choose pizza. ");
                            System.out.println("how many pizza do you want to buy?");
                            piece = input.nextInt();

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(),piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed).getPrice(),piece);
                            System.out.println("Total Price is "+ total);
                            break;
                        case 2:
                            System.out.println("you Choose Hamburger. ");
                            System.out.println("how many Hamburger do you want to buy?");
                            piece = input.nextInt();

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(),piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed).getPrice(),piece);
                            System.out.println("Total Price is "+ total);
                            break;
                        case 3:
                            System.out.println("you Choose Pasta. ");
                            System.out.println("how many Pasta do you want to buy?");
                            piece = input.nextInt();

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(),piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed).getPrice(),piece);
                            System.out.println("Total Price is "+ total);
                            break;
                        case 4:
                            System.out.println("you Choose Chicken. ");
                            System.out.println("how many Chicken do you want to buy?");
                            piece = input.nextInt();

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(),piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed).getPrice(),piece);
                            System.out.println("Total Price is "+ total);
                            break;
                        case 5:
                            System.out.println("you Choose Salad. ");
                            System.out.println("how many pizza do you want to buy?");
                            piece = input.nextInt();

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(),piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed).getPrice(),piece);
                            System.out.println("Total Price is "+ total);
                            break;
                    }
                    System.out.println("Is there anything you want to add to your order?; if yes press 0 or no press 1");
                    again = input.nextInt();

                   // if(again == 1){
                        System.out.println("Please Choice your payment method ");
                        System.out.println("press 1 to pay with credit card, press 2 to pay with cash");
                        //int cash_or_card = 0;
                        int cash_or_card = input.nextInt();

                        //int card_password;
                        double cashAmount;
                        double change =0;
                        if(cash_or_card == 1){
                            System.out.println("please swipe the card. ");
                            System.out.println("process is in progress. Please wait....");
                            System.out.println("");
                            //System.out.println("please enter your card password: ");
                            //card_password = input.nextInt();
                            System.out.println("Loading.....");
                            System.out.println("Amount paid: " + total + " Process complited.");
                            System.out.println("Thaks for choosing us.");
                        } else if (cash_or_card==2) {
                            System.out.println("Please enter cash amount");
                            cashAmount = input.nextDouble();

                            double cashAmount2, newCashAmount;


                            if (cashAmount < total){
                                System.out.println("Not enough money");
                                double missingAmount = total - cashAmount;
                                System.out.println("missing amount is: "+missingAmount);
                                System.out.println("Pleas give me missing amount ");
                                cashAmount2 = input.nextDouble();
                                newCashAmount = cashAmount + cashAmount2;

                                if(newCashAmount >= total){
                                    change = newCashAmount - total;
                                    System.out.println("Change is "+ change +"Please take your change.");

                                } else if (newCashAmount == total) {
                                    System.out.println("Payment is completed.");

                                }else{
                                    System.out.println("wrong Choice.");
                                }
                            } else if (cashAmount==total) {
                                System.out.println("Payment is completed.");

                            }else {
                                change = cashAmount - total;
                                System.out.println("change is "+change+"Please take your change..");
                            }

                        }
                    }  if (firstChoose == 2) {
                        String username;
                        int password;
                        if(session == 0){
                            System.out.println("enter user name: ");
                            username = input.next();
                            controlFor:
                            for (Admin adminGelen : adminArrayList){
                                if (username.equals(adminGelen.getusername())){
                                    System.out.println("enter password: ");
                                    password =input.nextInt();
                                    if(password == adminGelen.getPassword()){
                                        sessionAdminUsername = adminGelen.getusername();
                                        sessionAdminPassword = adminGelen.getPassword();
                                        session = 1;
                                        break controlFor;
                                    }else{
                                        System.out.println("wrong password");
                                    }
                                }else {
                                    System.out.println("wronf user name:");
                                }
                            }
                        }
                        if (session == 1){
                            System.out.println("which product price do you want update ? ");
                            System.out.println("Enter 1 for Pizza");
                            System.out.println("Enter 2 for Hamburger");
                            System.out.println("Enter 3 for pasta");
                            System.out.println("Enter 4 for Chicken");
                            System.out.println("Enter 5 for salad");
                            System.out.println("Enter 6 for unsession");
                            System.out.println("Enter 7 for Exit");
                            int adminChoosed = input.nextInt();
                            double newPrice;
                            AdminPriceSwitch:
                            switch (adminChoosed){
                                case 1:
                                    System.out.println("enter new price for pizza");
                                    newPrice =input.nextDouble();
                                    fileData.FoodArr(adminChoosed, newPrice);
                                    break AdminPriceSwitch;


                                case 2:
                                    System.out.println("enter new price for Hamburger");
                                    newPrice =input.nextDouble();
                                    fileData.FoodArr(adminChoosed, newPrice);
                                    break AdminPriceSwitch;


                                case 3:
                                    System.out.println("enter new price for Pasta");
                                    newPrice =input.nextDouble();
                                    fileData.FoodArr(adminChoosed, newPrice);
                                    break AdminPriceSwitch;


                                case 4:
                                    System.out.println("enter new price for Chicken");
                                    newPrice =input.nextDouble();
                                    fileData.FoodArr(adminChoosed, newPrice);
                                    break AdminPriceSwitch;


                                case 5:
                                    System.out.println("enter new price for salad");
                                    newPrice =input.nextDouble();
                                    fileData.FoodArr(adminChoosed, newPrice);
                                    break AdminPriceSwitch;


                                case 6:
                                   session = 0;
                                   break AdminPriceSwitch;

                                case 7:
                                    System.exit(0);

                            }

                        }

                    } else if (firstChoose==3) {
                        System.out.println("Thank you");
                        break firstChoose;

                    }
                }
            }
        }
    }

