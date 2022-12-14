package bank.client;

import bank.dto.SignUpRequest;
import bank.service.SignInService;
import bank.service.SignUpService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePageClient extends JFrame {

    private final JButton SIGN_UP = new JButton("Kayıt Ol");
    private final JButton SIGN_IN = new JButton("Giriş Yap");

    private final SignUpService signUpService = new SignUpService();
    private final SignInService signInService = new SignInService();

    public HomePageClient(String title) throws HeadlessException {
        super(title);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(SIGN_UP);
        panel.add(SIGN_IN);
        add(panel, BorderLayout.CENTER);

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
                                .build());
                        new DashBoard("Banka Sayfasına Hoşgeldiniz");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "HATA OLUŞTU");
                    }
                    JOptionPane.showMessageDialog(null, "Kayıt başarılı");
                    // dashboard sayfasına yönlendir
                    JFrame frame = new DashBoard("Banka Sayfasına Hoşgeldiniz");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(1500, 1500);
                    frame.setVisible(true);
                }
            };
        }
    }
}
