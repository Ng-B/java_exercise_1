import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    public static int displayFibonacci(int num){
        if (num <= 1)
            return num;
        return displayFibonacci(num-1) + displayFibonacci(num-2);
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Nombre à utiliser ?");
        Integer num = scanner.nextInt();
        //FIBONACCI
        System.out.println("" + displayFibonacci(num));

        return true;
    }
}