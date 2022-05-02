
import java.util.*;
 

class TopWords{

    static String findWord(String[] arr)
    {
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.containsKey(arr[i])) {

                hs.put(arr[i], hs.get(arr[i]) + 1);

            }
            else {
                hs.put(arr[i], 1);
            }
        }
        Set<Map.Entry<String, Integer> > set = hs.entrySet();
        String key = "";
        int value = 0;

        for (Map.Entry<String, Integer> me : set) {
            if (me.getValue() > value) {
                value = me.getValue();
                key = me.getKey();
            }
        }
        return key;
    }
 
    public static void main(String[] args)
    {
        String arr[] = { "dog", "man", "dog", "man", "woman", "dog", "man", "dog"};
        String sol = findWord(arr);
        System.out.println(sol);
    }
}
