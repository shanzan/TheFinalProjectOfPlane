import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.JFrame;


public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	GamePanel panel;
	
	
	@SuppressWarnings("deprecation")
	public GameFrame(){
		panel=new GamePanel();
		super.setTitle("SHOOT TO THRILL");
		BorderLayout bl = new BorderLayout();
		super.setLayout(bl);
		this.setCursor(Cursor.MOVE_CURSOR);
		super.setSize(1200,650);
		super.setLocation(100, 10);
		this.add(panel);
		panel.setFocusable(true);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
