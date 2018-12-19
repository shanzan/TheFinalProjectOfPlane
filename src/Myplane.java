
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Myplane{
	private int pXpos,pYpos;
	private String imagepath;
	Bullets bullets;
	Timer bullTimer;
	private boolean flag=false;
	public Myplane() {
		
	}
	public Myplane(int x,int y,String image,boolean f){
		bullets=new Bullets(x+70, y+35,"image//bullet1.png");
		this.imagepath=image;
		this.pXpos=x;
		this.pYpos=y;
		this.flag=false;
		bulletTimer();
		bullTimer.start();
	}
	public void paintPlane(Graphics g){
		bullets.paintBullet(g);
		ImageIcon icon=new ImageIcon(imagepath);
		Image image=icon.getImage();
		g.drawImage(image, pXpos, pYpos, null);
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void moveUp(){
		if(this.pYpos>=0){
			this.pYpos-=8;
		}
	}
	public void moveDown(){
		if(this.pYpos<=550){
			this.pYpos+=8;
		}
	}
	public void moveLeft(){
		if(this.pXpos>=-15){
			this.pXpos-=8;
		}
	}
	public void moveRight(){
		if(this.pXpos<=1040){
			this.pXpos+=8;
		}
	}
	public int getpXpos() {
		return pXpos;
	}
	public void setpXpos(int pXpos) {
		this.pXpos = pXpos;
	}
	public int getpYpos() {
		return pYpos;
	}
	public void setpYpos(int pYpos) {
		this.pYpos = pYpos;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public void bulletTimer(){
		bullTimer=new Timer(1,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (flag==true) {
					bulletsRun();
				}
				
			}
		});
	}
	public void bulletsRun() {
		bullets.movePlayerBullets();
		if(bullets.bXpos>1250){
			bullets.setbXpos(pXpos+70);
			bullets.setbYpos(pYpos+40);
			bullets.movePlayerBullets();
	}
}

}
