import java.util.HashMap;

public class ContainsDuplicate {

/**
 * The Problem: Given an integer array <code>nums</code>,
 * @return <code>true</code>
 * if any value appears at least twice in the array,
 * and
 * @return <code>false</code>
 * if every element is distinct.
 * Example 1: nums = [1, 2, 3, 1] -> <code>true</code>
 * Example 2: nums = [1, 2, 3, 4] -> <code>false</code>
 *
 * */

    public boolean ContainsDuplicate(int arr[], int num ){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length;i++){
            if(map.containsKey(arr[i])){
                return true;
            }
            map.put(arr[i], i);
        };
        return false;
    };
}
