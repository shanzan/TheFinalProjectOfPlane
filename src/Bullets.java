
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullets {
int bXpos,bYpos;
	String imagepath;
	public Bullets(){
		
	}
	public Bullets(int x,int y,String path){
		
		this.bXpos=x;
		this.bYpos=y;
		this.imagepath=path;
	}
	public void paintBullet(Graphics g){
		ImageIcon icon=new ImageIcon(imagepath);
		Image image=icon.getImage();
		g.drawImage(image,bXpos,bYpos,20,5,null);
	}
	public void movePlayerBullets(){
			this.bXpos+=40;
	}	
	public int getbXpos() {
		return bXpos;
	}
	public void setbXpos(int bXpos) {
		this.bXpos = bXpos;
	}
	public int getbYpos() {
		return bYpos;
	}
	public void setbYpos(int bYpos) {
		this.bYpos = bYpos;
	}

}
