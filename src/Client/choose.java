package Client;

import common.Product;
import common.balance;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.SwingConstants;

public class choose extends JPanel {

	private final JLabel textField_5;
	private final JLabel textField_6;
	private final JButton btnNewButton_2;
	private final JButton btnNewButton_2_1;
	private final JCheckBox checkboxNewCheckBox;
	private final JCheckBox checkboxNewCheckBox_1;
	private final JCheckBox checkboxNewCheckBox_2;
	public choose(JFrame jf, Product product, JPanel jp, List<Product> list, balance b) {
		setLayout(null);
		setVisible(true);

		JLabel textField = new JLabel();
		textField.setBounds(56, 84, 319, 400);
		ImageIcon image = new ImageIcon(product.getPath());
		image.setImage(image.getImage().getScaledInstance(textField.getWidth(), textField.getHeight(),Image.SCALE_DEFAULT));
		textField.setIcon(image);
		add(textField);

		JLabel textField_1 = new JLabel();
		textField_1.setFont(new Font("宋体", Font.BOLD, 20));
		textField_1.setText("\u5546\u54C1\u5355\u4EF7:");
		textField_1.setBounds(428, 97, 101, 30);
		add(textField_1);

		JLabel textField_2 = new JLabel(product.getPrice() + "元");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("宋体", Font.BOLD, 20));
		textField_2.setBounds(562, 97, 101, 30);
		add(textField_2);

		JLabel textField_3 = new JLabel();
		textField_3.setFont(new Font("宋体", Font.BOLD, 20));
		textField_3.setText("\u6570\u91CF\uFF1A");
		textField_3.setBounds(439, 167, 101, 30);
		add(textField_3);

		checkboxNewCheckBox = new JCheckBox("\u5E38\u6E29");
		checkboxNewCheckBox.setFont(new Font("宋体", Font.BOLD, 20));
		checkboxNewCheckBox.setBounds(439, 243, 133, 27);
		checkboxNewCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkboxNewCheckBox_1.setSelected(false);
				checkboxNewCheckBox_2.setSelected(false);
			}
		});
		add(checkboxNewCheckBox);

		checkboxNewCheckBox_1 = new JCheckBox("\u52A0\u70ED");
		checkboxNewCheckBox_1.setFont(new Font("宋体", Font.BOLD, 20));
		checkboxNewCheckBox_1.setBounds(439, 275, 133, 27);
		checkboxNewCheckBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkboxNewCheckBox.setSelected(false);
				checkboxNewCheckBox_2.setSelected(false);
			}
		});
		add(checkboxNewCheckBox_1);

		checkboxNewCheckBox_2 = new JCheckBox("\u5236\u51B7");
		checkboxNewCheckBox_2.setFont(new Font("宋体", Font.BOLD, 20));
		checkboxNewCheckBox_2.setBounds(439, 307, 133, 27);
		checkboxNewCheckBox_2.addActionListener(e -> {
			checkboxNewCheckBox_1.setSelected(false);
			checkboxNewCheckBox.setSelected(false);
		});
		add(checkboxNewCheckBox_2);

		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkboxNewCheckBox.isSelected() || checkboxNewCheckBox_1.isSelected() || checkboxNewCheckBox_2.isSelected())
				{
					pay c = new pay(jf, product, Integer.parseInt(textField_6.getText()), list, b);
					jf.setContentPane(c);
					jf.setTitle("付款界面");
					SwingUtilities.updateComponentTreeUI(jf);
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton.setBounds(439, 489, 133, 45);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(e -> {
			//start c = new start(jf, list);
			jf.setContentPane(jp);
			jf.setTitle("自动饮料售货机");
			SwingUtilities.updateComponentTreeUI(jf);
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton_1.setBounds(672, 489, 133, 45);
		add(btnNewButton_1);

		JLabel textField_4 = new JLabel();
		textField_4.setFont(new Font("宋体", Font.BOLD, 20));
		textField_4.setText("\u5E94\u4ED8\uFF1A");
		textField_4.setBounds(439, 365, 101, 30);
		add(textField_4);

		textField_5 = new JLabel(product.getPrice() * 1 + "元");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("宋体", Font.BOLD, 20));
		textField_5.setBounds(562, 365, 101, 30);
		add(textField_5);

		btnNewButton_2 = new JButton("-");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(textField_6.getText()) > 1)
				{
					btnNewButton_2_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					textField_6.setText(String.valueOf(Integer.parseInt(textField_6.getText()) - 1));
					textField_5.setText(Integer.parseInt(textField_6.getText()) * product.getPrice() + "元");
				}
				else {
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_2.setBounds(562, 168, 44, 30);
		add(btnNewButton_2);

		textField_6 = new JLabel("1");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("宋体", Font.BOLD, 20));
		textField_6.setBounds(616, 167, 86, 30);
		add(textField_6);

		btnNewButton_2_1 = new JButton("+");
		btnNewButton_2_1.addActionListener(e -> {
			if(Integer.parseInt(textField_6.getText()) < product.getCount())
			{
				btnNewButton_2_1.setEnabled(true);
				btnNewButton_2.setEnabled(true);
				textField_6.setText(String.valueOf(Integer.parseInt(textField_6.getText()) + 1));
				textField_5.setText(Integer.parseInt(textField_6.getText()) * product.getPrice() + "元");
			}
			else {
				btnNewButton_2_1.setEnabled(false);
			}
		});
		btnNewButton_2_1.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(716, 169, 44, 30);
		add(btnNewButton_2_1);

	}
}
