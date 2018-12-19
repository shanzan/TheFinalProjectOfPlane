import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	
	MovingBackground bground;
	MovingBackground background;
	Timer backTime,eTimer,bosstime;
	boolean flag=true,flag2=true,move=true,paint=false;
	Myplane plane;
	EnemyPlane ePlane,ePlane2,ePlane3,ePlane4;
	Random random=new Random();
	int pY=random.nextInt(510)+20;
	ImageIcon icon,icon2;
	int x=0,y=0,z=0,q=0,l=0,score=0,life=50,bossLife=50;
	Sound s,s2;
	String f1="Sounds//ReignOfAnarchy.wav";
	String f2="Sounds//NowOrNever.wav";
	String mback="image//sky.jpg";
	BossPlane boPlan;
	
	public GamePanel() {
		initial();
		backgroundTimeSet();
		enemeyMove();
		backTime.start();
		eTimer.start();
		s.loop();
		bossMoving();
	}
	
	@Override
	protected void paintComponent(Graphics ar) {
		super.paintComponent(ar);
		icon=new ImageIcon("image//mountains.png");
		icon2=new ImageIcon("image//ground.png");
		Image image=icon.getImage();
		Image image1=icon2.getImage();
		bground.paintBack(ar);
		background.paintBack(ar);
		ar.drawImage(image, 0,490,1200,80, null);
		ar.drawImage(image1, 0, 520,1200,114, null);
		
		plane.paintPlane(ar);
		ePlane.paintPlane(ar);
		ePlane2.paintPlane(ar);
		ePlane3.paintPlane(ar);
		ePlane4.paintPlane(ar);
		
		ar.setColor(Color.WHITE);
		ar.setFont(new Font(null,Font.BOLD, 25));
		ar.drawString("SCORE:"+score,200,20);
		ar.drawString("LIFE:"+life,500, 20);
		if (boPlan.bossStart==true) {
			boPlan.bossPaint(ar);
			ar.setColor(Color.RED);
			ar.drawString("Boss Life:"+bossLife, 800,20);
		}
		if (paint==true) {
			ar.setColor(Color.YELLOW);
			ar.setFont(new Font(null,Font.BOLD, 100));
			ar.drawString("GAME OVER", 300,200);
		}
	}
	public void initial(){
		bground=new MovingBackground(0, 0,540,1200,mback);
		background=new MovingBackground(1200, 0,540,1200,mback);
		plane=new Myplane(0, pY,"image//plane12.png",false);
		ePlane=new EnemyPlane(1200,80,"image//enemy.png");
		ePlane2=new EnemyPlane(1300,240,"image//enemy.png");
		ePlane3=new EnemyPlane(1250,410,"image//enemy.png");
		ePlane4=new EnemyPlane(1350,550,"image//enemy.png");
		s=new Sound(f1);
		s2=new Sound(f2);
		boPlan=new BossPlane(1400,0, false);
		super.addKeyListener(this);
	}
	public void backgroundTimeSet() {
	     backTime=new Timer(70, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (flag2==true) {
						bground.backX-=2;
						background.backX-=2;
						if (background.backX<-1199) {
							background.setBackX(1200);
						}
						if (bground.backX<-1199) {
							bground.setBackX(1200);
						}
						repaint();
					}
					
				}
			});
		}
	public void enemeyMove(){
		eTimer=new Timer(10, new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (move==true) {
					intersectRect();
					enemyMoving();
					}
				}
		});
	}
	public void enemyMoving(){
		ePlane.enemyPlaneMove();
		ePlane2.enemyPlaneMove();
		ePlane3.enemyPlaneMove();
		ePlane4.enemyPlaneMove();
		repaint();
		if (ePlane.eXpos<-250) {
			ePlane.seteXpos(1200);
			ePlane.seteYpos(random.nextInt(527));
			ePlane.eBullets.setbYpos(ePlane.geteYpos()+40);
			ePlane.enemyPlaneMove();
			repaint();
		}
		if (ePlane2.eXpos<-250) {
			ePlane2.seteXpos(1250);
			ePlane2.seteYpos(random.nextInt(527));
			ePlane2.eBullets.setbYpos(ePlane2.geteYpos()+40);
			ePlane2.enemyPlaneMove();
			repaint();
		}
		if (ePlane3.eXpos<-250) {
			ePlane3.seteXpos(1300);
			ePlane3.seteYpos(random.nextInt(527));
			ePlane3.eBullets.setbYpos(ePlane3.geteYpos()+40);
			ePlane3.enemyPlaneMove();
			repaint();
		}
		if (ePlane4.eXpos<-250) {
			ePlane4.seteXpos(1400);
			ePlane4.seteYpos(random.nextInt(527));
			ePlane4.eBullets.setbYpos(ePlane4.geteYpos()+40);
			ePlane4.enemyPlaneMove();
			repaint();
		}
	}
	public void bossMoving(){
		bosstime=new Timer(10,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (flag==true) {
					bossPlaneMoove();
				}
			}
		});
}
	public void bossPlaneMoove(){
		boPlan.bossMove();
		repaint();
		if (boPlan.bossX<-350) {
			boPlan.setBossX(1400);
			boPlan.setBossY(random.nextInt(527));
			boPlan.bossBull.setbYpos(boPlan.getBossY()+20);
			boPlan.bossBull2.setbYpos(boPlan.getBossY()+100);
			boPlan.bossMove();
			repaint();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
			intersectRect();
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			plane.moveUp();
			if (plane.isFlag()==false) {
				plane.bullets.setbXpos(plane.getpXpos()+70);
				plane.bullets.setbYpos(plane.getpYpos()+40);
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			plane.moveDown();
			if (plane.isFlag()==false) {
				plane.bullets.setbXpos(plane.getpXpos()+70);
				plane.bullets.setbYpos(plane.getpYpos()+40);
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			plane.moveLeft();
			if (plane.isFlag()==false) {
				plane.bullets.setbXpos(plane.getpXpos()+70);
				plane.bullets.setbYpos(plane.getpYpos()+40);
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			plane.moveRight();
			if (plane.isFlag()==false) {
				plane.bullets.setbXpos(plane.getpXpos()+70);
				plane.bullets.setbYpos(plane.getpYpos()+40);
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_1) {
			plane.setFlag(true);
		}
		super.repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_1) {
			plane.setFlag(false);
			plane.bullets.setbXpos(plane.getpXpos()+70);
			plane.bullets.setbYpos(plane.getpYpos()+40);
			repaint();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}
	public void intersectRect(){
		
		Rectangle plRect=new Rectangle(plane.getpXpos()+28,plane.getpYpos()+30,125,38);
		Rectangle plRect1=new Rectangle(plane.getpXpos()+146,plane.getpYpos()+39,102,20);
		Rectangle plBullets=new Rectangle(plane.bullets.getbXpos(),plane.bullets.getbYpos(), 20,5);
		
		Rectangle enRect1=new Rectangle(ePlane.geteXpos()+107, ePlane.geteYpos()+25,131,33);
		Rectangle enRect2=new Rectangle(ePlane2.geteXpos()+107, ePlane2.geteYpos()+25,131,33);
		Rectangle enRect3=new Rectangle(ePlane3.geteXpos()+107, ePlane3.geteYpos()+25,131,33);
		Rectangle enRect4=new Rectangle(ePlane4.geteXpos()+107, ePlane4.geteYpos()+25,131,33);
		
		Rectangle enRect11=new Rectangle(ePlane.geteXpos()+3, ePlane.geteYpos()+28,107,17);
		Rectangle enRect22=new Rectangle(ePlane2.geteXpos()+3, ePlane2.geteYpos()+28,107,17);
		Rectangle enRect33=new Rectangle(ePlane3.geteXpos()+3, ePlane3.geteYpos()+28,107,17);
		Rectangle enRect44=new Rectangle(ePlane4.geteXpos()+3, ePlane4.geteYpos()+28,107,17);
		
		Rectangle eBRect=new Rectangle(ePlane.eBullets.getbXpos(), ePlane.eBullets.getbYpos(), 20, 5);
		Rectangle eBRect1=new Rectangle(ePlane2.eBullets.getbXpos(), ePlane2.eBullets.getbYpos(), 20, 5);
		Rectangle eBRect2=new Rectangle(ePlane3.eBullets.getbXpos(), ePlane3.eBullets.getbYpos(), 20, 5);
		Rectangle eBRect3=new Rectangle(ePlane4.eBullets.getbXpos(), ePlane4.eBullets.getbYpos(), 20, 5);
		
		
		if (plRect.intersects(enRect1)==true ||plRect.intersects(enRect2)==true ||plRect.intersects(enRect3)==true||plRect.intersects(enRect4)==true
				||plRect.intersects(enRect11)==true ||plRect.intersects(enRect22)==true
				||plRect.intersects(enRect33)==true ||plRect.intersects(enRect44)==true|| plRect1.intersects(enRect1)==true
				|| plRect1.intersects(enRect2)==true || plRect1.intersects(enRect3)==true || plRect1.intersects(enRect4)==true || plRect1.intersects(enRect11)==true
				|| plRect1.intersects(enRect22)==true || plRect1.intersects(enRect33)==true || plRect1.intersects(enRect44)==true) {
			
			this.paint=true;
			s.stop();
			s2.start();
			JOptionPane.showMessageDialog(null, "Game Over \n YOU SCORED:"+score );
				System.exit(1);
		}
		
		if (plBullets.intersects(enRect1)==true || plBullets.intersects(enRect11)==true  ) {
			plane.bullets.setbXpos(plane.getpXpos()+70);
			plane.bullets.setbYpos(plane.getpYpos()+40);
			x++;
			if (x>10) {
				x=0;
				ePlane.seteXpos(1200);
				ePlane.seteYpos(random.nextInt(550));
				ePlane.eBullets.setbXpos(ePlane.geteXpos()+180);
				ePlane.eBullets.setbYpos(ePlane.geteYpos()+40);
				score++;
				
			}
		}
		if (plBullets.intersects(enRect2)==true || plBullets.intersects(enRect22)==true  ) {
			plane.bullets.setbXpos(plane.getpXpos()+70);
			plane.bullets.setbYpos(plane.getpYpos()+40);
			y++;
			if (y>10) {
				y=0;
				ePlane2.seteXpos(1200);
				ePlane2.seteYpos(random.nextInt(550));
				ePlane2.eBullets.setbXpos(ePlane2.geteXpos()+180);
				ePlane2.eBullets.setbYpos(ePlane2.geteYpos()+40);
				score++;
				
			}
		}
			if (plBullets.intersects(enRect3)==true || plBullets.intersects(enRect33)==true  ) {
				plane.bullets.setbXpos(plane.getpXpos()+70);
				plane.bullets.setbYpos(plane.getpYpos()+40);
				y++;
				if (y>10) {
					y=0;
					ePlane3.seteXpos(1200);
					ePlane3.seteYpos(random.nextInt(550));
					ePlane3.eBullets.setbXpos(ePlane3.geteXpos()+180);
					ePlane3.eBullets.setbYpos(ePlane3.geteYpos()+40);
					score++;
				
				}
			}
			if (plBullets.intersects(enRect4)==true || plBullets.intersects(enRect44)==true  ) {
				plane.bullets.setbXpos(plane.getpXpos()+70);
				plane.bullets.setbYpos(plane.getpYpos()+40);
				y++;
				if (y>10) {
					y=0;
					ePlane4.seteXpos(1200);
					ePlane4.seteYpos(random.nextInt(550));
					ePlane4.eBullets.setbXpos(ePlane4.geteXpos()+180);
					ePlane4.eBullets.setbYpos(ePlane4.geteYpos()+40);
					score++;
				}
			}
				
				
				if (plRect.intersects(eBRect)==true || plRect1.intersects(eBRect)==true ) {
					ePlane.eBullets.setbXpos(ePlane.geteXpos()+80);
					ePlane.eBullets.setbYpos(ePlane.geteYpos()+40);
					life--;
				}
				if (plRect.intersects(eBRect1)==true|| plRect1.intersects(eBRect)==true ) {
					ePlane2.eBullets.setbXpos(ePlane2.geteXpos()+80);
					ePlane2.eBullets.setbYpos(ePlane2.geteYpos()+40);
					life--;
				}
				if (plRect.intersects(eBRect2)==true|| plRect1.intersects(eBRect)==true ) {
					ePlane3.eBullets.setbXpos(ePlane3.geteXpos()+80);
					ePlane3.eBullets.setbYpos(ePlane3.geteYpos()+40);
					life--;
				}
				if (plRect.intersects(eBRect3)==true|| plRect1.intersects(eBRect)==true ) {
					ePlane4.eBullets.setbXpos(ePlane4.geteXpos()+80);
					ePlane4.eBullets.setbYpos(ePlane4.geteYpos()+40);
					life--;
				}
				if (life<0) {
					this.paint=true;
					s.stop();
					s2.start();
					JOptionPane.showMessageDialog(null,"GAME OVER \n You Scored:"+score);
						System.exit(1);
				}
				
				
				
				
				
				if (score>=25) {
					boPlan.setBossStart(true);
					bosstime.start();
					boPlan.bossbullTimer.start();
					Rectangle bossRect=new Rectangle(boPlan.getBossX()+12, boPlan.getBossY()+33,129,31);
					Rectangle bossRect1=new Rectangle(boPlan.getBossX()+129, boPlan.getBossY()+31,242 ,69);
					Rectangle bossBullRect=new Rectangle(boPlan.bossBull.getbXpos(),boPlan.bossBull.getbYpos(), 30,5);
					Rectangle bossBullRect1=new Rectangle(boPlan.bossBull2.getbXpos(),boPlan.bossBull2.getbYpos(), 30,5);
					
					if (bossRect.intersects(plRect)==true || bossRect1.intersects(plRect)==true || bossRect.intersects(plRect1)==true || bossRect1.intersects(plRect1)==true) {
						this.paint=true;
						s.stop();
						s2.start();
						JOptionPane.showMessageDialog(null,"GAME OVER \n You Scored:"+score);
							System.exit(1);
					}
					
					if (bossBullRect.intersects(plRect)==true || bossBullRect.intersects(plRect1)==true) {
						boPlan.bossBull.setbXpos(boPlan.getBossX()+80);
						boPlan.bossBull.setbYpos(boPlan.getBossY()+20);
						life-=2;
					}
					if (bossBullRect1.intersects(plRect)==true || bossBullRect1.intersects(plRect1)==true) {
						boPlan.bossBull2.setbXpos(boPlan.getBossX()+80);
						boPlan.bossBull2.setbYpos(boPlan.getBossY()+100);
						life-=2;
					}
					if (plBullets.intersects(bossRect)==true || plBullets.intersects(bossRect1)==true) {
						plane.bullets.setbXpos(plane.getpXpos()+70);
						plane.bullets.setbYpos(plane.getpYpos()+40);
						l++;
						if (l>10) {
							l=0;	
							score++;
							bossLife--;
						}
					}
					if (bossLife<=0) {
						this.paint=true;
						gameOver();
						s.stop();
						s2.start();
						JOptionPane.showMessageDialog(null,"CONGRATULATION \n \n YOU GOT THE BATTLE \n \n YOU SCORED: "+score);
							System.exit(1);
					}
					
				}
	}
	public void gameOver(){
		this.eTimer.stop();
		this.bosstime.stop();
		this.boPlan.bossbullTimer.stop();
		this.ePlane.timer.stop();
		this.flag2=false;
		boPlan.setBossStart(false);
		boPlan.setBossY(1000);
		boPlan.bossBull.setbYpos(1000);
		boPlan.bossBull2.setbYpos(1000);
		ePlane.seteYpos(1000);
		ePlane2.seteYpos(1000);
		ePlane3.seteYpos(1000);
		ePlane4.seteYpos(1000);
		ePlane.eBullets.setbYpos(10000);
		ePlane2.eBullets.setbYpos(10000);
		ePlane3.eBullets.setbYpos(10000);
		ePlane4.eBullets.setbYpos(10000);
		plane.setpXpos(100);
		plane.bullets.setbXpos(plane.getpXpos()+70);
		plane.bullets.setbYpos(plane.getpYpos()+35);
	}
}