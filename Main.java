package com.company;
import java.util.*;
class Items{
    //attributes
    double price;
    String name;
    String category;
    int refNum;

    //constructor
    Items(String category, String name, double price,int refNum){
        this.category=category;
        this.name=name;
        this.price=price;
        this.refNum=refNum;
    }

    public String toString() {
        return refNum+"\t\t\t"+name + "\t\t\t" + price + "\\-";
    }
}
//class menu for creating the menu
class Menu{
    //attributes of class
    String order;
    char i;
    int quantity;
    int count=1;
    //Creating arrray list for storing different types of menu
    ArrayList<Items> appetizers = new ArrayList<Items>();
    ArrayList<Items> chinese = new ArrayList<Items>();
    ArrayList<Items> indian = new ArrayList<Items>();
    ArrayList<Items> drinks = new ArrayList<Items>();
    
    //method for returning appetizer menu
    public Items getAppetizer(int index) {
        return appetizers.get(index);
    }
    //method for returning chinese menu
    public Items getChinese(int index) {
        return chinese.get(index);
    }
    //method for returning Indian menu
    public Items getIndian(int index) {
        return indian.get(index);
    }
    //method for returning Drink menu
    public Items getDrinks(int index) {
        return drinks.get(index);
    }
   
    public String getAllAppetizers() {
        String aMenu="";
        aMenu += "\n\t**** APPETIZERS **** \n";
        for(int i=0;i<appetizers.size();i++) {
            Items a = appetizers.get(i);
            aMenu += " " + a.toString() + "\n";

        }

        return aMenu;
    }

    public String getAllChinese() {
        String cMenu="";
        cMenu += "\n\t**** CHINESE ***** \n";
        for(int i=0;i<chinese.size();i++) {
            Items a = chinese.get(i);
            cMenu += " " + a.toString() + "\n";

        }

        return cMenu;
    }

    public String getAllIndian() {
        String iMenu="";
        iMenu += "\n\t**** INDIAN **** \n";
        for(int i=0;i<indian.size();i++) {
            Items a = indian.get(i);
            iMenu +=  " " + a.toString() + "\n";

        }

        return iMenu;
    }
    public String getAllDrinks() {
        String dMenu="";
        dMenu += "\n\t**** DRINKS **** \n";
        for(int i=0;i<drinks.size();i++) {
            Items a = drinks.get(i);
            dMenu += " " + a.toString() + "\n";
        }
        return dMenu;
    }
    void Populatemenu() {
        //appetizers
        appetizers.add(new Items("Appetizer"," Fruit Salad",60,4));
        appetizers.add(new Items("Appetizer","Manchow soup",40, 5));
        appetizers.add(new Items("Appetizer","Khari Patties",15, 6));
        appetizers.add(new Items("Appetizer","French Fries",40, 7));


        //chinese
        chinese.add(new Items("Chinese","   Noodels",80, 16));
        chinese.add(new Items("Chinese","Manchurian",70, 15));
        chinese.add(new Items("Chinese","Chow Mein",70, 14));

        //indian
        indian.add(new Items("Indian","Misal-pav",60, 8));
        indian.add(new Items("Indian","Poli-bhaji",100, 9));
        indian.add(new Items("Indian","Vada Pav",70, 10));
        indian.add(new Items("Indian","Poha",40, 11));
        indian.add(new Items("Indian","Idli",50, 12));
        indian.add(new Items("Indian","Dosa",50, 13));

        //drinks
        drinks.add(new Items("Drinks"," Tea",20, 1));
        drinks.add(new Items("Drinks","Coffee",40, 2));
        drinks.add(new Items("Drinks"," Soda",80, 3));


    }
    //to String
    //print out the whole menu in one string
    public String toString() {
        String menu = "";
        System.out.println("----------------------------");
        menu += "    CUMMINS CANTEEN MENU\n" +
                "----------------------------\n";
        menu += getAllDrinks();
        menu += getAllAppetizers();
        menu += getAllIndian();
        menu += getAllChinese();

        return menu;
    }
}


