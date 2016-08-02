package com.hand.ln.jdbc.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hand.ln.util.AssertUtil;

public abstract class JdbcTemplate implements SqlQuery {
    static {
        String driver = PropertiesUtil.get("jdbc.driver");
        try {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection openConnection() {
        Connection conn = getConnection();
        return conn;
    }

    protected Connection getConnection() {
        return null;
    }

    ///////////////////////////////////////////
    // Implements closable interface
    ///////////////////////////////////////////
    public synchronized void close(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (!rs.isClosed() && (rs != null)) {
                rs.close();
            }
        }
        catch (SQLException e) {
        }

        try {
            if (!stat.isClosed() && (stat != null)) {
                stat.close();
            }
        }
        catch (SQLException e) {
        }

        try {
            if (!conn.isClosed() && (conn != null)) {
                conn.close();
            }
        }
        catch (SQLException e) {
        }
    }

    ///////////////////////////////////////////
    // Implements BaseDao interface
    ///////////////////////////////////////////

    @Override
    public <T> T select(String sql, ResultHandler<T> handler) {
        return select(sql, null, handler);
    }

    @Override
    public <T> T select(String sql, ArgumentsSetter setter, ResultHandler<T> handler) {
        AssertUtil.isNotEmpty(sql, "sql statement is empty");
        AssertUtil.isNotNull(handler, "result handler is null");
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        conn = openConnection();
        T obj = null;
        try {
            stat = conn.prepareStatement(sql);
            if (setter != null) {
                setter.setArgument(stat);
            }
            rs = stat.executeQuery();
            rs.next();
            obj = handler.extract(rs);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(conn, stat, rs);
        }
        return obj;
    }

    @Override
    public <T> List<T> selectList(String sql, ResultHandler<T> handler) {
        return selectList(sql, null, handler);
    }

    @Override
    public <T> List<T> selectList(String sql, ArgumentsSetter setter, ResultHandler<T> handler) {
        AssertUtil.isNotEmpty(sql, "sql statement is empty");
        AssertUtil.isNotNull(handler, "result handler is null");
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        conn = openConnection();
        List<T> list = new ArrayList<>();
        try {
            stat = conn.prepareStatement(sql);
            if (setter != null) {
                setter.setArgument(stat);
            }
            rs = stat.executeQuery();
            while (rs.next()) {
                list.add(handler.extract(rs));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(conn, stat, rs);
        }
        return list;
    }

    @Override
    public int update(String sql) {
        return execUpdate(sql, null);
    }

    @Override
    public int update(String sql, ArgumentsSetter setter) {
        return execUpdate(sql, setter);
    }

    @Override
    public int delete(String sql) {
        return execUpdate(sql, null);
    }

    @Override
    public int delete(String sql, ArgumentsSetter setter) {
        return execUpdate(sql, setter);
    }

    @Override
    public int insert(String sql) {
        // TODO Auto-generated method stub
        return execUpdate(sql, null);
    }

    @Override
    public int insert(String sql, ArgumentsSetter setter) {
        return execUpdate(sql, setter);
    }

    private int execUpdate(String sql, ArgumentsSetter setter) {
        AssertUtil.isNotEmpty(sql, "sql statement is empty");
        Connection conn = null;
        PreparedStatement stat = null;
        conn = openConnection();
        int rows = 0;
        try {
            stat = conn.prepareStatement(sql);
            if (setter != null) {
                setter.setArgument(stat);
            }
            rows = stat.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(conn, stat, null);
        }
        return rows;
    }

}
