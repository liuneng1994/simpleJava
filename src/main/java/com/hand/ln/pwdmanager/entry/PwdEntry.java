package com.hand.ln.pwdmanager.entry;

public class PwdEntry {
    private JudiciousAppBean app;
    private String account;
    private String encryptedPwd;

    public JudiciousAppBean getApp() {
        return app;
    }

    public void setApp(JudiciousAppBean app) {
        this.app = app;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEncryptedPwd() {
        return encryptedPwd;
    }

    public void setEncryptedPwd(String encryptedPwd) {
        this.encryptedPwd = encryptedPwd;
    }
}
