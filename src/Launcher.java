import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue !!");

        Scanner scn = new Scanner(System.in);

        String inp = scn.nextLine();

        if(!inp.equals(("quit"))) {
            System.out.println("Unknown command");
        }
    }

}
