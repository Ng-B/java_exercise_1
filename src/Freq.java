import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command{

    @Override
    public String name() {
        return "freq";
    }

    public static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap,  boolean order)
    {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
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
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static  void frequency(String[] content) {
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

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Emplacement du fichier ?");
        String path = scanner.nextLine();

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

        return true;

    }
}