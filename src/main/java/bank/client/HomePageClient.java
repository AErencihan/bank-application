package bank.client;

import bank.dto.SignUpRequest;
import bank.service.SignInService;
import bank.service.SignUpService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Ali Eren Cihan
 */
public class HomePageClient extends JFrame {

    private final JButton SIGN_UP = new JButton("KAYIT OL");
    private final JButton SIGN_IN = new JButton("GİRİŞ YAP");

    public HomePageClient(String title) throws HeadlessException {
        super(title);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1 , 15, 0 ));
        panel.add(SIGN_UP);
        SIGN_UP.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 7));
        SIGN_UP.setFont(new Font("Arial", Font.BOLD, 25));
        SIGN_UP.setForeground(new Color(0, 139, 139));


        panel.add(SIGN_IN);
        SIGN_IN.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0), 7));
        SIGN_IN.setFont(new Font("Arial", Font.BOLD, 25));
        SIGN_IN.setForeground(new Color(0, 139, 139));


        add(panel, BorderLayout.CENTER);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 50));

        // border color pink
        panel.setBorder(BorderFactory.createLineBorder(Color.PINK, 50));
        // border color red
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 50));
        // border color green
        panel.setBorder(BorderFactory.createLineBorder(new Color(144, 238, 144), 50));
        

        SIGN_UP.addActionListener(SignUpListener.of().listen());
        SIGN_IN.addActionListener(SignInListener.of().listen());
    }

    private static class SignInListener {

        private final SignInService signInService = new SignInService();

            public static SignInListener of() {
                return new SignInListener();
            }

            public ActionListener listen() {
                return e -> {
                    String email = JOptionPane.showInputDialog("Emailinizi giriniz");
                    String password = JOptionPane.showInputDialog("Şifrenizi giriniz");
                    signInService.signIn(email, password);
                    JFrame frame = new DashBoard("Banka Sayfasına Hoşgeldiniz");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(1500, 1500);
                    frame.setVisible(true);
                };
            }
    }

    private static class SignUpListener {
        private final SignUpService signUpService = new SignUpService();

        public static SignUpListener of() {
            return new SignUpListener();
        }

        public ActionListener listen(){
            return e -> {
                String name = JOptionPane.showInputDialog("Adınızı giriniz");
                String surname = JOptionPane.showInputDialog("Soyadınızı giriniz");
                String email = JOptionPane.showInputDialog("Emailinizi giriniz");
                String password = JOptionPane.showInputDialog("Şifrenizi giriniz");
                String phoneNumber = JOptionPane.showInputDialog("Telefon numaranızı giriniz");

                if (email.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurunuz");
                } else {
                    try {
                        signUpService.signUp(SignUpRequest.builder()
                                .email(email)
                                .phoneNumber(phoneNumber)
                                .name(name)
                                .surname(surname)
                                .password(password)
                                .id(new Random().nextLong())
                                .build());
                        new DashBoard("Banka Sayfasına Hoşgeldiniz");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "HATA OLUŞTU");
                    }
                    JOptionPane.showMessageDialog(null, "Kayıt başarılı");
                    JFrame frame = new DashBoard("Banka Sayfasına Hoşgeldiniz");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(1500, 1500);
                    frame.setVisible(true);
                }
            };
        }
    }
}
