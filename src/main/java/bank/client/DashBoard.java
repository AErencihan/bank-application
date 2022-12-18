package bank.client;

import bank.listener.*;
import bank.service.AccountService;
import bank.service.CreditService;

import javax.swing.*;
import java.awt.*;

/**
 * @author Furkan Özmen
 */
public class DashBoard extends JFrame {
    private final AccountService accountService = new AccountService();
    private final CreditService creditService = new CreditService(accountService);

    private final JButton ACCOUNTS = new JButton("Hesaplarım");
    private final JButton CREATE_ACCOUNT = new JButton("Hesap Aç");
    private final JButton DELETE_ACCOUNT = new JButton("Hesap Sil");
    private final JButton ACCOUNT_DETAILS = new JButton("Hesap Detayları");
    private final JButton DEPOSIT = new JButton("Para Yatır");
    private final JButton WITHDRAW = new JButton("Para Çek");
    private final JButton TRANSFER = new JButton("Havale Yap");
    private final JButton LOGOUT = new JButton("Çıkış Yap");
    private final JButton CREDIT = new JButton("Kredi Al");

    public DashBoard(String title) {
        super(title);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 8));
        panel.add(ACCOUNTS);
        panel.add(CREATE_ACCOUNT);
        panel.add(DELETE_ACCOUNT);
        panel.add(ACCOUNT_DETAILS);
        panel.add(DEPOSIT);
        panel.add(WITHDRAW);
        panel.add(TRANSFER);
        panel.add(LOGOUT);
        panel.add(CREDIT);
        add(panel, BorderLayout.CENTER);

        ACCOUNTS.addActionListener(new AccountListListener());
        CREATE_ACCOUNT.addActionListener(new AccountCreateListener(accountService));
        DELETE_ACCOUNT.addActionListener(new AccountDeleteListener());
        CREDIT.addActionListener(new CreditListener(creditService));
        DEPOSIT.addActionListener(new DepositMoneyListener(accountService));
        TRANSFER.addActionListener(new TransferMoneyListener(accountService));

    }

    public void redirect() {
        JFrame frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setVisible(true);
    }

}
