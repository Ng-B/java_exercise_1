import java.util.Scanner;

public class Launcher {


    static int displayFibonacci(int num){
        if (num <= 1)
            return num;
        return displayFibonacci(num-1) + displayFibonacci(num-2);
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue !!");

        Scanner scn = new Scanner(System.in);

        String inp = scn.nextLine();

        while (!inp.equals(("quit"))) {

            if (inp.equals("fibo"))
            {
                System.out.println("Nombre à utiliser ?");
                Integer num = scn.nextInt();

                //FIBONACCI
                System.out.println(displayFibonacci(num));
            }
            else
            {
                System.out.println("Unknown command");
            }
            inp = scn.nextLine();
        }
    }


}
