
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class StartFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	
	
		GameFrame frame;
		Timer timer;
		StartPanel startPanel;
		Sound s1;
		
		
		public StartFrame() {
		}
		public void startGame(){
		s1=new Sound("Sounds//AssaultOnMistCastle.wav");
		startPanel=new StartPanel();
		this.setTitle("SHOOT TO THRILL");
		this.setSize(1200, 650);
		this.setLocation(100,10);
		this.setFocusable(true);
		this.setVisible(true);
		this.setResizable(false);
		addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(startPanel);
		s1.loop();
	}
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				frame=new GameFrame();
				s1.stop();
				frame.setVisible(true);
				this.setVisible(false);
			}
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				System.exit(1);
			}
			
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			
			
		}
		
		
}
