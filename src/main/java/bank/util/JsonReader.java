package bank.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class JsonReader {
    public static <T> T read(String path, Class<T> type) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), type);
        } catch (IOException e) {
            JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Dosya okunamadı", "Hata", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("error");
        }
    }
}
