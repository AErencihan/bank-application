package bank.client;

import bank.listener.AccountCreateListener;
import bank.model.Account;
import bank.model.Customer;
import bank.model.FilePaths;
import bank.model.User;
import bank.util.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AccountClient extends JFrame {

    private final List<Account> accounts;


    public AccountClient(List<Account> accounts) {
        super("Hesaplarım");
        this.accounts = accounts;

        final List<LinkedHashMap> customer = JsonReader.read(FilePaths.CUSTOMER.getPath(), List.class);
        final List<Customer> customerList = customer.stream().map(customer1 -> Customer.builder()
                .id((Long) customer1.get("id"))
                .name((String) customer1.get("name"))
                .surname((String) customer1.get("surname"))
                .build()).collect(Collectors.toList());

        getName();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
            GridLayout gridLayout = new GridLayout(0, 4);
            panel.setLayout(gridLayout);

            panel.add(new JLabel("Currency: " + account.getCurrency().toString()));
            panel.add(new JLabel("Hesap Bakiyesi: " + account.getBalance().toString()));
            panel.add(new JLabel("Hesap numarası: " + account.getId()));
            panel.add(new JLabel("Hesap sahibi: "+ customerList.stream().filter(customer1 -> customer1.getId()
                    .equals(account.getCustomerId())).findFirst().orElseThrow().getName()));


            }


        } else {
            panel.add(new JLabel("Hesabınız bulunmamaktadır."));
        }
        add(panel, BorderLayout.CENTER);
        setSize(1500, 1500);
        setVisible(true);

        // todo buraya for ile dönüp adamın ismi ve soyismi yazılacak ve bakiyesi

    }


}
