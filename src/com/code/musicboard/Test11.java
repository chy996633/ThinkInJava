package com.code.musicboard;

//Test11.java
import java.io.IOException;
import javax.sound.sampled.*;

class AudioTest {
    //This class is used to play a section of 1 minute long music
    public void AudioPlay() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try{
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(classLoader.getResourceAsStream("audio1.wav"));

            clip.open(inputStream);
            clip.start();
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);
            clip.close();
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("done"); //to see if the sound is finished playing
    }
}
public class Test11 {

    public static void main(String[] args)  throws IOException
    {
        AudioTest au1 = new AudioTest();
        au1.AudioPlay();
    }

}
