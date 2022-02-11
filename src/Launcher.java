import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files.*;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Launcher {


    static int displayFibonacci(int num){
        if (num <= 1)
            return num;
        return displayFibonacci(num-1) + displayFibonacci(num-2);
    }

    static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap,  boolean order)
    {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
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



        Map<String, Integer> sortedMapDesc = sortByComparator(assoc, false);

        Integer i = 0;
        String res = "";

        for (String key : sortedMapDesc.keySet())
        {
            if (i == 3)
                break;
            res = res.concat(key+ " ") ;
            i++;
        }

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
                    String[] spl_content = content.toLowerCase().split(" ");
                    frequency(spl_content);
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
