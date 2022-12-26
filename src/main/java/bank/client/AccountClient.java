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


/**
 * @author ALi Eren Cihan
 */
public class AccountClient extends JFrame {

    public AccountClient(List<Account> accounts) {
        super("Hesaplarım");
        final BackButton backButton = new BackButton();
        final JMenuBar jMenuBar = backButton.menuBar;
        setJMenuBar(jMenuBar);
        backButton.initializeMenubar();


        final List<LinkedHashMap> customer = JsonReader.read(FilePaths.CUSTOMER.getPath(), List.class);
        final List<Customer> customerList = customer.stream().map(customer1 -> Customer.builder()
                .id((Long) customer1.get("id"))
                .name((String) customer1.get("name"))
                .surname((String) customer1.get("surname"))
                .build()).collect(Collectors.toList());


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(new Color(144, 238, 144), 10));

        if (!accounts.isEmpty()) {
            GridLayout gridLayout = new GridLayout(0, 4, 10, 10);

            panel.setLayout(gridLayout);
            for (Account account : accounts) {


                final JLabel currency = new JLabel("Currency: " + account.getCurrency().toString());
                final JLabel balance = new JLabel("Hesap Bakiyesi: " + account.getBalance().toString());
                final JLabel accountNumber = new JLabel("Hesap Numarası: " + account.getId().toString());
                final JLabel customerName = new JLabel("Hesap sahibi: " + customerList.stream().filter(customer1 -> customer1.getId()
                        .equals(account.getCustomerId())).findFirst().orElseThrow().getName());

                designLabel(currency, balance, accountNumber, customerName);
                panel.add(currency);
                currency.setFont(new Font("Arial", Font.BOLD, 20));
                currency.setForeground(new Color(0, 139, 139));

                panel.add(balance);
                balance.setFont(new Font("Arial", Font.BOLD, 20));
                balance.setForeground(new Color(0, 139, 139));

                panel.add(accountNumber);
                accountNumber.setFont(new Font("Arial", Font.BOLD, 20));
                accountNumber.setForeground(new Color(0, 139, 139));

                panel.add(customerName);
                customerName.setFont(new Font("Arial", Font.BOLD, 20));
                customerName.setForeground(new Color(0, 139, 139));

            }


        } else {
            panel.add(new JLabel("Hesabınız bulunmamaktadır."));
        }
        add(panel, BorderLayout.CENTER);
        setSize(1500, 1500);
        setVisible(true);

    }

    private void designLabel(JLabel... labels ) {
        for (JLabel label : labels) {
            label.setFont(new Font("Serif", Font.PLAIN, 20));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

}
