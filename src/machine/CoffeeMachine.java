package machine;
import java.util.Scanner;


public class CoffeeMachine {
     boolean  enoughWater;
    static boolean enoughBeans;
     boolean enoughMilk;
     boolean enoughCups;
    int machineMoney = 550;
     int espressoWater = 250;
    int espressoBeans = 16;
    int espressoPrice = 4;
    int machineWater = 400;
    int machineMilk = 540;
    int machineBeans = 120;
    int machineCups = 9;
    int numberOfCoffee = 1;
     int latteWater = 350;
     int latteMilk = 75;
     int latteBeans = 20;
     int lattePrice = 7;
     int cappuccinoWater = 200;
    int cappuccinoMilk = 100;
    int cappuccinoBeans = 12;
     int cappuccinoPrice = 6;
     Scanner scanner = new Scanner(System.in);


    private  void machine(int machineWater, int machineMilk, int machineMoney, int machineBeans, int machineCups) {
        System.out.println("The coffee machine has");
        System.out.println(machineWater + " " + "ml of water");
        System.out.println(machineMilk + " " + "ml of milk");
        System.out.println(machineBeans + " " + "g of coffee beans");
        System.out.println(machineCups + " " + "disposable cups");
        System.out.println("$" + machineMoney + " " + "of money");
    }
     void order(){
        System.out.println("Write action (buy, fill, take, remaining, exit)");
    }

    String selection(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        return scanner.nextLine();
    }

    void take(){
        System.out.println("I gave you" + machineMoney);
        machineMoney = 0;
    }
    void espresso(){
        enoughWater = machineWater >= espressoWater * numberOfCoffee;
        enoughBeans = machineBeans >= espressoBeans * numberOfCoffee;
        enoughCups = machineCups >= numberOfCoffee;
        if (enoughWater && enoughBeans  && enoughCups){
            System.out.println("I have enough resources, making you a coffee!");
            machineWater -= espressoWater * numberOfCoffee;
            machineBeans -= espressoBeans * numberOfCoffee;
            machineCups -= numberOfCoffee;
            machineMoney += espressoPrice * numberOfCoffee;
        }
        else{
            if (!enoughWater){
                System.out.println("Sorry not enough water");
            } else if (!enoughBeans) {
                System.out.println("Sorry not enough beans");

            } else {
                System.out.println("Sorry not enough cups");

            }
        }
    }

    void latte(){
        latteResources(latteWater, latteBeans, latteMilk, lattePrice);
    }

    private  void latteResources(int latteWater, int latteBeans, int latteMilk, int lattePrice) {
        enoughWater = machineWater >= latteWater * numberOfCoffee;
        enoughBeans = machineBeans >= latteBeans * numberOfCoffee;
        enoughCups = machineCups >= numberOfCoffee;
        enoughMilk = machineMilk >= latteMilk * numberOfCoffee;
        if (enoughWater && enoughBeans  && enoughCups && enoughMilk){
            System.out.println("I have enough resources, making you a coffee!");

            machineWater -= latteWater * numberOfCoffee;
            machineBeans -= latteBeans * numberOfCoffee;
            machineMilk -= latteMilk * numberOfCoffee;
            machineCups -= numberOfCoffee;

            machineMoney += lattePrice * numberOfCoffee;}
        else{
            if (!enoughWater){
                System.out.println("Sorry not enough water");
            } else if (!enoughBeans) {
                System.out.println("Sorry not enough beans");

            } else if (!enoughCups) {
                System.out.println("Sorry not enough cups");

            } else {
                System.out.println("sorry not enough milk");

            }

        }
    }
    void fill(){
        System.out.println("Write how many ml of water you want to add:");
        int waterFill = scanner.nextInt();
        machineWater += waterFill;
        System.out.println("Write how many ml of milk you want to add:");
        int milkFill = scanner.nextInt();
        machineMilk += milkFill;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beansFill = scanner.nextInt();
        machineBeans += beansFill;
        System.out.println("Write how many disposable cups you want to add:");
        int cupsFill = scanner.nextInt();
        machineCups += cupsFill;
    }
    void cappuccino(){
        latteResources(cappuccinoWater, cappuccinoBeans, cappuccinoMilk, cappuccinoPrice);
    }
    void remaining(){
        System.out.println("The coffee machine has");
        machine(machineWater, machineMilk, machineMoney, machineBeans, machineCups);
    }



}




