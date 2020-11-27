package Client;

import common.Product;
import common.balance;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class charge extends JPanel {

	DecimalFormat fum = new DecimalFormat("##0.0");

	public charge(JFrame jf, float f, List<Product> list, balance b) {
		setLayout(null);

		JLabel textField = new JLabel();
		textField.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 24));
		textField.setText("\u611F\u8C22\u60E0\u987E\uFF0C\u5DF2\u51FA\u8D27");
		textField.setBounds(340, 88, 211, 72);
		add(textField);

		JLabel textField_1 = new JLabel();
		textField_1.setFont(new Font("宋体", Font.BOLD, 20));
		textField_1.setText("\u627E\u96F6");
		textField_1.setBounds(135, 240, 77, 47);
		add(textField_1);

		JLabel textField_2 = new JLabel(fum.format(f) + "元");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("宋体", Font.BOLD, 20));
		textField_2.setBounds(258, 240, 110, 47);
		add(textField_2);

		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u9875");
		btnNewButton.addActionListener(e -> {
			start s = new start(jf, list, b);
			jf.setContentPane(s);
			jf.setTitle("自动饮料售货机");
			SwingUtilities.updateComponentTreeUI(jf);
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton.setBounds(340, 451, 211, 72);
		add(btnNewButton);


	}

}
