package pers.xgo.onjava.chapter18_strings;
// {NewFeature}  从 JDK 15 开始

public class TextBlocks {
    public static final String NEW = """
            Yesterday, upon teh stair,
            I met a man who wasn't there
            He wasn't there again today
            I wish, I wish he'd go away...
            
            When I came home last night at there
            The man was waiting there for me
            But when I looked around at all!
            """;

    public static void main(String[] args) {
        System.out.println(NEW);
    }
}
