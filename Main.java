//Worked with Calvin Catania
//Copy and Pasted from Assignment Instructions
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Main {
 public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        new GuessingGame();
     }
   });
 }
} 