//imports (given in canvas prompt)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
 
//declare guessing game
public class GuessingGame
implements ActionListener {
 //initialize text fields
 JTextField guessField;

 //initialize buttons
 JButton guessButton, playAgainButton;
 
 //initialize labels
 JLabel userGuess, 
 highLow, 
 previousGuess;
 
 Random r = new Random();
 initialize object to represent random number
 int randomNum;
 
//Guessing game constructor
 GuessingGame() {
 
 //declare object to  represent random number
 randomNum = r.nextInt(101);
 
 //set up frame
 JFrame frame = new JFrame("Guessing Game"); 
 frame.setLayout(new FlowLayout()); 
 frame.setSize(240, 120); 
 guessField = new JTextField(10); 
 guessField.setActionCommand("myTF");
 guessButton = new JButton("Guess");
 playAgainButton = new JButton("Play Again");
 
 //Add Action Listeners
 guessField.addActionListener(this);
 guessButton.addActionListener(this);
 playAgainButton.addActionListener(this);
 
 //declare Labels
 userGuess = new JLabel("Enter your guess: ");
 highLow = new JLabel("");
 previousGuess = new JLabel("");
 
 //add everything to the frame
 frame.add(userGuess);
 frame.add(guessField);
 frame.add(guessButton);
 frame.add(highLow);
 frame.add(previousGuess);
 frame.add(playAgainButton);
 

 //set frame as visible
 frame.setVisible(true);
 }
 
 
 //conditional statement that checks whether guess is too low or too high
 public void actionPerformed(ActionEvent ae) {
 if(ae.getActionCommand().equals("Guess")) {
    int guess = Integer.parseInt(guessField.getText());
    
    if (guess < randomNum) {
      highLow.setText("Too low!");
      previousGuess.setText("Last guess was " + guess);
  }
    else if (guess > randomNum) {
    highLow.setText("Too high!");
    previousGuess.setText("Last guess was " + guess);
  }
 else {
 highLow.setText("You got it!");
 previousGuess.setText("Last guess was " + guess);
 }

 }
 else if(ae.getActionCommand().equals("Play Again")) {
  randomNum = r.nextInt(101);
  highLow.setText("");
  previousGuess.setText("");
  guessField.setText("");
  }
 else {
  highLow.setText("You pressed Enter. Please press the Guess Button.");
 }
 }
}