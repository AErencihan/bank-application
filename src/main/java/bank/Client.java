package bank;

import bank.client.HomePageClient;

import javax.swing.*;
import java.awt.*;

public final class Client {

    // banka sayfasına hoşgeldiniz ekranı oluştur swing ile

    public static void main(String[] args) {

        JFrame frame = new HomePageClient("Banka Sayfasına Hoşgeldiniz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setVisible(true);



    }
}
