public class validPalindrome {

    private boolean isPalindrome(String s){
        char words[] = s.toCharArray();
        int start = 0;
        int end = words.length-1;
        while(start <= end){
            if(words[start]!=words[end]) {
                return false;
            }
            start++;
            end--;
        };
        return true;
    };
}
