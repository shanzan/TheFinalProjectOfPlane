import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class StartPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	boolean flag2=true;
	Timer backTime,writeTime;
	MovingBackground back1,back2;
	String backS="image//image1.jpg";
	WriteClass write;
	
	
	
	public StartPanel() {
		write=new WriteClass(0,200);
		back1=new MovingBackground(0, 0,650,1200, backS);
		back2=new MovingBackground(1200,0,650,1200, backS);
		backgroundTimeSet();
		backTime.start();
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		back1.paintBack(arg0);
		back2.paintBack(arg0);
		arg0.setColor(Color.WHITE);
		arg0.setFont(new Font("", Font.CENTER_BASELINE,80));
		arg0.drawString("SHOOT TO THRILL",250 ,100 );
		arg0.setFont(new Font(null,Font.BOLD, 25));
		arg0.drawString("This is a action type game",390,235);
		arg0.drawString("Here you fight with your enemy,"+"if you defeat the enemy boss you will win the Battle",100,260);
		arg0.setFont(new Font(null,Font.BOLD, 30));
		arg0.drawString("ENJOY THE GAME",420,290);
		arg0.drawString("Control",130,325);
		arg0.drawString("Version", 890,325);
		arg0.setFont(new Font(null,Font.BOLD, 25));
		arg0.drawString("press < Up Arrow > for move up",50,350);
		arg0.drawString("press < Down Arrow > for move down",50,380);
		arg0.drawString("press < Left Arrow > for move left",50,410);
		arg0.drawString("press < Right Arrow > for move right",50,440);
		arg0.drawString("press < 1 > for Shoot",50,470);
		arg0.drawString("This is a java platform game",800,350);
		arg0.drawString("which is made by Eclipse neon",800,380);
		arg0.drawString("Game Version: 1.1.0",800,410);
		arg0.drawString("JDK: 1.8.0_60",800,440);
		write.paintScreen(arg0);
		
		
	}
	public void backgroundTimeSet() {
	     backTime=new Timer(60, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (flag2==true) {
						write.wXpos+=3;
						back1.backX-=2;
						back2.backX-=2;
						if (back2.backX<-1199) {
							back2.setBackX(1200);
						}
						if (back1.backX<-1199) {
							back1.setBackX(1200);
						}
						if (write.wXpos>1200) {
							write.setwXpos(-350);
						}
						repaint();
					}
					
				}
			});
		}

}
