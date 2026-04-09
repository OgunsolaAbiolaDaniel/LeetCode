public class MaximumWealth {

    public static void main(String[] args){
        int[][] accounts= {{1,2,3},{3,2,1},{5,1,3}};
    }
    private static int maximumWealth(int[][] accounts){
        int sum = 0 ;
        int max = 0;
        int[] track= {};
        int counter= 0;
        for(int[]acct:accounts){
            for (int i = 0 ; i < acct.length;i++){sum+=acct[i]}
            track[counter] = sum;
                    counter++;
        }
        for(int i =0 ; i < track.length;i++){
          if(max<track[i]){
              max= track[i];
          };
        }


    }
}
