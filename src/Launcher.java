import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        Scanner scanner = new Scanner(System.in);

        List<Command> commands = new ArrayList<Command>();
        commands.add(new Quit());
        commands.add(new Fibo());
        commands.add(new Freq());

        boolean inRun = false;
        while (!inRun) {
            System.out.println("Entrer commande :");
            String input = scanner.nextLine();
            Command command = commands.stream().filter(cmd -> input.equals(cmd.name())).findAny().orElse(null);

            if (Objects.isNull(command)) {
                System.out.println("Unknown command");
            }
            else {
                inRun = command.run(scanner);
            }
        }
        scanner.close();
    }
}