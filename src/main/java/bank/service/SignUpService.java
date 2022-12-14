package bank.service;

import bank.dto.SignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;

public class SignUpService {


    public void signUp(SignUpRequest request) throws IOException, JSONException {
        execute(request);
    }

    private File execute(SignUpRequest request) throws IOException, JSONException {
        File file = new File("ek/Customer.json");

        if (!file.exists()) {
            file.createNewFile();
        }

        checkEmailUsed(request, file);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", request.getName());
        jsonObject.put("surname", request.getSurname());
        jsonObject.put("email", request.getEmail());
        jsonObject.put("password", request.getPassword());

        FileWriter fileWriter = new FileWriter(file, true);

        String open = "[";
        String close = "]";

        Function<String, String> addBrackets = (String s) -> open + s + close;

        FileReader fileReader = new FileReader(file);
        String currentFileJson = IOUtils.toString(fileReader);


        if (currentFileJson.length() == 0) {
            fileWriter.write(addBrackets.apply(jsonObject.toString()));
        } else {
            PrintWriter printWriter = new PrintWriter(file);
            String newJson = currentFileJson + "," + jsonObject;
            newJson = newJson.replace("[", "")
                    .replace("]", "");
            printWriter.write(addBrackets.apply(newJson));
            printWriter.close();
        }

        fileWriter.close();
        return file;
    }

    private void checkEmailUsed(SignUpRequest request, File file) {
        if (file.length() == 0) {
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<LinkedHashMap> list = objectMapper.readValue(file, List.class);
            for (LinkedHashMap map : list) {
                if (map.get("email").equals(request.getEmail())) {
                    throw new IllegalArgumentException("This email is already used");
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("error");

        }
    }
}
