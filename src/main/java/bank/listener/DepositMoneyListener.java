package bank.listener;

import bank.model.Account;
import bank.model.FileFacade;
import bank.model.FilePaths;
import bank.service.AccountService;
import bank.util.JsonReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.List;

import static bank.listener.AccountDeleteListener.reWriteData;

public class DepositMoneyListener implements ActionListener {
    private final AccountService accountService;

    public DepositMoneyListener(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Long IBAN = Long.valueOf(JOptionPane.showInputDialog("Para yatırmak istediğiniz hesap numarasını giriniz"));
        final String AMOUNT = JOptionPane.showInputDialog("Yatırmak istediğiniz tutarı giriniz");

        try {
            final List<LinkedHashMap> accounts = JsonReader.read(FilePaths.ACCOUNT.getPath(), List.class);
            final Account account = accountService.findByIban(IBAN, accounts);

            FileFacade.deleteFile(FilePaths.ACCOUNT.getPath());

            account.setBalance(account.getBalance() + Double.parseDouble(AMOUNT));
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("id", account.getId());
            map.put("balance", account.getBalance());
            map.put("currency", account.getCurrency());
            map.put("customerId", account.getCustomerId());
            accounts.add(map);
            reWriteData(accounts);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hesap bulunamadı");
            throw new RuntimeException(ex);
        }

    }
}
