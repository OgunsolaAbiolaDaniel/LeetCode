import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Arrayspractice {


  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int[]myArray = {1,2,3,4,5,6,7,10,23};
      int val = search(myArray,23);

      System.out.println(search_A_String("wisdom",'t')? true:false);
      System.out.println("Found: "+myArray[val]);






        /*   for(int row = 0 ; row < myArray.length ; row++){
          for(int col = row; col < myArray[row].length; col++ ){
              System.out.println(myArray[row][col]);
          };
      }*/




  };

  private static boolean search_A_String (String word, char letter){
      char[] newwords = word.toCharArray();

      if(word.toCharArray().length== 0){
          return false;
      }
      for(int i = 0 ; i <newwords.length;i++ ){
          if(letter == word.charAt(i)){
              return true;
          }
      }
      return false;

  }

public static int search(int[] arr, int target){
    if(arr.length == 0) return -1;
    for (int i =  0 ; i < arr.length;i++){
        if(arr[i] == target)
        return i ;
    };
    return -1;
}


public static int max(int[] arr){
      if(arr.length==0){
          return -1;
      };
    int max = arr[0];
      for(int i = 0; i< arr.length;i++){
          if(max<arr.length){max = arr.length;}
      };
      return max;
}

public static int max2D(int [][]arr){
      if(arr.length==0){
          return -1;
      }
      int max = arr[0][0];
      for(int i = 0 ;i < arr.length; i++){
          for(int j = 0 ; j < arr[i].length;j++){
              if( max < arr[i][j]){
                  max = arr[i][j];
              };
          }
      }
      return max;
}








public static int[] search2d(int[][] arr, int target ){
      if(arr.length ==0 ){
          return new int[]{-1,-1};
      }
      for(int row = 0 ; row < arr.length;row ++){
          for (int col = 0 ;col < arr[row].length ;col++){
              if(arr[row][col] == target){
                  return new int[]{row, col};
              }
          }
      }
return new int[]{-1,-1};
};



 /* private static void rev(int[] arr){
      int start = 0; int end = arr.length-1;
      while (start < end){
          swapper(arr, start,end);
          start++;
          end--;
      }
      return;
  }





    private static void swapper(int[]arr, int index1,int index2){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]= temp;

    }
*/
}


