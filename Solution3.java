import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution3 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter the path to the input data file (e.g., data.txt):");
        String filePath = inputScanner.nextLine();

        System.out.println("Enter the input keys in sequential order (comma-separated, e.g., 5,7,10,23):");
        String keysInput = inputScanner.nextLine();
        List<Integer> targetKeys = Arrays.stream(keysInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            Map<Integer, String[]> keyToUniqueStrings = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                // Split the line into key-value pairs
                // Example: 1=abc;2=def;3=ghi

                String[] keyValuePairs = line.split(";");

                // For each key-value pair, split it into key and value
                // Example: 1=abc

                for (String keyValuePair : keyValuePairs) {
                    String[] keyValue = keyValuePair.split("=");

                    // If the key is one of the keys we're looking for, add the value to the map

                    int key = Integer.parseInt(keyValue[0]);
                    String value = keyValue[1];

                    if (targetKeys.contains(key)) {
                        if (keyToUniqueStrings.containsKey(key)) {
                            String[] uniqueStrings = keyToUniqueStrings.get(key);
                            String[] newUniqueStrings = new String[uniqueStrings.length + 1];
                            System.arraycopy(uniqueStrings, 0, newUniqueStrings, 0, uniqueStrings.length);
                            newUniqueStrings[uniqueStrings.length] = value;
                            keyToUniqueStrings.put(key, newUniqueStrings);
                        } else {
                            keyToUniqueStrings.put(key, new String[]{value});
                        }
                    }
                }
            }

            for (Entry<Integer, String[]> entry : keyToUniqueStrings.entrySet()) {

                String[] uniqueStrings = entry.getValue();

                String concatenatedString = String.join("|", uniqueStrings);

                System.out.println("Concatenated String: " + concatenatedString + ", Count: "
                        + uniqueStrings.length);
            }

            // System.out.println(keyToUniqueStrings.size());

            reader.close();
            inputScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
