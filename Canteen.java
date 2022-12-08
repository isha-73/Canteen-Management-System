package com.company;

import java.util.Scanner;

public class Canteen {  // In canteen class we have all the methods to be implemented by admin
    Guest front,rear;
    static Scanner call = new Scanner(System.in);
    Guest root=null;
    int count;

    void addCustomer(){  // this will add customers in the queue and also there data will be backed up in BST
        System.out.println("Enter your name please! ");
        String name = call.next();
        Guest customer = new Guest (name,++count); // new guest

        if(front==null){
            front=rear=customer;
            return;
        }
        rear.next=customer;
        rear=customer;
        saveCustomerData(customer); // calling BST function


    }
    void deliverOrder(){ // this function is to deque the customers

        if(front==null){
            System.out.println("There is no pending order!");
            return;
        }
        System.out.println("Order Number  \t\t Customer Name \t\t  Total cost ");
        System.out.println(front.orderNum+" \t\t "+front.guestName+" \t\t "+ front.total);
        System.out.println("----------------------SUCCESSFULLY DELIVERED--------------------");
        front=front.next;

    }
    void saveCustomerData(Guest newNode){ //saving the customers wrt to there order number
            if (root == null) {
                root = newNode;

                return;
            } else {
                Guest ptr = root;
                while (ptr != null) {
                    if (ptr.orderNum > root.orderNum) { //check order number
                        if (ptr.right == null) {
                            ptr.right = newNode;

                            break;
                        } else {
                            ptr = ptr.right;
                        }

                    } else if (ptr.orderNum < root.orderNum) {
                        if (ptr.left == null) {
                            ptr.left = newNode;
                            break;
                        } else {
                            ptr = ptr.left;
                        }
                    }

                }
            }

    }
    void displayinorder(Guest root) {//for displaying the data stored in the tree

        if(root!=null) {
            displayinorder(root.left);
            System.out.println(" Order Number : "+root.orderNum+" Name : "+root.guestName);
            System.out.println("Total Orders :");
            for(int i=0; i<root.orders.size(); i++){
                System.out.println(root.orders.get(i));
            }
            System.out.println("Total Cost : "+root.total);
            System.out.println();
            displayinorder(root.right);
        }

    }
    void displayOrders(){
        displayinorder(root);
    }

    public static void main(String[] args) {
        Canteen user = new Canteen();
        int choice =-1;
        System.out.println("\t\t WELCOME TO CUMMINS CANTEEN  ");
         while(choice!=0) {
             System.out.println("Enter : \n 1: if you are Customer \n 2: if you are Admin \n 0 : Exit");
             choice = call.nextInt();
             switch (choice) {

                 case 1: user.addCustomer();// this will start all the functions that are meant for customers
                            break;
                 case 2:int j=-1;           // this will start all the functions that are meant for admin
                     while(j!=0){
                         System.out.println("Enter : \n 1: Display Orders \n 2: Deliver Order \n 0: Exit");
                         j= call.nextInt();
                         switch(j){
                             case 1: user.displayOrders(); // to display Order details to admin
                                         break;
                             case 2: user.deliverOrder(); // to deliver Orders
                                        break;
                         }
                     }
             }
             if(choice==0){
                 System.out.println("Hope You Enjoyed Your Meal !\n We are always here to take care of you , Visit Again !!!");
             }
         }

    }
}
