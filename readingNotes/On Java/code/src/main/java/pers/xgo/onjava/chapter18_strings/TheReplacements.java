package pers.xgo.onjava.chapter18_strings;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*! Here's a block of text of to use as input to
    the regular expression matcher. Note that we
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/
public class TheReplacements {
    public static void main(String[] args) throws Exception {
        String s = Files.lines(Paths.get("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter18_strings/TheReplacements.java"))
                .collect(Collectors.joining("\n"));

        // 匹配上面被特地注释掉的文本块：
        Matcher mInput = Pattern.compile(
                        "/\\*!(.*)!\\*/", Pattern.DOTALL)
                .matcher(s);
        if (mInput.find()){
            s = mInput.group(1);
        }

        // 用一个空格替换两个或多个空格：
        s = s.replaceAll(" {2,}"," ");
        // 删除每行开头的一个或多个空格。必须开启多行模式
        s = s.replaceAll("(?m)^ +","");
        System.out.println(s);
        // 演示：replaceFirst
        s = s.replaceFirst("[aeiou]","(VOWEL1)");
//        System.out.println(s);

        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find()){
            m.appendReplacement(sbuf,m.group().toUpperCase());
        }
        // 插入本文的剩余部分：
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
