package Client;

import common.Product;
import common.balance;
import common.command;
import common.goodsItem;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class pay extends JPanel {

	private JLabel textField_5;
	DecimalFormat fum = new DecimalFormat("##0.0");

	public pay(JFrame jf, Product p, int num, List<Product> list, balance b) {
		int[] balance_copy = b.getBalance();
		setLayout(null);

		JLabel textField = new JLabel();
		textField.setFont(new Font("宋体", Font.BOLD, 20));
		textField.setText("\u5E94\u4ED8");
		textField.setBounds(69, 119, 77, 41);
		add(textField);

		JLabel textField_1 = new JLabel(p.getPrice() * num + "元");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("宋体", Font.BOLD, 20));
		textField_1.setBounds(202, 121, 113, 41);
		add(textField_1);

		JLabel textField_2 = new JLabel();
		textField_2.setFont(new Font("宋体", Font.BOLD, 20));
		textField_2.setText("\u7EB8\u5E01");
		textField_2.setBounds(69, 203, 77, 41);
		add(textField_2);

		JLabel textField_3 = new JLabel();
		textField_3.setFont(new Font("宋体", Font.BOLD, 20));
		textField_3.setText("\u786C\u5E01");
		textField_3.setBounds(69, 293, 77, 41);
		add(textField_3);

		JButton btnNewButton = new JButton("50\u5143");
		btnNewButton.addActionListener(e ->
		{
			balance_copy[0] += 1;
			textField_5.setText((Float.parseFloat(textField_5.getText().split("元")[0]) + Integer.parseInt(btnNewButton.getText().split("元")[0])) + "元");
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(202, 210, 77, 27);
		add(btnNewButton);

		JButton btnNewButton_1_5 = new JButton("5\u89D2");
		btnNewButton_1_5.addActionListener(e ->
		{
			balance_copy[6] += 1;
			textField_5.setText(fum.format(Float.parseFloat(textField_5.getText().split("元")[0]) + 0.5) + "元");
		});
		btnNewButton_1_5.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1_5.setBounds(353, 300, 113, 27);
		add(btnNewButton_1_5);

		JButton btnNewButton_1_6 = new JButton("1\u89D2");
		btnNewButton_1_6.addActionListener(e ->
		{
			balance_copy[7] += 1;
			textField_5.setText(fum.format(Float.parseFloat(textField_5.getText().split("元")[0]) + 0.1) + "元");
		});
		btnNewButton_1_6.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1_6.setBounds(505, 300, 113, 27);
		add(btnNewButton_1_6);

		JButton btnNewButton_1_7 = new JButton("\u4ED8\u6B3E");
		btnNewButton_1_7.addActionListener(e -> {
			if(Float.parseFloat(textField_5.getText().split("元")[0]) >= p.getPrice() * num)
			{
				Socket socket;
				try {
					socket = new Socket("127.0.0.1", 65000);
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					out.writeObject(new command("orderItem"));
					out.writeObject(new goodsItem(p.getName(), num, p.getPrice() * num, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
					while(!socket.isConnected()) {
						out.flush();
						out.close();
						socket.close();
					}
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				balance_copy[5] -=  (Float.parseFloat(textField_5.getText().split("元")[0]) - p.getPrice() * num);
				b.setBalance(balance_copy);
				charge c = new charge(jf,Float.parseFloat(textField_5.getText().split("元")[0]) - p.getPrice() * num, list, b);
				jf.setContentPane(c);
				jf.setTitle("找零界面");
				SwingUtilities.updateComponentTreeUI(jf);
				p.setCount(p.getCount() - num);
			}
		});
		btnNewButton_1_7.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton_1_7.setBounds(202, 462, 125, 47);
		add(btnNewButton_1_7);

		JButton btnNewButton_1 = new JButton("20\u5143");
		btnNewButton_1.addActionListener(e ->
		{
			balance_copy[1] += 1;
			textField_5.setText((Float.parseFloat(textField_5.getText().split("元")[0]) + Integer.parseInt(btnNewButton_1.getText().split("元")[0])) + "元");
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(304, 210, 86, 27);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("10\u5143");
		btnNewButton_2.addActionListener(e ->
		{
			balance_copy[2] += 1;
			textField_5.setText((Float.parseFloat(textField_5.getText().split("元")[0]) + Integer.parseInt(btnNewButton_2.getText().split("元")[0])) + "元");
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_2.setBounds(416, 210, 86, 27);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("5\u5143");
		btnNewButton_3.addActionListener(e ->
		{
			balance_copy[3] += 1;
			textField_5.setText((Float.parseFloat(textField_5.getText().split("元")[0]) + Integer.parseInt(btnNewButton_3.getText().split("元")[0])) + "元");
		});
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_3.setBounds(526, 210, 86, 27);
		add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("1\u5143");
		btnNewButton_4.addActionListener(e ->
		{
			balance_copy[4] += 1;
			textField_5.setText((Float.parseFloat(textField_5.getText().split("元")[0]) + Integer.parseInt(btnNewButton_4.getText().split("元")[0])) + "元");
		});
		btnNewButton_4.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_4.setBounds(643, 210, 86, 27);
		add(btnNewButton_4);

		JButton btnNewButton_1_5_1 = new JButton("1\u5143");
		btnNewButton_1_5_1.addActionListener(e ->
		{
			balance_copy[5] += 1;
			textField_5.setText((Float.parseFloat(textField_5.getText().split("元")[0]) + Integer.parseInt(btnNewButton_1_5_1.getText().split("元")[0])) + "元");
		});
		btnNewButton_1_5_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1_5_1.setBounds(202, 300, 113, 27);
		add(btnNewButton_1_5_1);

		JLabel textField_4 = new JLabel();
		textField_4.setText("\u5B9E\u4ED8");
		textField_4.setFont(new Font("宋体", Font.BOLD, 20));
		textField_4.setBounds(492, 119, 77, 41);
		add(textField_4);

		textField_5 = new JLabel("0元");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("宋体", Font.BOLD, 20));
		textField_5.setBounds(632, 119, 113, 41);
		add(textField_5);

		JButton btnNewButton_1_7_1 = new JButton("\u9000\u94B1\u8FD4\u56DE");
		btnNewButton_1_7_1.addActionListener(e -> {
			start s = new start(jf, list, b);
			jf.setContentPane(s);
			jf.setTitle("自动饮料售货机");
			SwingUtilities.updateComponentTreeUI(jf);
		});
		btnNewButton_1_7_1.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton_1_7_1.setBounds(469, 462, 133, 47);
		add(btnNewButton_1_7_1);
	}

}
