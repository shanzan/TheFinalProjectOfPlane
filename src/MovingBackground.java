import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MovingBackground {
	int backX,backY,backH,backW;
	ImageIcon icon3;
	String path;
	public MovingBackground() {
		
	}
	public MovingBackground(int x,int y,int h,int w,String p){
		this.backX=x;
		this.backY=y;
		this.path=p;
		this.backH=h;
		this.backW=w;
	}
	public void paintBack(Graphics g){
    icon3=new ImageIcon(path);
	Image i=icon3.getImage();
	g.drawImage(i, backX, backY,backW,backH, null);
		
	}
	public int getBackX() {
		return backX;
	}
	public void setBackX(int backX) {
		this.backX = backX;
	}
	public int getBackY() {
		return backY;
	}
	public void setBackY(int backY) {
		this.backY = backY;
	}



}
