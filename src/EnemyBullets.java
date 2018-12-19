import java.awt.Color;
import java.awt.Graphics;

public class EnemyBullets {
int eBXpos,eBYpos,weidth,height;
	
	public EnemyBullets(){
		
	}
	public EnemyBullets(int x,int y,int w,int h){
		this.eBXpos=x;
		this.eBYpos=y;
		this.weidth=w;
		this.height=h;
	}
	public void paintBullet(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(eBXpos, eBYpos,weidth,height);
	}
		
	public void moveEnemyBullets(){
		this.eBXpos-=1;
	}
	public int getbXpos() {
		return eBXpos;
	}
	public void setbXpos(int bXpos) {
		this.eBXpos = bXpos;
	}
	public int getbYpos() {
		return eBYpos;
	}
	public void setbYpos(int bYpos) {
		this.eBYpos = bYpos;
	}

}
