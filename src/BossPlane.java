import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class BossPlane {
	int bossX,bossY;
	boolean bossStart=false;
	ImageIcon icon;
	EnemyBullets bossBull,bossBull2;
	Timer bossbullTimer;
	boolean shot1=true;
	
	public BossPlane() {
		// TODO Auto-generated constructor stub
	}
	public BossPlane(int x,int y,boolean start) {
		bossBull=new EnemyBullets(this.bossX+80, this.bossY+20,30,5);
		bossBull2=new EnemyBullets(this.bossX+80, this.bossY+100,30,5);
		this.bossX=x;
		this.bossY=y;
		this.bossStart=start;
		bossShot();
	}
	public void bossPaint(Graphics g){
		bossBull.paintBullet(g);
		bossBull2.paintBullet(g);
		icon=new ImageIcon("image//boss.png");
		Image image=icon.getImage();
		g.drawImage(image, bossX, bossY, null);
	}
	public void bossShot(){
		bossbullTimer=new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (shot1==true) {
					bossBull.eBXpos-=5;
					bossBull2.eBXpos-=5;
					if (bossBull.eBXpos<-80) {
						bossBull.setbXpos(bossX+80);
					}
					if (bossBull2.eBXpos<-80) {
						bossBull2.setbXpos(bossX+80);
					}
					
				}
			}
		});
	}
	public void bossMove(){
		this.bossX-=2;
	}
	public int getBossX() {
		return bossX;
	}
	public void setBossX(int bossX) {
		this.bossX = bossX;
	}
	public boolean isBossStart() {
		return bossStart;
	}
	public void setBossStart(boolean bossStart) {
		this.bossStart = bossStart;
	}
	public int getBossY() {
		return bossY;
	}
	public void setBossY(int bossY) {
		this.bossY = bossY;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
}
