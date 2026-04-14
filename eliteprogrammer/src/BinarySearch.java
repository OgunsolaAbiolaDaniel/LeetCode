public class BinarySearch {

    public static void main(String[] args){
        int[] arr = {-10, -12,-4,0,2,3,10,22,23,45};
        int target =  22;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr, int target){
        int start = 0 ;
        int end = arr.length-1;

        while (start <= end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end =  mid -1;
            }
            else if(target>arr[mid]){
                start= mid+1;
            }else{
                return mid;
            } ;
        };
        return -1;
    };


static int binarySearch2(int[] arr , int target ) {
    int start = 0;
    int end = arr.length - 1;
    while(start <= end) {
        int mid = start + (end - start) / 2;
        if (target < arr[mid]) {
            end = mid - 1;
        } else if(target > arr[mid]) {
            start = mid + 1;
        }else {
            return mid;
        }
    }
    return -1;
}

}