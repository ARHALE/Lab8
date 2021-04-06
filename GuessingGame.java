//imports (given in canvas prompt)
  //first 3 imports are for GUI and last is for generating random numbers
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
 
//declare guessing game
public class GuessingGame
//initialize action  listener that will respond to various stimuli in the gui
implements ActionListener {
 //initialize text fields
 JTextField guessField;

 //initialize buttons
 JButton guessButton, playAgainButton;
 
 //initialize labels in summarized notation
 JLabel userGuess, 
 highLow, 
 previousGuess;

 
 Random r = new Random();
 //initialize object to represent random number
 int randomNum;
 
//Guessing game constructor
 GuessingGame() {
 
 //declare object to  represent random number
 randomNum = r.nextInt(101);
 
 //set up & gives a  tile for frame
 JFrame frame = new JFrame("Guessing Game"); 
 //sets the laytout type to  "flow"
 frame.setLayout(new FlowLayout()); 
 //sets the size of  the frame
 frame.setSize(240, 120); 
 //creates a text fiekd
 guessField = new JTextField(10); 
 guessField.setActionCommand("myTF");
 guessButton = new JButton("Guess");
 playAgainButton = new JButton("Play Again");
 
 //Add Action Listeners
 //action listener to wait for text to be entered into the number field
 guessField.addActionListener(this);
 //action listener that waits for user to press the guess button
 guessButton.addActionListener(this);
 //action listener that waits
 playAgainButton.addActionListener(this);
 
 //declare Labels
 userGuess = new JLabel("Enter your guess: ");
 //these labels start blank unless a guess is too high or too low
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
 
 
 //nested conditional statement that checks whether guess is too low or too high
 public void actionPerformed(ActionEvent ae) {
   //first checks to see if the guess button is pressed
 if(ae.getActionCommand().equals("Guess")) {
   //pulls text from guess field
    int guess = Integer.parseInt(guessField.getText());
    //checks if guess is too low
    if (guess < randomNum) {
     //if too low displays "too low"
      highLow.setText("Too low!");
     //if too low, displays what the last guess was 
      previousGuess.setText("Last guess was " + guess);
  }
    //
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