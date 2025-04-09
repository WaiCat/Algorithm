package Algorithm.LeetCode.Week01;

class ReverseString{
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        System.out.println(chars);
    }
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
