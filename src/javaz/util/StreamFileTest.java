package javaz.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class StreamFileTest {

    public static void main(String[] args) throws IOException {
        String pathStr = "src/javaz/io";
        System.out.println("src/javaz/io 디렉토리 밑의 모든 파일들 ---");
        Path path = Paths.get(pathStr);
        for (Path p : path) {
            System.out.println(p.getFileName());
        }
        System.out.println("-------------------------");
        Files.list(path).forEach(System.out::println);
        System.out.println("-------------------------");
        path = Paths.get("src/user.txt");
        Files.lines(path).forEach(System.out::println);
        System.out.println("-------------------------");
        Files.lines(path).filter(o -> o.contains("Laa")).forEach(System.out::println);
    }

    
}
