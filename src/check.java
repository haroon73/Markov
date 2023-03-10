import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class check {

      public String rad(String word){


        return "";
    }

    public static void main(String[] args) {

        HashMap<String , ArrayList<String >> words = new HashMap<>();
          ArrayList<String> arr = new ArrayList<>();
          arr.add("Khan");
          arr.add("Ali");
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("Jan");
        arr2.add("Kaa");
        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("Haroon");
        arr3.add("Gul");
        arr3.add("Shahjahn");
        words.put("Logar" , arr);
        words.put("Kabul" , arr2);
        words.put("Khost" , arr3);

//        System.out.print(words + "");



        Object[] crunchifyKeys = words.keySet().toArray();
        Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];

        System.out.println(words.get(key) + "");

      Random rand = new Random();

      int x = rand.nextInt(9) + 1;
        System.out.println(x);


        String [] arr5 ={"Khan" , "Shah" , "Wali" , "Logar" ,"East"};

            int num = rand.nextInt(arr5.length);

        System.out.println(arr5[num]);

    }
}
