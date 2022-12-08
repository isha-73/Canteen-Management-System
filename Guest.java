package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Guest {
    Scanner sc = new Scanner(System.in);
    String guestName;
    Menu menu = new Menu();
    PriorityQueue<Integer> prior = new PriorityQueue<>();
    float total;
    Guest next,right,left;
     int orderNum;
    ArrayList<String> orders ;
    Guest(){}
    Guest(String guestName,int num){  // on the call of this constructor , it will show the options for guest
        this.guestName = guestName;
        next=null;
        int choice=-1;
        orders= new ArrayList<>();
        while(choice!=0){
        System.out.println(" 0\t:Exit \n 1\t:View Menu \n 2\t:Place Order");
        choice= sc.nextInt();

            if (choice == 1) {
                   showMenu();  // to see the menu
            }
           else if(choice==2) {
                orderNum = num;
                placeOrder();  // to place Order
                deliverPriority(); // it works when food items have different priority and based on it , it will be delivered
                showOrderDetails(); // it will show order details to customer

            }else if(choice!=0&&choice!=1&&choice!=2){
                System.out.println("Invalid choice, try again.");
            }


        }

    }
    void showMenu(){
        menu.Populatemenu();
        System.out.println(menu.toString());
    }
     void placeOrder() { // function to place order
         menu.Populatemenu();
         int ref;
         char ch=' ';
         int quantity;
         float totalitem=0;
         int flag=-1;
         System.out.println("We are ready to take the order... \n What you want to order??");
         while(ch!='e'){
         System.out.println("Enter : \n 'd' : Drink\n 'a' : Appetizers\n 'i' : Indian\n 'c' : Chinese\n 'e' : Stop");
         ch = sc.next().charAt(0);
         if (ch == 'd'){
             System.out.println("Enter the reference number of the food you want to order : e.g 1 for 'Tea'..");
             ref = sc.nextInt();
             System.out.println("Quantity : 1,2,3,4 ????");
             quantity = sc.nextInt();
            totalitem=0;
             for(int i =0; i<menu.drinks.size(); i++){
               if(menu.drinks.get(i).refNum==ref) {
                   totalitem= (float) (totalitem+ quantity*menu.drinks.get(i).price);
                   total = (float) (total + quantity * menu.drinks.get(i).price);
                   System.out.println("Order of Reference " + ref+"  " + menu.drinks.get(i).name+" of sum " + totalitem+" is added.");
                   prior.add(menu.drinks.get(i).refNum);
                   flag=1;
                   break;
               }
                 flag=0;
             }
             if(flag==0){
             System.out.println("Entered reference id doesn't belong to preferred food type ,try again.");}

         }else if(ch == 'a'){
             System.out.println("Enter the reference number of the food you want to order : e.g 1 for 'Tea'..");
             ref = sc.nextInt();
             System.out.println("Quantity : 1,2,3,4 ????");
             quantity = sc.nextInt();
             totalitem=0;
             for(int i =0; i<menu.appetizers.size(); i++){
                 if(menu.appetizers.get(i).refNum==ref) {
                     totalitem= (float) (totalitem+ quantity*menu.appetizers.get(i).price);
                     total = (float) (total + quantity * menu.appetizers.get(i).price);
                     System.out.println("Order of Reference " + ref+"  " + menu.appetizers.get(i).name+" of sum " + totalitem+" is added.");
                     prior.add(menu.appetizers.get(i).refNum);
                     flag=1;
                     break;
                 } flag=0;
             }if(flag==0){
                 System.out.println("Entered reference id doesn't belong to preferred food type ,try again.");}

         }else if(ch == 'i'){
             System.out.println("Enter the reference number of the food you want to order : e.g 1 for 'Tea'..");
             ref = sc.nextInt();
             System.out.println("Quantity : 1,2,3,4 ????");
             quantity = sc.nextInt();
             totalitem=0;
             for(int i =0; i<menu.indian.size(); i++){
                 if(menu.indian.get(i).refNum==ref) {
                     totalitem= (float) (totalitem+ quantity*menu.indian.get(i).price);
                     total = (float) (total + quantity * menu.indian.get(i).price);
                     System.out.println("Order of Reference " + ref+"  " + menu.indian.get(i).name+" of sum " + totalitem+" is added.");
                     prior.add(menu.indian.get(i).refNum);
                     flag=1;
                     break;
                 }flag=0;
             }if(flag==0){
                 System.out.println("Entered reference id doesn't belong to preferred food type ,try again.");}

         }else if(ch == 'c'){
             System.out.println("Enter the reference number of the food you want to order : e.g 1 for 'Tea'..");
             ref = sc.nextInt();
             System.out.println("Quantity : 1,2,3,4 ????");
             quantity = sc.nextInt();
             totalitem=0;
             for(int i =0; i<menu.chinese.size(); i++){
                 if(menu.chinese.get(i).refNum==ref) {
                     totalitem= (float) (totalitem+ quantity*menu.chinese.get(i).price);
                     total = (float) (total + quantity * menu.chinese.get(i).price);
                     System.out.println("Order of Reference " + ref+"  " + menu.chinese.get(i).name+" of sum " + totalitem+" is added.");
                     prior.add(menu.chinese.get(i).refNum);
                     flag=1;
                     break;
                 }flag=0;
             }if(flag==0){
                 System.out.println("Entered reference id doesn't belong to preferred food type ,try again.");}

         }
         else if(ch!='e'&&ch!='a'&&ch!='d'&&ch!='i'&&ch!='c')System.out.println("Invalid character , try again!");
         }

    }

    void deliverPriority(){  // check each item and add in list according to priority
        while(!prior.isEmpty()) {
         int priority = prior.remove();
           for(int i =0;i<menu.appetizers.size();i++) {
               if(priority==menu.appetizers.get(i).refNum){
                   orders.add(menu.appetizers.get(i).name);
                   break;
               }
           }
           for(int i =0;i<menu.drinks.size();i++) {
               if(priority==menu.drinks.get(i).refNum){
                   orders.add(menu.drinks.get(i).name);
                   break;
               }
           }
            for(int i =0;i<menu.indian.size();i++) {
                if(priority==menu.indian.get(i).refNum){
                    orders.add(menu.indian.get(i).name);
                    break;
                }
            }
            for(int i =0;i<menu.chinese.size();i++) {
                if(priority==menu.chinese.get(i).refNum){
                    orders.add(menu.chinese.get(i).name);
                    break;
                }
            }
        }

    }
    void showOrderDetails(){
        if(orders.isEmpty()){
            System.out.println("There are nothing ordered yet!");
            return;
        }
        System.out.println("Your Order Number : "+orderNum);
        System.out.println(" Your Name : "+guestName);
        System.out.println(" Items Ordered by you : ");
        for(int i=0; i< orders.size();i++) {
            System.out.println((i+1)+" : "+orders.get(i));
        }
        System.out.println("Total Cost: "+total);
        System.out.println();
    }



}

