package com.hand.ln.java8;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface Handler<T> {
    T handle(PreparedStatement stat);
}
