package machine;
import java.util.Objects;
import java.util.Scanner;


public class CoffeeMachine {
    static boolean  enoughWater;
    static boolean enoughBeans;
    static boolean enoughMilk;
    static boolean enoughCups;
    static int machineMoney = 550;
    static int espressoWater = 250;
    static int espressoBeans = 16;
    static int espressoPrice = 4;
    static int machineWater = 400;
    static int machineMilk = 540;
    static int machineBeans = 120;
    static int machineCups = 9;
    static int numberOfCoffee = 1;
    static int latteWater = 350;
    static int latteMilk = 75;
    static int latteBeans = 20;
    static int lattePrice = 7;
    static int cappuccinoWater = 200;
    static int cappuccinoMilk = 100;
    static int cappuccinoBeans = 12;
    static int cappuccinoPrice = 6;

    static Scanner scanner = new Scanner(System.in);


    private static void machine(int machineWater, int machineMilk, int machineMoney, int machineBeans, int machineCups) {
        System.out.println("The coffee machine has");
        System.out.println(machineWater + " " + "ml of water");
        System.out.println(machineMilk + " " + "ml of milk");
        System.out.println(machineBeans + " " + "g of coffee beans");
        System.out.println(machineCups + " " + "disposable cups");
        System.out.println("$" + machineMoney + " " + "of money");
    }
    private static void order(){
        System.out.println("Write action (buy, fill, take, remaining, exit)");
    }

    private static String selection(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        return scanner.nextLine();
    }

    private static  void take(){
        System.out.println("I gave you" + machineMoney);
        machineMoney = 0;
    }
    private static void espresso(){
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

    private static void latte(){
        latteResources(latteWater, latteBeans, latteMilk, lattePrice);
    }

    private static void latteResources(int latteWater, int latteBeans, int latteMilk, int lattePrice) {
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
    private static void fill(){
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
    private static void cappuccino(){
        latteResources(cappuccinoWater, cappuccinoBeans, cappuccinoMilk, cappuccinoPrice);
    }
    private static void remaining(){
        System.out.println("The coffee machine has");
        machine(machineWater, machineMilk, machineMoney, machineBeans, machineCups);
    }

    public static void main(String[] args) {
        CoffeeMachine.order();
        String action = scanner.nextLine();
        while (!Objects.equals(action, "exit")) {

            numberOfCoffee = 1;
            switch (action) {
                case "buy" -> {
                    String selection;
                    selection = selection();
                    switch (selection) {
                        case "1" -> CoffeeMachine.espresso();
                        case "2"-> CoffeeMachine.latte();
                        case "3" -> CoffeeMachine.cappuccino();
                        case "back" -> {}
                    }
                }
                case "exit" -> {
                }
                case "remaining" -> CoffeeMachine.remaining();

                case "fill" -> CoffeeMachine.fill();
                case "take" -> CoffeeMachine.take();
            }
            CoffeeMachine.order();
            action = scanner.nextLine();
        }

    }


}




