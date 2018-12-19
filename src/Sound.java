import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Sound {
		public Clip clip;
	    public Sound(String filen) {
	    		try{
	    			File sound = new File(filen);
	    			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
	    			clip = AudioSystem.getClip();
	    			clip.open(ais);	
	    		}
	    		catch(Exception e){
	    			System.out.println("file not found");
	    		}	
	    }
	    	public void start() {
				clip.start();
			}
	    	public void stop() {
				clip.stop();
			}
	    	public void loop() {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
	    	

}
