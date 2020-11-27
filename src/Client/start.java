package Client;

import common.Product;
import common.balance;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import static Client.toGray.convertToGray;

public class start extends JPanel{

	public start(JFrame jf, List<Product> list, balance b) {
		JPanel jp = this;
		setLayout(null);
		ImageIcon image;
		for(int i = 0; i < list.size(); i++)
		{
			JLabel lblNewLabel = new JLabel(String.valueOf(i));
			lblNewLabel.setBounds(14 + (i % 4) * 180, 13 + ((i / 4) % 3) * 180, 120, 150);
			add(lblNewLabel);
			lblNewLabel.addMouseListener(new MouseAdapter(){		
				public void mouseClicked(MouseEvent e) {
					choose c = new choose(jf, list.get(Integer.parseInt(lblNewLabel.getText())), jp, list, b);
					jf.setContentPane(c);
					jf.setTitle("选择界面");
					SwingUtilities.updateComponentTreeUI(jf);
				}
			});
			if(list.get(i).getCount() > 0)
			{
				image = new ImageIcon(list.get(i).getPath());
			}
			else {
				image = new ImageIcon(convertToGray(list.get(i).getPath()));
				lblNewLabel.removeMouseListener(lblNewLabel.getMouseListeners()[0]);
			}
			image.setImage(image.getImage().getScaledInstance(140,148,Image.SCALE_DEFAULT));
			lblNewLabel.setIcon(image);

			JLabel label = new JLabel("￥" + list.get(i).getPrice());
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
			label.setBounds(40 + (i % 4) * 180, 155 + ((i / 4) % 3) * 180, 72, 44);
			add(label);

			JLabel label1 = new JLabel(list.get(i).getName() + ": " + list.get(i).getCount());
			label1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
			label1.setBounds(720, 20 + i * 25, 120, 18);
			add(label1);
		}
		for (int i = 0; i < b.getMoney().length; i++)
		{
			JLabel label2 = new JLabel(b.getMoney()[i] + ": " + b.getBalance()[i]);
			label2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
			label2.setBounds(720, 350 + i * 25, 120, 18);
			add(label2);
		}
	}
}
