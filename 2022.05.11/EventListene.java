import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EventListen extends JFrame implements ActionListener {
	private JLabel label = new JLabel("10");
	public EventListen() {
		setTitle("Action 이벤트 리스터 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		this.label.setOpaque(true);
		this.label.setBackground(Color.CYAN);
		JButton btn1 = new JButton("+1");
		JButton btn2 = new JButton("+5");
		JButton btn3 = new JButton("+10");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		c.add(this.label);
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		
		setSize(350,150);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		System.out.println(s);
		int tmp = Integer.parseInt(this.label.getText());
		
		if(s.equals("+1")) 
			tmp +=1;
		else if(s.equals("+5")) 
			tmp +=5;
		else if(s.equals("+10")) 
		    tmp +=10;
		
		String num = Integer.toString(tmp);
		this.label.setText(num);
	}
	public static void main(String[] args) {
		new EventListen();
	}
}
