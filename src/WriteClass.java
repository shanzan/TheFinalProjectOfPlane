import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class WriteClass{
	int wXpos,wYpos;
	public WriteClass() {
		
	}
	public WriteClass(int x,int y) {
		this.wXpos=x;
		this.wYpos=y;
	}
	public void paintScreen(Graphics arg0){
		arg0.setColor(Color.WHITE);
		arg0.setFont(new Font(null,Font.BOLD, 35));
		arg0.drawString("PRESS ENTER TO START THE GAME",wXpos,wYpos);
		arg0.setColor(Color.RED);
		arg0.setFont(new Font(null,Font.BOLD, 20));
		arg0.drawString("this is a copyright version made for the final project of aiub java(fall 2015-16) sec:I",wXpos,wYpos+405);
	}
	public int getwXpos() {
		return wXpos;
	}
	public void setwXpos(int wXpos) {
		this.wXpos = wXpos;
	}
	public int getwYpos() {
		return wYpos;
	}
	public void setwYpos(int wYpos) {
		this.wYpos = wYpos;
	}
}