package bank.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Ali Eren Cihan
 */
public final class FileSearchQuery {

    private FileSearchQuery() {
        throw new IllegalStateException("Utility class");
    }

    public static String search(String fileName, String name) {
        return FileReadOperation.read(fileName)
                .stream()
                .filter(line -> line.contains(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
    }

    private static class FileReadOperation {
        public static List<String> read(String fileName) {
            try {
                return Files.readAllLines(Paths.get(fileName));
            } catch (IOException e) {
                throw new RuntimeException("Dosya okunamadı");
            }
        }
    }
}
