package com.hand.ln.pwdmanager.entry;

import java.util.List;

public class AppBean {
    private String appName;
    private List<String> aliases;

    AppBean() {

    }

    AppBean(String appName, List<String> aliases) {
        this.appName = appName;
        this.aliases = aliases;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }
}
