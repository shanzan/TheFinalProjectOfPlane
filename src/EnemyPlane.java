import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class EnemyPlane {
	int eXpos,eYpos;
	String imagepath;
	EnemyBullets eBullets;
	boolean shot=true;
	Timer timer;
	
		public EnemyPlane() {
			
		}
		public EnemyPlane(int x,int y,String image){
			this.imagepath=image;
			this.eXpos=x;
			this.eYpos=y;
			eBullets=new EnemyBullets(this.eXpos+80, this.eYpos+40,20,5);
			enemyShot();
			timer.start();
		}
		public void paintPlane(Graphics g){
			eBullets.paintBullet(g);
			ImageIcon icon=new ImageIcon(imagepath);
			Image image=icon.getImage();
			g.drawImage(image, eXpos, eYpos, null);
		}
		public void enemyShot(){
			timer=new Timer(8, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (shot==true) {
						eBullets.eBXpos-=5;
						if (eBullets.eBXpos<-80) {
							eBullets.setbXpos(eXpos+80);
						}
					}
					
				}
			});
		}
		public void enemyPlaneMove(){
			this.eXpos-=1;
		}
		public int geteXpos() {
			return eXpos;
		}
		public void seteXpos(int eXpos) {
			this.eXpos = eXpos;
		}
		public int geteYpos() {
			return eYpos;
		}
		public void seteYpos(int eYpos) {
			this.eYpos = eYpos;
		}
		public String getImagepath() {
			return imagepath;
		}
		public void setImagepath(String imagepath) {
			this.imagepath = imagepath;
		}
	
}
