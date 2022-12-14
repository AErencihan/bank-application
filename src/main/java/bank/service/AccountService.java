package bank.service;

import bank.dto.CreateAccountRequest;
import bank.model.Account;
import bank.model.Currency;
import bank.model.FileFacade;
import bank.model.FilePaths;
import bank.util.JsonReader;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static bank.util.JsonReader.formatWithJson;

public class AccountService {
    public void createAccount(CreateAccountRequest request) throws IOException, JSONException {
        File file = FileFacade.ACCOUNT.getFile();

        if (!file.exists()) {
            file.createNewFile();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", request.getId());
        jsonObject.put("balance", request.getBalance());
        jsonObject.put("currency", request.getCurrency());
        jsonObject.put("customerId", request.getCustomerId());

        formatWithJson(file, jsonObject);
    }

    public Account findByIban(Long iban, List<LinkedHashMap> accounts) throws Exception {
        final LinkedHashMap linkedHashMap = accounts.stream()
                .filter(a -> a.get("id").equals(iban))
                .findFirst()
                .orElseThrow(() -> new Exception("Hesap bulunamadı"));
        final Account db = Account.builder()
                .id((Long) linkedHashMap.get("id"))
                .balance(Double.valueOf((Integer) linkedHashMap.get("balance")))
                .currency(Currency.valueOf((String) linkedHashMap.get("currency")))
                .customerId((Long) linkedHashMap.get("customerId"))
                .build();

        accounts.remove(linkedHashMap);
        return db;

    }
}
