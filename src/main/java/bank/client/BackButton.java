package bank.client;

import javax.swing.*;

/**
 * @author Furkan Özmen
 */
public class BackButton extends JButton {

    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu();


    public JMenuBar initializeMenubar(){

        JMenuItem item = new JMenuItem();
        item.add(new BackButton());
        menu.add(item);
        menuBar.add(menu);
        menuBar.setSize(200,200);
        menu.setSize(400,400);
        menuBar.setLayout(null);
        menuBar.setVisible(true);
        return menuBar;
    }


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
