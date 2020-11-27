package admin;

import common.Sale;
import common.command;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Backstage extends JPanel {

	public Backstage(JFrame jf) {
		setLayout(null);
		ArrayList<Sale> test = null;
		try {
			Socket socket;
			socket = new Socket("127.0.0.1", 65000);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(new command("select"));
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			test = (ArrayList<Sale>) in.readObject();
			in.close();
			out.flush();
			out.close();
			socket.close();
		} catch (IOException | ClassNotFoundException ioException) {
			ioException.printStackTrace();
		}
		JLabel lblNewLabel = new JLabel("\u9500\u552E\u60C5\u51B5");//销售情况
		lblNewLabel.setBounds(90, 67, 72, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u603B\u9500\u552E\u989D");//总销售额
		lblNewLabel_1.setBounds(369, 67, 72, 18);
		add(lblNewLabel_1);

		float count = 0;
		for(int i = 0; i < test.size(); i++)
		{
			JLabel Label = new JLabel(test.get(i).getName());
			Label.setBounds(90, 132 + i * 31, 72, 18);
			add(Label);
			JLabel Label_3 = new JLabel(String.valueOf(test.get(i).getNumber()));
			Label_3.setBounds(219, 132 + i * 31, 72, 18);
			add(Label_3);
			count += test.get(i).getTotal();
		}

		JLabel lblNewLabel_4 = new JLabel(String.valueOf(count));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		lblNewLabel_4.setBounds(360, 116, 72, 44);
		add(lblNewLabel_4);

		JButton btnNewButton = new JButton("刷新");
		btnNewButton.setBounds(352, 449, 113, 27);
		btnNewButton.addActionListener(e->
		{
			Backstage b = new Backstage(jf);
			jf.setContentPane(b);
			SwingUtilities.updateComponentTreeUI(jf);
		});
		add(btnNewButton);

	}
}
