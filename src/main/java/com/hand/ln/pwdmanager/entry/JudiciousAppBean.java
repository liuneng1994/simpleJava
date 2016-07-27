package com.hand.ln.pwdmanager.entry;

import java.util.List;

import com.hand.ln.pwdmanager.judge.JudgeAlias;
import com.hand.ln.pwdmanager.judge.JudgeName;

public class JudiciousAppBean extends AppBean implements JudgeAlias, JudgeName {

    public JudiciousAppBean() {
        super();
    }

    public JudiciousAppBean(String appName, List<String> aliases) {
        super(appName, aliases);
    }

    public boolean NameEqual(String name) {
        return getAppName() == name;
    }

    public boolean HasAlias(String alias) {
        for (String aliasItem : getAliases()) {
            if (aliasItem.equals(alias)) {
                return true;
            }
        }
        return false;
    }
}
