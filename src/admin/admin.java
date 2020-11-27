package admin;

import javax.swing.*;
import java.awt.*;

public class admin extends JFrame {
    public admin() {
        setTitle("\u81EA\u52A8\u996E\u6599\u552E\u8D27\u673A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 450, 350);
        login l = new login(this);
        setContentPane(l);
    }
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                admin frame = new admin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}