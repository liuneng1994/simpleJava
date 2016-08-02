package com.hand.ln.jdbc.template;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultHandler<T> {
    T extract(ResultSet rs) throws SQLException;
}
