import java.util.Arrays;

public class Evendigits {

    //find with even number of digits ;
    public static void main(){
        int[] arr = {12,13,52,345,5213,222,34555,23,21,10,40};
        System.out.println(Arrays.toString(arr));
        int num  = evenCounter(arr);
        System.out.print(num);

    }
    private static int evenCounter(int[] arr){
        int counter=0;
        for(int i = 0 ; i < arr.length;i++){
            String numStr = arr[i]  + "";
            if(numStr.length()%2 == 0) {
                counter++;
            };
        };
        return counter;
    }

}
