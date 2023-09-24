package pers.xgo.onjava.chapter17_files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PathWatcher {
    static Path test = Paths.get("/Users/gaoxiang/Downloads/temp/test");

    static void delTxtFiles(){
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception{
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));

        WatchService watcher = FileSystems.getDefault().newWatchService();
        test.register(watcher, StandardWatchEventKinds.ENTRY_DELETE); // 注册

        Executors.newSingleThreadScheduledExecutor()
                .schedule(PathWatcher::delTxtFiles,250, TimeUnit.MILLISECONDS);

        WatchKey key = watcher.take();
        for (WatchEvent<?> evt : key.pollEvents()) {
            System.out.println(
                    "evt.context(): " + evt.context() +
                    "\nevt.count(): " + evt.count() +
                    "\nevt.kind(): " + evt.kind()
            );
        }
    }
}
