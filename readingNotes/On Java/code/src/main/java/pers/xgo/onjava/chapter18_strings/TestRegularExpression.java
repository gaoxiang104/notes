package pers.xgo.onjava.chapter18_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
    public static void main(String[] args) {
        test(new String[]{"abcabcabcdefabc", "abc+", "(abc)+", "(abc){2,}"});
    }

    static void test(String[] args) {
        if (args.length < 2) {
            System.out.println(
                    "Usage:\njava TestRegularExpression " +
                            "characterSequence regularExpression+");
            System.exit(0);
        }

        System.out.println("Input: \"" + args[0] + "\"");

        for (String arg : args) {
            System.out.println("\nRegular expression: \"" + arg + "\"");
            Pattern pattern = Pattern.compile(arg);
            Matcher matcher = pattern.matcher(args[0]);
            while (matcher.find()) {
                System.out.println("Match \"" + matcher.group() + "\" at positions "
                        + matcher.start() + "-" + (matcher.end() - 1));
            }
        }
    }
}
/* OUTPUT:
Input: "abcabcabcdefabc"

Regular expression: "abcabcabcdefabc"
Match "abcabcabcdefabc" at positions 0-14

Regular expression: "abc+"
Match "abc" at positions 0-2
Match "abc" at positions 3-5
Match "abc" at positions 6-8
Match "abc" at positions 12-14

Regular expression: "(abc)+"
Match "abcabcabc" at positions 0-8
Match "abc" at positions 12-14

Regular expression: "(abc){2,}"
Match "abcabcabc" at positions 0-8
 */