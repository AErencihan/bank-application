package bank.client;

import javax.swing.*;

/**
 * @author Furkan Özmen
 */
public class BackButton extends JButton {

    public BackButton() {
        super("ANASAYFAYA DÖN");
        setSize(100, 100);
        setBorder(BorderFactory.createEmptyBorder());
    }

    public static void backButtonListener(BackButton backButton) {
        backButton.addActionListener(e -> {
            JFrame frame = new DashBoard("");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500, 1500);
            frame.setVisible(true);
        });
    }


}
