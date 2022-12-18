package bank;

import bank.client.HomePageClient;

import javax.swing.*;

/**
 * @author Eray Tekin
 */
public final class Client {

    public static void main(String[] args) {
        JFrame frame = new HomePageClient("Banka Sayfasına Hoşgeldiniz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setVisible(true);
    }
}
