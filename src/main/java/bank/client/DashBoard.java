package bank.client;

import bank.listener.AccountListener;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame {
    // bu ekranda hesaplarım, hesap aç, hesap sil, hesap detayları, para yatır, para çek, havale yap, çıkış yap butonları olacak

    private final JButton ACCOUNTS = new JButton("Hesaplarım");
    private final JButton CREATE_ACCOUNT = new JButton("Hesap Aç");
    private final JButton DELETE_ACCOUNT = new JButton("Hesap Sil");
    private final JButton ACCOUNT_DETAILS = new JButton("Hesap Detayları");
    private final JButton DEPOSIT = new JButton("Para Yatır");
    private final JButton WITHDRAW = new JButton("Para Çek");
    private final JButton TRANSFER = new JButton("Havale Yap");
    private final JButton LOGOUT = new JButton("Çıkış Yap");

    public DashBoard(String title) {
        super(title);
        // bu ekranda hesaplarım, hesap aç, hesap sil, hesap detayları, para yatır, para çek, havale yap, çıkış yap butonları olacak

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
        add(panel, BorderLayout.CENTER);

        ACCOUNTS.addActionListener(new AccountListener());

        CREATE_ACCOUNT.addActionListener(e -> {
            // hesap aç sayfasına yönlendir
        });

        DELETE_ACCOUNT.addActionListener(e -> {
            // hesap sil sayfasına yönlendir
        });

        ACCOUNT_DETAILS.addActionListener(e -> {
            // hesap detayları sayfasına yönlendir
        });

        DEPOSIT.addActionListener(e -> {
            // para yatır sayfasına yönlendir
        });

    }


}
