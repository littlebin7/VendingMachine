package Client;

import common.Product;
import common.balance;
import common.command;
import common.goodsList;
import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Client {
    private static List<Product> list;
    private static balance b = new balance();
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("49.140.59.239", 65000);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(new command("getList"));
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            goodsList test = (goodsList) in.readObject();
            list = test.getList();
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    run frame = new run(list, b);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            in.close();
            out.flush();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}