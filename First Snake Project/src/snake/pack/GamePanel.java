package snake.pack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {



    // for storing snake position

    private  int[] snakexlength = new int[750]; // it can store snake x position

    private  int[] snakeylength = new int[750]; // it can store snake y position



    // then we declare our snake length

    private int lengthOfSnake = 3;  // initial state par its snake lenght is 3 mean starting time its length is 3



    // We create our fruit position

    // THis is our X position  --> left side start from 25 to end right side 850

    private int[] xPos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};


    // This is our Y position --> Up side start from 75 to down side 625

    private int[] yPos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};


     // Then we create a random method because we set position our fruit or enemy randomly

    private Random random = new Random();

    private int enemyX, enemyY; // so now we need to set --> so we set this in the constructor below




    // Now then we draw our snake go to our paint method below



    // Draw the snake

    // Now we want the direction so what we do

    private boolean left = false; // because first time its direction is in right side

    private  boolean right = true;

    private boolean up = false;

    private boolean down = false;

    // One time its take one direction that why all directions are false only right is true because our starting posiion is right side

    // then we need to store the snake body position we declare that up


    // then we check the snake moves mean in which time snake position in which direction

    private int move = 0; // initial stage snake moves has zero


    // then we declare a variable for storing score

    private int score =0;


    // WE create a Game oVer variable

    private  boolean gameOver = false; // After that we draw our Game over so we go to paint method down




    // Add title in our first rectangle with the formof image

    private ImageIcon snaketitle = new ImageIcon(getClass().getResource("snaketitle.jpg"));

    // then move down for drawing our image



    // if head is left side

    private ImageIcon leftmouth = new ImageIcon(getClass().getResource("leftmouth.png"));

    // If head is right side
    private ImageIcon rightmouth = new ImageIcon(getClass().getResource("rightmouth.png"));

    // if head is up side

    private ImageIcon upmouth = new ImageIcon(getClass().getResource("upmouth.png"));

    // if head is down side

    private ImageIcon downmouth = new ImageIcon(getClass().getResource("downmouth.png"));


    // then snake image icon

    private ImageIcon snakeimage = new ImageIcon(getClass().getResource("snakeimage.png"));


    // then enemy image icon

    private ImageIcon enemy = new ImageIcon(getClass().getResource("enemy.png")); // then after that we draw this enemy in our paint method in down



    // we create a timer variable for moving our snake in every miliseconds


    private Timer timer;

    // then another is delay mean how much time to take a delay or move

    private int delay = 100; // every 100 miliseconds it can move


    // then we implement our timer variable in our constructor




    // We create a constructor

    GamePanel(){

        // Add key Listener

        addKeyListener(this);

        // then we call another two methods because its working on Jpanel

        setFocusable(true);

        setFocusTraversalKeysEnabled(true);


        timer = new Timer(delay, this);

        // then start our timer class

        timer.start(); //every 100 miliseoonds it will call actionListener



        // For setting enmey position we create a variable


        newEnemy();


    }


    // This is our enemy method

    private void newEnemy() {

        // set the  X position randomly

        enemyX = xPos[random.nextInt(34)]; // 32 is our X array length


        // Set the Y position randomly

        enemyY = yPos[random.nextInt(23)];  // 23 is our Y array length



        // then we give one conditon enemy not created in a snake body

        for(int i = lengthOfSnake-1; i>=0; i--){

            // If snake any part position is equal to enemy part position then what we do

            if(snakexlength[i] == enemyX && snakeylength[i]==enemyY){


                // if this cond true then give new enemy position

                newEnemy();
            }
        }

    }

    // Then completing our enemy position then we do give image of enemy in up


    // then we write a paint method

    @Override
    public void paint(Graphics g) {
        super.paint(g); // To chnage body of generated methods, choose tools \ tempelate


        // then we create our graphics

        // firstly we create  border

        g.setColor(Color.white); // this is border color


        // then after we draw a rectangle in white color

        g.drawRect(24, 10, 851, 55); // this is top rect


        // then after that we draw a game border

        g.drawRect(24, 74,851,576);


        // then we add Title in our first rectangle then go to top


        // then draw snaketitle

        snaketitle.paintIcon(this, g, 25, 11);  // added in my frame


        // set the color of this rect

        g.setColor(Color.black);


        // then we created our black rectangle jha snake run karega

        g.fillRect(25, 75, 850, 575);  // By default its showing white then set color up of ths line


        // then draw the snake up


        // then gvies the snake  directions moves positions


        if(move==0){ // mean snake has its own intitial position


            // this is our x position

            // now tell him in which side our head is

            // our snake length is 3 is our move is 0
            snakexlength[0] = 100; // then our head store 0th position
            snakexlength[1] = 75; // then 1th position
            snakexlength[2] = 50; // then 2th position


            // Now we give Y position

            snakeylength[0] = 100;
            snakeylength[1] = 100;
            snakeylength[2] = 100;

            // After moves assigning we increase our moves

//            move++; // we comment this because firstly we stop in our initial positon




        }


        // then after that we draw the snake we assing the icon in up


        // if our snake head is left side

        if(left){

            leftmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
        }

        // if our snake head is right side

        if(right){

            rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

        }


        // if our snake head is down side

        if(down){

            downmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

        }

        // if our snake head is up side

        if(up){

            upmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

        }


        // if runs this code we get only snake head not body


        // then we create a snake body


         // we create a loop for making snake body

        // we starts from 1 because 0 position we have head so we create a body


        for(int i = 1;  i<lengthOfSnake; i++){

            snakeimage.paintIcon(this, g, snakexlength[i], snakeylength[i]);
        }




        // Now we have a snake our next task is to move the snake


        // We move our snake in every miliseconds so we create a timer variable in up



        // then we call our enemy --> my enemy is up

        enemy.paintIcon(this, g, enemyX,enemyY); //  If i  run Now our enemy is created in board in any random position

     // Then our next work is snake eating our enemy so lets do

        // So what i want if snake eating our enemy our enemy goes and our snake size increasing by 1

        // SO if our snake head is equal our enemy than change our enemy position

        // So we go our Action Listener method down



        // Draw over Game Over

        if(gameOver==true){ // if we hit the game over section then do this


            // set the color of Game Over
            g.setColor(Color.red);

            // set the Font style of Game over

            g.setFont(new Font("Arial", Font.BOLD, 50));

            // Then print that written statement or string

            g.drawString("Game Over", 300, 300);


            // Another clicking statement set Font mean restart the game as this

            // set the Font style of restart statment

            g.setFont(new Font("Arial", Font.PLAIN, 20));

            // Then print that written statement or string

            g.drawString("PRESS SPACE TO RESTART", 320, 350);


        }// If i run this code what happening there if my game is over or I click the space it can't restart

        // So what our work is After game over if i click the space button our game is restart

        // So we go in our Key Listener for checkng this in below



        // There is Printed score or length of snake

        g.setColor(Color.red);

        g.setFont(new Font("Arial", Font.PLAIN, 14));

        g.drawString("Score : "+score, 750, 30);

        g.drawString("Length : "+lengthOfSnake, 750, 50 );




        // then we call this methods

        g.dispose();





    }

    /// This is our Action Listener

    @Override
    public void actionPerformed(ActionEvent e) {


        // we giving our snake body position in down

        for(int i = lengthOfSnake-1; i>0; i--){

            snakexlength[i] = snakexlength[i-1];
            snakeylength[i] = snakeylength[i-1];
        }

        // Now if i run again then our snake goes to right outside but we want it will go right outside and get
        // it back in front left side so we give conditons in our action listener in down



        // In this ActionListner what we do we chnage our snake head position

        // then we write conditons

        // if snake head direction is left

        if(left){

            snakexlength[0] = snakexlength[0] - 25; // it will move left

        }

        // if snake head direction is right

        if(right){

            snakexlength[0] = snakexlength[0] + 25; // it will move right

        }



        // if snake head direction is up

        if(up){

            snakeylength[0] = snakeylength[0] - 25; // it will move up

        }

        // if snake head direction is down

        if(down){

            snakeylength[0] = snakeylength[0] + 25; // it will move down

        }


        // this is condition for our snake is goes rightoutside then it come back in front of left side

        if(snakexlength[0] > 850){ // mean if my snake touch rigth side border then it will directly goes to left side border


            snakexlength[0] = 25;
        }

        if(snakexlength[0] < 25){ // if leftside border touch our snake then it come back right side border

            snakexlength[0] = 850;
        }


        // this is condition for our snake is goes up then it come back in down side

        if(snakeylength[0] > 625){ // mean if my snake touch up side border then it will directly get back to down side border


            snakeylength[0] = 75;
        }

        if(snakeylength[0] < 75){ // if downside border touch our snake then it come back upside border

            snakeylength[0] = 625;
        }


        // If now we run our code it can't move in any direction because now our key doesn't work

        // so we use Key listener --> we implement a key listener in top



        // write a method for snake eating enemy for chainging position

        collidesWithEnemy();


        // then after that if our snake is collide our body then game over

        collidesWithBody();



        // we call this because this function use paint method in our ActionListener

        repaint();


        // Now only moving a head not a full body so we change body postiton then do up in action listener after

    }






    // This is our collide with Enenmy method
    private void collidesWithEnemy() {

        // what this method our snake is collide with enemy or not


        if(snakexlength[0]==enemyX && snakeylength[0]==enemyY){ // if our snake head poisiton in our enemyX and enemy Y then change our enmey position


            newEnemy(); // we get the new position of enemy

            lengthOfSnake++; // then our snake length is increasing

            // then also increase a score firstly we declare a variable score in up

            score++;





        }

    }


    // This is collide With Body mehthod


    private void collidesWithBody() {

        for(int i = lengthOfSnake-1; i>0; i--){


            // If our snake head position is equal to our snake length then our game over

            if(snakexlength[i]==snakexlength[0] && snakeylength[i] == snakeylength[0]){  // If this cond true

                // then stop the timer

                timer.stop();

                // then game over --> we create this game over variable below the score variable

                gameOver = true;

            }
        }

    }


    // This is our Key Listeners methods

    @Override
    public void keyTyped(KeyEvent e) {

    }



    // our work is in Key pressed becuase if we pressed key then move in certain direction

    @Override
    public void keyPressed(KeyEvent e) {


        // If our game is over then restart it with the space key so we do this

       if(e.getKeyCode() == KeyEvent.VK_SPACE){ // if we press space key

           restart(); // then restart our game --> then we create our restart method


       }

        // if we pressed left key what we want

        if(e.getKeyCode() == KeyEvent.VK_LEFT  && (!right)){ // its mean if our snake moves left it can't move right

            left = true;
            right = false;
            up = false;
            down = false;

            move++;
        }

        // if we pressed right key what we want

        if(e.getKeyCode() == KeyEvent.VK_RIGHT  && (!left)){ // its mean if our snake moves right it can't move left

            left = false;
            right = true;
            up = false;
            down = false;

            move++;
        }


        // if we pressed up key what we want

        if(e.getKeyCode() == KeyEvent.VK_UP  && (!down)){ // its mean if our snake moves up it can't move down

            left = false;
            right = false;
            up = true;
            down = false;

            move++;
        }


        // if we pressed down key what we want

        if(e.getKeyCode() == KeyEvent.VK_DOWN  && (!up)){  // its mean if our snake moves down it can't move up

            left = false;
            right = false;
            up = false;
            down = true;

            move++;
        }

        // If I run now it can't run because we dont add key listener so we add key listener in our constructor in up

 // After that it will runs it moves with the help of keys but we give a conditon if it moves any side it can't move

        // directly right side we give condition it can't move opposite side --> So we give condiiton in our key listner


        // After it moves fine but its moves automaically but i want it can stop its our initial stage first time then if

        // press the key then it start other wise it stop in a starting position

        // so what we do we increase a move in a postion case so we can't move there go to up and delete there

        // What we want if we press a key then increase a move


        // SO now our snake is complete mean drawing, directions, positions, or something snake related

        // Now we create our fruit in up


    }



    // this is our restart method of our snake game
    private void restart() {

        // then close the gameOVer

        gameOver = false;

        // then again move 0

        move = 0;

        // Again score 0

        score = 0;


        // Then again lengthof snake is 0

        lengthOfSnake = 3;



        left = false;

        right = true;

        up = false;

        down = false;

        timer.start();

        // Then repaint it

        repaint();

        // Now if i run this code our whole game is Completed only left score or length part so we do this

        // So we draw the snake score and length in a game over method is up



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}




