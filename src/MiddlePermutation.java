import java.util.Arrays;
import java.util.Collections;

public class MiddlePermutation {
    private static StringBuilder result;
    private static boolean isFound;
    private static long fact;
    private static int n;
    public static void main(String[] args) {
        System.out.println(findMidPerm("abc"));
        System.out.println(findMidPerm("abcd"));
        System.out.println(findMidPerm("abcdx"));
        System.out.println(findMidPerm("abcdxg"));
        System.out.println(findMidPerm("abcdxgz"));
        System.out.println(findMidPerm("obwetzmafglcsxvhu"));
    }

    public static String findMidPerm(String strng) {
        char[] orderArray = strng.toCharArray();
        Arrays.sort(orderArray);
        strng = new String(orderArray);
        result = new StringBuilder();
        isFound = false;
        fact = factorial(orderArray.length) / 2;
        n = orderArray.length;
        findMidPerm(strng, n);
        return result.toString();
    }

    private static void findMidPerm(String str, int n) {
        if (isFound)
            return;
        else {
            int i;
            if (fact % (fact * 2 / n) != 0) {
                i = (int) (fact / (fact * 2 / n));
                result.append(str.charAt(i));
                fact %= (fact * 2 / n);
                n--;
            } else {
                i = (int) (fact / (fact * 2 / n)) - 1;
                result.append(str.charAt(i));
                String temp = str.substring(0, i) + str.substring(i + 1);
                for (int j = temp.length() - 1; j >=0; j--) {
                    result.append(temp.charAt(j));
                }
                isFound = true;
            }
            findMidPerm(str.substring(0, i) + str.substring(i + 1), n);
        }
    }

    private static long factorial(long x) {
        if (x == 1)
            return 1;
        else
            return x * factorial(x - 1);
    }
}
