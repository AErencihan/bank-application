package bank.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Eray Tekin
 */
public class LogoutListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
