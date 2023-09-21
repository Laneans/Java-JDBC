package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        //connecting to the DB
        Connection cnn = ConnectorDB.getConnection();
        settingDB();

        //new objects
        Statement st = cnn.createStatement();
        ArrayList<FilmText> lst = new ArrayList<>();

        //add 2 more objects in the DB
        st.executeUpdate("INSERT film_text VALUES (1001, 'FILM 1', 'Description of the Film 1')," +
                "(1002, 'FILM 2', 'Description of the Film 2')");

        //request for selecting all
        ResultSet rs = st.executeQuery("SELECT * FROM film_text");

        putInArrayList(rs,lst);
        seeResult(lst);

        //closing connection
        st.close();
        cnn.close();
    }

    static void seeResult(ArrayList<FilmText> lst) {
        if (lst.size() > 0) {
            for (FilmText film : lst) {
                System.out.println(film);
            }
        } else {
            System.out.println("Not found");
        }
    }

    private static void putInArrayList(ResultSet _rs,ArrayList<FilmText> lst) throws SQLException {
        while (_rs.next()) {
            FilmText currentFilm = new FilmText();
            currentFilm.setId(_rs.getInt("film_id"));
            currentFilm.setTitle(_rs.getString("title"));
            currentFilm.setDescription(_rs.getString("description"));
            lst.add(currentFilm);
        }
    }

    private static void settingDB() {
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "FNaf12112002");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
    }
}