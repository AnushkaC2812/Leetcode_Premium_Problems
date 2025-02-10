import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDSDesign {

    HashMap<Integer, Integer> hmap;

    public TwoSumIIIDSDesign() {
        //a datastructure to hold the stream of input is initialized when an object of this class is created
        hmap = new HashMap<>();
    }

    void add(int num){
        //storing every input as a key with its frequency as value
        hmap.put(num, hmap.getOrDefault(num, 0)+1);
    }

    boolean find(int target){
     for(Map.Entry<Integer, Integer> set : hmap.entrySet()){
         /*for every key that we encounter, we search the whole hmap for the other value,
         which when added to the current value, sums up to target*/
         int firstNumber = set.getKey();
         int secondNumber = target-firstNumber;
         if(hmap.containsKey(secondNumber)){
             if(secondNumber == firstNumber && hmap.get(secondNumber)>1)
                 return true;
             else if(secondNumber == firstNumber && hmap.get(secondNumber)<=1)
                 continue;
             else return true;
         }
     }
     return false;
    }

    public static void main(String[] args) {

        TwoSumIIIDSDesign testObj = new TwoSumIIIDSDesign();

        testObj.add(1);
        testObj.add(2);
        testObj.add(2);
        testObj.add(3);
        testObj.add(4);
        testObj.add(5);
        System.out.println(testObj.find(4));
    }
}