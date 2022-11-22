package machine;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine CoffeeMachine = new CoffeeMachine();
        CoffeeMachine.order();
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        // abchecken ob input exit ist, falls ja, program schliessen

        while (!Objects.equals(action, "exit")) {
            switch (action) {
                case "buy" -> {
                    String selection;
                    selection = CoffeeMachine.selection();
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
