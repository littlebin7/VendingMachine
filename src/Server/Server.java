package Server;

import DB.countSale;
import DB.getList;
import DB.insertItem;
import DB.validate;
import common.user;
import common.Sale;
import common.command;
import common.goodsItem;
import common.goodsList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private final Socket socket;

    public Server(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            command com = (command) in.readObject();
            System.out.println(com.getCommand());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            switch(com.getCommand())
            {
                case "getList" :
                    goodsList list = new goodsList();
                    list.setList(new getList().get());
                    out.writeObject(list);
                    break;
                case "orderItem" :
                    goodsItem g = (goodsItem) in.readObject();
                    //System.out.println(g.toString());
                    new insertItem().insert(g);
                    break;
                case "adminLogin" :
                    user u = (user) in.readObject();
                    //System.out.println(u.getUser() + "  " + u.getPassword());
                    boolean flag = new validate().login(u);
                    //System.out.println(flag);
                    out.writeObject(flag);
                    break;
                case "select" :
                    ArrayList<Sale> s = new countSale().count();
                    out.writeObject(s);
                    break;
                default:
                    break;
            }
            in.close();
            out.flush();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}