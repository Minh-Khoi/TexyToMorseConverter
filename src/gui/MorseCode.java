/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class MorseCode {

    private static final int DOT = 200, DASH = DOT * 3, FREQ = 800;
    
    public static void main(String[] args) throws IOException, LineUnavailableException, InterruptedException {
        //boolean sound = !Arrays.asList(args).contains("-n");
        System.out.print("Hit enter to begin transmission.");
        String line = "-....-....-.....--.";
        
            for (char c : line.toUpperCase().toCharArray()) {
                
                    System.out.print(c == ' ' ? "\n" : c);
                    //if (sound) {
                        try (SourceDataLine sdl = AudioSystem.getSourceDataLine(new AudioFormat(8000F, 8, 1, true, false))) {
                            sdl.open(sdl.getFormat());
                            sdl.start();
                            for (int i = 0; i < (c == '.' ? DOT : DASH) * 8; i++) {
                                sdl.write(new byte[]{(byte) (Math.sin(i / (8000F / FREQ) * 2.0 * Math.PI) * 127.0)}, 0, 1);
                            }
                            sdl.drain();
                        }
                    //}
                    Thread.sleep(DOT / 5);
                    
                
            }
            System.out.print("\n\n>>> ");
        
    }
}