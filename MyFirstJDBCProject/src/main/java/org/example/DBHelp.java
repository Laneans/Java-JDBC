package org.example;

import java.sql.*;
import java.sql.SQLException;

public class DBHelp {
    private final static String SQL_INSERT = "INSERT INTO film_text(film_id, title, description) VALUES(?,?,?)";
    private final Connection connect;

    public DBHelp() throws SQLException {
       connect = ConnectorDB.getConnection();
    }

    public PreparedStatement getPreparedStatement() {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_INSERT);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void insertFilm(PreparedStatement ps, FilmText cr) {
        try {
            ps.setInt(1, cr.getId());
            ps.setString(2, cr.getTitle());
            ps.setString(3, cr.getDescription());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}