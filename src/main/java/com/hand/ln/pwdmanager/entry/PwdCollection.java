package com.hand.ln.pwdmanager.entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

public class PwdCollection {
    private final Map<String, List<PwdEntry>> pwdMap;

    public PwdCollection() {
        pwdMap = new HashMap<String, List<PwdEntry>>();
    }

    public boolean isEmpty() {
        return pwdMap.isEmpty();
    }

    public void add(PwdEntry pwd) {
        Assert.isNull(pwd, "password entry can not be null");
        List<PwdEntry> list = pwdMap.get(pwd.getApp().getAppName());
        if (list == null) {
            list = new ArrayList<PwdEntry>();
        }

    }

    public void addAll(List<PwdEntry> list) {
    }

    public void remove() {

    }
}
