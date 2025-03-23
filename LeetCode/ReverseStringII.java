package Algorithm.LeetCode;

public class ReverseStringII {

    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        String result = reverseStr(s, k);
        System.out.println(result); // bacdfeg
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i+=(2*k)) {
            int left;
            int right;
            if(s.length()-i >= k){
                left = i;
                right = i+k-1;
            }else{
                left = i;
                right = s.length()-1;
            }
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }

        }
        return new String(chars);
    }
}
