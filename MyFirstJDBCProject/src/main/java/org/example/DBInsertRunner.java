package org.example;

import java.sql.*;
import java.util.ArrayList;

public class DBInsertRunner {
    public static void main(String[] args) throws SQLException {
        //connecting to the DB
        DBHelp helper = new DBHelp();
        PreparedStatement statement = helper.getPreparedStatement();

        ArrayList<FilmText> list = new ArrayList<>() {
            {
                add(new FilmText(1003, "FILM 3", "Description of the Film 3"));
                add(new FilmText(1004, "FILM 4", "Description of the Film 4"));
                add(new FilmText(1005, "FILM 5", "Description of the Film 5"));
                add(new FilmText(1006, "FILM 6", "Description of the Film 6"));
                add(new FilmText(1007, "FILM 7", "Description of the Film 7"));
            }
        };
        addingByPrepareStatement(helper, statement, list);
    }

    private static void addingByPrepareStatement(DBHelp helper, PreparedStatement statement, ArrayList<FilmText> list) {
        try {
            //inserting in the DB
            for (FilmText film : list) {
                helper.insertFilm(statement, film);
            }
            Main.seeResult(list);
        }
        finally {
            assert helper != null;
            helper.closeStatement(statement);
        }
    }
}
