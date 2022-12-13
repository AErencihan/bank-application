package bank.client;

import javax.swing.*;
import java.awt.*;

public class HomePageClient extends JFrame {

    private final JButton SIGN_UP = new JButton("Kayıt Ol");
    private final JButton SIGN_IN = new JButton("Giriş Yap");

    public HomePageClient(String title) throws HeadlessException {
        super(title);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(SIGN_UP);
        panel.add(SIGN_IN);
        add(panel, BorderLayout.CENTER);

        SIGN_UP.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Adınızı giriniz");
            String surname = JOptionPane.showInputDialog("Soyadınızı giriniz");
            String email = JOptionPane.showInputDialog("Emailinizi giriniz");
            String password = JOptionPane.showInputDialog("Şifrenizi giriniz");

            if (email.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurunuz");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt başarılı");
            }

        });

        SIGN_IN.addActionListener(e -> {
            String email = JOptionPane.showInputDialog("Emailinizi giriniz");
            String password = JOptionPane.showInputDialog("Şifrenizi giriniz");
        });




    }
}
