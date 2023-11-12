package pers.xgo.onjava.chapter18_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    public static final String POME =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwork, my son,\n" +
                    "THe jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))(\\s+\\S+)$")
                .matcher(POME);

        while (matcher.find()) {
//            System.out.println("[" + matcher.group(0) + "]");
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.print("i=" + i + ":[" + matcher.group(i) + "],");
            }
            System.out.println();
        }
    }
}
/* output:
i=0:[and the slithy toves],i=1:[and],i=2:[the slithy],i=3:[the],i=4:[slithy],i=5:[ toves],
i=0:[gimble in the wabe.],i=1:[gimble],i=2:[in the],i=3:[in],i=4:[the],i=5:[ wabe.],
i=0:[mimsy were the borogoves,],i=1:[mimsy],i=2:[were the],i=3:[were],i=4:[the],i=5:[ borogoves,],
i=0:[the mome raths outgrabe.],i=1:[the],i=2:[mome raths],i=3:[mome],i=4:[raths],i=5:[ outgrabe.],
i=0:[the Jabberwork, my son,],i=1:[the],i=2:[Jabberwork, my],i=3:[Jabberwork,],i=4:[my],i=5:[ son,],
i=0:[the claws that catch.],i=1:[the],i=2:[claws that],i=3:[claws],i=4:[that],i=5:[ catch.],
i=0:[Jubjub bird, and shun],i=1:[Jubjub],i=2:[bird, and],i=3:[bird,],i=4:[and],i=5:[ shun],
 */