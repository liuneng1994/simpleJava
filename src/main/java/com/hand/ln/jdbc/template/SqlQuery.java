package com.hand.ln.jdbc.template;

import java.util.List;

public interface SqlQuery {
    <T> T select(String sql, ResultHandler<T> handler);

    <T> T select(String sql, ArgumentsSetter setter, ResultHandler<T> handler);

    <T> List<T> selectList(String sql, ResultHandler<T> handler);

    <T> List<T> selectList(String sql, ArgumentsSetter setter, ResultHandler<T> handler);

    int update(String sql);

    int update(String sql, ArgumentsSetter setter);

    int delete(String sql);

    int delete(String sql, ArgumentsSetter setter);

    int insert(String sql);

    int insert(String sql, ArgumentsSetter setter);
}
