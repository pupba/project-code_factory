 * @파일명 : Myframe.java
 * @프로젝트명 : JAVA_GUI_Study
 * @날짜 : 2022. 5. 16.
 * @작성자 : 7301-006
 * @프로그램설명 : 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MouseListener extends JFrame implements MouseListener {
	private JLabel label = new JLabel("Hello");
	
	public MouseListener() {
		setTitle("Mouse 이벤트 리스터 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(this);
		c.setLayout(null);
		this.label.setSize(50,20);
		this.label.setLocation(30,30);
		c.add(this.label);		
		setSize(250,250);
		setVisible(true);
	}
	
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.label.setLocation(x,y);
	}
	
	public static void main(String[] args) {
		new MouseListener();
	}
}
