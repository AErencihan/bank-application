package bank.client;

import bank.model.Account;
import bank.model.Customer;
import bank.model.FilePaths;
import bank.util.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static bank.client.BackButton.backButtonListener;

/**
 * @author ALi Eren Cihan
 */
public class AccountClient extends JFrame {

    public AccountClient(List<Account> accounts) {
        super("Hesaplarım");

        final List<LinkedHashMap> customer = JsonReader.read(FilePaths.CUSTOMER.getPath(), List.class);
        final List<Customer> customerList = customer.stream().map(customer1 -> Customer.builder()
                .id((Long) customer1.get("id"))
                .name((String) customer1.get("name"))
                .surname((String) customer1.get("surname"))
                .build()).collect(Collectors.toList());


        final BackButton backButton = new BackButton();
        JPanel panel = new JPanel();
        backButtonListener(backButton);
        setJMenuBar(backButton.initializeMenubar());
        panel.setLayout(new BorderLayout());
        if (!accounts.isEmpty()) {
            GridLayout gridLayout = new GridLayout(0, 3);
            panel.setLayout(gridLayout);
            for (Account account : accounts) {


                panel.add(new JLabel("Currency: " + account.getCurrency().toString()));
                panel.add(new JLabel("Hesap Bakiyesi: " + account.getBalance().toString()));
                panel.add(new JLabel("Hesap numarası: " + account.getId()));
                panel.add(new JLabel("Hesap sahibi: " + customerList.stream().filter(customer1 -> customer1.getId()
                        .equals(account.getCustomerId())).findFirst().orElseThrow().getName()));
            }


        } else {
            panel.add(new JLabel("Hesabınız bulunmamaktadır."));
        }
        add(panel, BorderLayout.CENTER);
        setSize(1500, 1500);
        setVisible(true);

    }

}
