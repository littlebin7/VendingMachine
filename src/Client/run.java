package Client;

import common.Product;
import common.balance;

import java.util.List;
import javax.swing.JFrame;

public class run extends JFrame {

	public run(List<Product> list, balance b) {
		setTitle("\u81EA\u52A8\u996E\u6599\u552E\u8D27\u673A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 900, 600);
		start s = new start(this, list, b);
		setContentPane(s);
	}

}
