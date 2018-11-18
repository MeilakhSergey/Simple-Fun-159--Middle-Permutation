import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

public class MiddlePermutation {
    private static StringBuilder result;
    private static boolean isFound;
    private static BigInteger fact;
    private static int n;
    public static void main(String[] args) {
        System.out.println(findMidPerm("ab"));
        System.out.println(findMidPerm("abc"));
        System.out.println(findMidPerm("abcd"));
        System.out.println(findMidPerm("abcdx"));
        System.out.println(findMidPerm("abcdxg"));
        System.out.println(findMidPerm("abcdxgz"));
        System.out.println(findMidPerm("obwetzmafglcsxvhu"));
        System.out.println(findMidPerm("qutzrvjkmdweflyha"));
        System.out.println(findMidPerm("pxyomsjlucdrawvzqbitfk"));
    }

    public static String findMidPerm(String strng) {
        char[] orderArray = strng.toCharArray();
        Arrays.sort(orderArray);
        strng = new String(orderArray);
        result = new StringBuilder();
        isFound = false;
        n = orderArray.length;
        fact = factorial(new BigInteger(Integer.toString(n)));
        fact = fact.divide(new BigInteger("2"));
        findMidPerm(strng, n);
        return result.toString();
    }

    private static void findMidPerm(String str, int n) {
        if (isFound)
            return;
        else {
            int i;
            if (fact.remainder(fact.multiply(new BigInteger("2")).divide(new BigInteger(Integer.toString(n)))).compareTo(new BigInteger("0")) != 0) {           //if (fact % (fact * 2 / n) != 0) {
                i = fact.divide(fact.multiply(new BigInteger("2")).divide(new BigInteger(Integer.toString(n)))).intValue();   //(int) (fact / (fact * 2 / n))
                result.append(str.charAt(i));
                fact = fact.remainder(fact.multiply(new BigInteger("2")).divide(new BigInteger(Integer.toString(n))));        //fact %= (fact * 2 / n);
                n--;
            } else {
                i = fact.divide(fact.multiply(new BigInteger("2")).divide(new BigInteger(Integer.toString(n)))).intValue();     //i = (int) (fact / (fact * 2 / n)) - 1;
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

    private static BigInteger factorial(BigInteger x) {
        if (x.intValue() == 1)
            return new BigInteger("1");
        else
            return x.multiply(factorial(x.subtract(new BigInteger("1"))).negate());
    }
}
