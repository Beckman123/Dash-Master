
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

// Using guide:
// https://www.youtube.com/watch?v=nUHh_J2Acy8&list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq&index=9

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/audio/assets/DashMaster.wav");
        soundURL[1] = getClass().getResource("/audio/assets/dashAudio.wav");
        soundURL[2] = getClass().getResource("/audio/assets/damageAudio.wav");
        // soundURL[3] = getClass().getResource("/audio/assets/skullSpawn.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}