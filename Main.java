package com.company;
import java.util.*;
import java.text.DecimalFormat;
class Item{
     Item(String category, String name, double price,int refNum,int quantity){
        // this constructor is used in guest
        // class to create an arraylist of specific orders
        this.category=category;
        this.name=name;
        this.price=price;
        this.refNum=refNum;
        this.quantity=quantity;
    }

}
class Items{
    //attributes
    double price;
    String name;
    String category;
    int refNum;
    int quantity;

    //constructor
    Items(String category, String name, double price,int refNum){
        this.category=category;
        this.name=name;
        this.price=price;
        this.refNum=refNum;
    }
     
    public String toString() {
        return refNum+".\t\t\t"+name + "\t\t"+"  "+ price +"\\-";
    }
}

class Menu{

    String order;
    char i;
    int count=1;

    ArrayList<Items> appetizers = new ArrayList<Items>();
    ArrayList<Items> chinese = new ArrayList<Items>();
    ArrayList<Items> indian = new ArrayList<Items>();
    ArrayList<Items> drinks = new ArrayList<Items>();

    public Items getAppetizer(int index) {
        return appetizers.get(index);
    }

    public Items getChinese(int index) {
        return chinese.get(index);
    }

    public Items getIndian(int index) {
        return indian.get(index);
    }

    public Items getDrinks(int index) {
        return drinks.get(index);
    }

    public String getAllAppetizers() {
        String aMenu="";
        aMenu += "\n\t\t\t\t\t  **** APPETIZERS **** \n";
        for(int i=0;i<appetizers.size();i++) {
            Items a = appetizers.get(i);
            aMenu += "\t\t\t " + a.toString() + "\n";

        }

        return aMenu;
    }

    public String getAllChinese() {
        String cMenu="";
        cMenu += "\n\t\t\t\t\t  **** CHINESE ***** \n";
        for(int i=0;i<chinese.size();i++) {
            Items a = chinese.get(i);
            cMenu += "\t\t\t " + a.toString() + "\n";

        }

        return cMenu;
    }

    public String getAllIndian() {
        String iMenu="";
        iMenu += "\n\t\t\t\t\t  **** INDIAN **** \n";
        for(int i=0;i<indian.size();i++) {
            Items a = indian.get(i);
            iMenu +=  "\t\t\t " + a.toString() + "\n";

        }

        return iMenu;
    }
    public String getAllDrinks() {
        String dMenu="";
        dMenu += "\n\t\t\t\t\t  **** DRINKS **** \n";
        for(int i=0;i<drinks.size();i++) {
            Items a = drinks.get(i);
            dMenu += "\t\t\t " + a.toString() + "\n";
        }
        return dMenu;
    }
    void Populatemenu() {
        //appetizers
        appetizers.add(new Items("Appetizer","Fruit Salad  ",60,4));
        appetizers.add(new Items("Appetizer","Manchow soup ",40, 5));
        appetizers.add(new Items("Appetizer","Khari Patties",15, 6));
        appetizers.add(new Items("Appetizer","French Fries ",40, 7));


        //chinese
        chinese.add(new Items("Chinese","Noodels   ",80, 16));
        chinese.add(new Items("Chinese","Manchurian",70, 15));
        chinese.add(new Items("Chinese","Chow Mein ",70, 14));

        //indian
        indian.add(new Items("Indian","Misal-pav",60, 8));
        indian.add(new Items("Indian","Poli-bhaji",100, 9));
        indian.add(new Items("Indian","Vada Pav",70, 10));
        indian.add(new Items("Indian","Poha     ",40, 11));
        indian.add(new Items("Indian","Idli     ",50, 12));
        indian.add(new Items("Indian","Dosa     ",50, 13));

        //drinks
        drinks.add(new Items("Drinks"," Tea     ",20, 1));
        drinks.add(new Items("Drinks","Coffee   ",40, 2));
        drinks.add(new Items("Drinks"," Soda    ",80, 3));


    }
    //to String
    //print out the whole menu in one string
    public String toString() {
        String menu = "";
        System.out.println("\t\t\t------------------------------------------------------");
        menu += "                                         CUMMINS CANTEEN MENU\n" +
                "                        ------------------------------------------------------\n"; 
        menu +="\n";
        menu +="    \t\t||REFERANCE.No||\t\t||FOOD||\t\t||PRICE||\n";
        menu += getAllDrinks();
        menu += getAllAppetizers();
        menu += getAllIndian();
        menu += getAllChinese();

        return menu;
    }
}
