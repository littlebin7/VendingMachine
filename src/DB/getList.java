package DB;

import common.Product;
import java.sql.*;
import java.util.ArrayList;

public class getList {
    private PreparedStatement stmt;
    private Connection conn;
    private ResultSet res;
    private final ArrayList<Product> list= new ArrayList<>();
    public ArrayList<Product> get()
    {
        try {
            connectDB connect = new connectDB();
            setConn(connect.connect());
            String sql = "SELECT name,path,price,number FROM goods";
            setStmt(getConn().prepareStatement(sql));
            setRes(getStmt().executeQuery());
            while(getRes().next())
            {
                list.add(new Product(getRes().getString("name"), getRes().getString("path"),
                        getRes().getFloat("price"), getRes().getInt("number") ));
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
