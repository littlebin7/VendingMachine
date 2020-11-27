package DB;

import common.goodsItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertItem {
    private PreparedStatement stmt;
    private Connection conn;

    public boolean insert(goodsItem g) {
        try {
            connectDB connect = new connectDB();
            setConn(connect.connect());
            String sql = "INSERT INTO orderitem (name, number, total, date) VALUES (?, ?, ?, ?)";
            setStmt(getConn().prepareStatement(sql));
            getStmt().setString(1, g.getName());
            getStmt().setInt(2, g.getNumber());
            getStmt().setFloat(3, g.getTotal());
            getStmt().setString(4, g.getDatetime());
            getStmt().executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }finally {
            try {
                if(stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        }

        return true;
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
}
