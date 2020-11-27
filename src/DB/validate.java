package DB;

import common.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class validate {

    private PreparedStatement stmt;
    private Connection conn;
    private ResultSet res;
    public boolean login(user u) {
        try {
            connectDB connect = new connectDB();
            setConn(connect.connect());
            String sql = "SELECT username FROM admin WHERE username = ? AND password = ?";
            setStmt(getConn().prepareStatement(sql));
            getStmt().setString(1, u.getUser());
            getStmt().setString(2, u.getPassword());
            setRes(getStmt().executeQuery());
            if(getRes().next()) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }finally {
            try {
                if(res != null)
                    res.close();
                if(stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        }

        return false;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }
}
