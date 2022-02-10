import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files.*;
import java.util.stream.Collectors;

public class Launcher {


    static int displayFibonacci(int num){
        if (num <= 1)
            return num;
        return displayFibonacci(num-1) + displayFibonacci(num-2);
    }

    static  void frequency(String[] content) {
        HashMap<String, Integer> assoc = new HashMap<String, Integer>();

        for (String str : content) {
            if (assoc.containsKey(str)) {
                assoc.put(str, assoc.get(str) + 1);
            } else {
                assoc.put(str, 0);
            }
        }

        Map<String, Integer> result = assoc.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<String> list3 = new ArrayList<>(result.keySet());
        String res = String.join(" ", list3);
        System.out.println(res);
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
            else if (inp.equals("freq"))
            {
                System.out.println("Emplacement du fichier ?");
                String path = scn.nextLine();

                Path filePath = Paths.get(path);
                try
                {
                    String content = Files.readString(filePath);
                    String[] spl_content = content.split(" ");
                    frequency(spl_content);
                    System.out.println(content);
                }
                catch (IOException e)
                {
                    System.out.println("Unreadable file: " + path);
                }


            }
            else
                System.out.println("Unknown command");

            inp = scn.nextLine();
        }
    }


}
