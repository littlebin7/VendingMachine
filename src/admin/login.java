package admin;

import common.command;
import common.user;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class login extends JPanel {

	public login(JFrame jf) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");//账号
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel.setBounds(73, 108, 72, 18);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");//密码
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(73, 160, 72, 18);
		add(lblNewLabel_1);

		JTextField textField = new JTextField();
		textField.setBounds(148, 105, 167, 24);
		add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(148, 157, 167, 24);
		add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton.setBounds(152, 222, 113, 27);
		btnNewButton.addActionListener(e -> {
			try {
				Socket socket = new Socket("127.0.0.1", 65000);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

				out.writeObject(new command("adminLogin"));
				out.writeObject(new user(textField.getText(), textField_1.getText()));
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				boolean flag = (boolean) in.readObject();
				if(flag)
				{
					Backstage b = new Backstage(jf);
					jf.setContentPane(b);
					jf.setTitle("后台");
					jf.setSize(650,650);
					SwingUtilities.updateComponentTreeUI(jf);
				}
				in.close();
				out.flush();
				out.close();
				socket.close();
			} catch (IOException | ClassNotFoundException ioException) {
				ioException.printStackTrace();
			}
		});
		add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("\u540E\u53F0\u7BA1\u7406\u767B\u5F55");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(133, 41, 148, 33);
		add(lblNewLabel_2);

	}
}
