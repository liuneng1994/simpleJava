package com.hand.ln.jdbc.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.hand.ln.util.AssertUtil;

public class PrimaryJdbcTemplate extends JdbcTemplate {
    private String url;
    private String username;
    private String password;

    public PrimaryJdbcTemplate() {
        Properties prop = new Properties();
        url = PropertiesUtil.get("jdbc.url");
        AssertUtil.isNotEmpty(url, "Jdbc url is empty or null in file named jdbc.properties ");
        username = PropertiesUtil.get("jdbc.username");
        password = PropertiesUtil.get("jdbc.password");
    }

    public PrimaryJdbcTemplate(String url) {
        this(url, null, null);
    }

    public PrimaryJdbcTemplate(String url, String username, String password) {
        AssertUtil.isNotEmpty(url, "Jdbc url can not be empty or null");
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
