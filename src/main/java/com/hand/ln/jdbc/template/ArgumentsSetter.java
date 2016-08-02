package com.hand.ln.jdbc.template;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface ArgumentsSetter {
    public void setArgument(PreparedStatement stat) throws SQLException;
}
