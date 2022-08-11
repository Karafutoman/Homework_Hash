import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut" +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit" +
                "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt" +
                "in culpa qui officia deserunt mollit anim id est laborum.";

        int minValue = Integer.MAX_VALUE;
        int maxValue = -1;
        char minSymbol = '0';
        char maxSymbol = '1';
        Map<Character, Integer> map = new HashMap<>();

        text = text.toLowerCase().replaceAll("\\s", "");

        for (int i = 0; i < text.length(); i++) {
            Character newText = text.charAt(i);

            if (map.containsKey(newText)) {
                map.put(newText, map.get(newText) + 1);
            } else {
                map.put(newText, 1);
            }
        }

        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() < minValue) {
                minValue = kv.getValue();
                minSymbol = kv.getKey();
            }

            if (kv.getValue() > maxValue) {
                maxValue = kv.getValue();
                maxSymbol = kv.getKey();
            }
        }
        System.out.println("После определения, какая буква встречалась в текстe Lorem Ipsum чаще всего" +
                " и какая реже всего, получили следующие результаты:");
        System.out.println();
        System.out.println("Встречалась в тексте чаще всего буква: " + maxSymbol + " = " + maxValue);
        System.out.println("Встречалась в тексте реже всего буква: " + minSymbol + " = " + minValue);
    }
}
