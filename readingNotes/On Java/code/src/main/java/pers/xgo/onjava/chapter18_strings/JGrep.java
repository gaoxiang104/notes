package pers.xgo.onjava.chapter18_strings;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        Matcher m = p.matcher("");
        int i = 0;
        AtomicReference<Integer> r = new AtomicReference<>(0); // 标记行号
        // 遍历输入文件的每一行
        Files.readAllLines(Paths.get(args[0])).forEach(
                line -> {
                    m.reset(line);
                    r.getAndSet(r.get() + 1);
                    while (m.find()) {
                        System.out.println(r.get() + " " + m.start() + " : " + line);
                    }
                }
        );
    }

}
