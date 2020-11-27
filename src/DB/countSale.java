package DB;

import common.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class countSale {

    private PreparedStatement stmt;
    private Connection conn;
    private ResultSet res;
    private final ArrayList<Sale> list= new ArrayList<>();
    public ArrayList<Sale> count()
    {
        try {
            connectDB connect = new connectDB();
            setConn(connect.connect());
            String sql = "SELECT name, SUM(number) AS number, SUM(total) AS total FROM  (SELECT a.name,b.number,b.total FROM goods a INNER JOIN orderitem b ON a.name = b.name) AS t " +
                    "GROUP BY t.name ORDER BY number DESC";
            setStmt(getConn().prepareStatement(sql));
            setRes(getStmt().executeQuery());
            while(getRes().next())
            {
                list.add(new Sale(getRes().getString("name"), getRes().getInt("number"), getRes().getFloat("total")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
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

        return list;
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
