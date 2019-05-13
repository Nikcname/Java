package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamsAndStrings {

    public static void main(String[] args) {

        //Old approach: Check palindrome
        String s = "madam";

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        String forward = sb.toString().toLowerCase();
        String backward = sb.reverse().toString().toLowerCase();
        if (forward.equals(backward))
            System.out.println(s + " is palindrome");

        //Stream based approach: Check palindrome
        String forwardOp = s.toLowerCase().codePoints()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String backwardOp = new StringBuilder(forwardOp).reverse().toString();
        if (forwardOp.equals(backwardOp))
            System.out.println(forwardOp + " is palindrome");

        int test = 1244563;
        int sumOddDigits = Integer.toString(test).chars()
                .filter(x -> x%2 == 1)
                .reduce(0, (x, y) -> x + y - 48);
        int sumEvenDigits = Integer.toString(test).chars()
                .filter(x -> x%2 == 0)
                .reduce(0, (x, y) -> x + y - 48);
        System.out.println(sumOddDigits + "/" + sumEvenDigits + "=" + (double)sumOddDigits/sumEvenDigits);


    }

}
