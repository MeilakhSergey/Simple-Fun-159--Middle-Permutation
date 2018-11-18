import java.util.Arrays;

public class MiddlePermutation {
    static String result;
    static long fact;
    static long count;
    public static void main(String[] args) {
        System.out.println(findMidPerm("abc"));
        System.out.println(findMidPerm("abcd"));
        System.out.println(findMidPerm("abcdx"));
        System.out.println(findMidPerm("abcdxg"));
        System.out.println(findMidPerm("abcdxgz"));
    }

    public static String findMidPerm(String strng) {
        char[] orderArray = strng.toCharArray();
        Arrays.sort(orderArray);
        strng = new String(orderArray);
        fact = factorial(orderArray.length);
        count = 0;
        findMidPerm("", strng);
        return result;
    }
    private static void findMidPerm(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            count++;
        else
            for (int i = 0; i < n; i++) {
                findMidPerm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
                if (count == fact / 2) break;
            }
        if (count == fact / 2 && n == 0) {
            result = prefix;
        }
    }
    private static long factorial(long x) {
        if (x == 1)
            return 1;
        else
            return x * factorial(x - 1);
    }
}
