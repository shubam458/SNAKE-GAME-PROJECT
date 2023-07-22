package snake.pack;

import javax.swing.*;
import java.awt.*;

public class Snakegame
{


    public static void main(String[] args) {

        // This is a Frame title of our Project

        JFrame Frame = new JFrame("Snake Game");

        // then we can set the frame height , widdth , length , breadth

        Frame.setBounds(10,10,905,700);

        // then we want anyone doesn't change our frame size so we set

        Frame.setResizable(false); // no one change the size of our frame its fixed


        // By Default our Frame is invisible so we can visible it by this operation

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // then we create an object for Game Panel

        GamePanel panel = new GamePanel();


        // then we set the background of our panel

        panel.setBackground(Color.DARK_GRAY);



        // then add our panel in our frame

        Frame.add(panel); // now we go our GamePanel class and extends Jpanel


        // This set method for visible our frame

        Frame.setVisible(true);


        // Our main method code is done now we go to our game panel and code it








    }



}

