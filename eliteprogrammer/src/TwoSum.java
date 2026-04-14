import java.util.HashMap;

public class TwoSum {


    /**
     * @return the indicies of two numbers that sum up to the <code>target/code>
     * */
    private int[] twoSum(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length; i++){
           int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            };
            map.put(arr[i],i);
        };

        return new int[]{};
    };
}
