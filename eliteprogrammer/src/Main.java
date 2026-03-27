

class Main{


   public static int twoSum(int[]arr,int target){
        int vals[] ={};
        for(int i = 0;i< arr.length;i++){
            for (int j =i+1 ;j<arr.length;j++){
                if(i+j==target){
                    System.out.println(i);
                    System.out.println(j);
                };
            };
        };


        return 1;
    }

    public static void main(String[] args) {
        /*
        * Given an array of integers,
        *  return indices of the two numbers such that they add up to a specific target.
        You may assume that each input would have exactly one solution,
        *  and you may not use the same element twice.
        *Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
        *
        * */
        int array[] = {2,3,5,7,9};
        int target= 11;
        twoSum(array,11);



    }




}