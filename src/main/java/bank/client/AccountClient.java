package bank.client;

import bank.model.Account;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AccountClient extends JFrame {

    private final List<Account> accounts;
    public AccountClient(List<Account> accounts) {
        super("Hesaplarım");
        this.accounts = accounts;
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(1, 8));
        for (Account account : accounts) {
            panel.add(new JLabel(account.getBalance().toString()));
        }
        add(panel, BorderLayout.CENTER);
        setSize(1500, 1500);
        setVisible(true);

    }


}
