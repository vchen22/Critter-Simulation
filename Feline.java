/**
 * Author: Vicki Chen
 * CSE8B Login: cs8bwahm
 * Date: 2/17/19
 * File: Feline.java
 * Source of Help: PA4 write up, Piazza, CSE8B Tutors
 * 
 * This file contains the subclass Feline of Critter and the implementation
 * of Movable
 * It creates a Feline object with all its specified Feline attributes
 * */

import java.util.Random;
import java.awt.*;

/**
 * This class contains methods that specifies a Feline's
 * movement, eating and attacking habits, and its buff behavior. moveCount is
 * to keep track of when to change direction, eatCount determines when it 
 * should eat, and currDir is the direction the Feline is going
 * */
public class Feline extends Critter implements Movable {

    //counter for the getMove method before random direction
    private int moveCount;
    private int eatCount; //counter for eating
    private Direction currDir; //current direction
    private static final int START_EATCOUNT = 1;
    private static final int CHANGE_DIR = 5;
    private static final int NUM_DIR = 4;
    private static final int EAST_NUM = 2;
    private static final int EAT = 5;
    private static final String DP_NAME = "Fe";

    /**
     * Intializes a Feline object with its display name, eating counter, 
     * move counter, and direction
     * @param none
     * @return void
     * */
    public Feline() {
        //TODO 
        super(DP_NAME);
        eatCount = START_EATCOUNT;
        moveCount = CHANGE_DIR;
        currDir = Direction.CENTER;

    }

    /** 
     * set all Felines to sleep as buff behavior
     * @param s The state of a Feline oject being buffef
     * @return void
     * */
    @Override
    public void buffBehavior(CritterState s){
        //TODO
        s.setAsleep(true);
    }

    /** 
     * Reset the buff bahvaior by waking up the Feline
     * @param s The state of a Feline object being debuffed
     * @return void
     * */
    @Override
    public void debuff(CritterState s){
        //TODO

        s.setAsleep(false);
    }

    /**
     * Change direction every 5 moves
     * @param none
     * @return currDir The direction the Feline will go
     * */
    @Override
    public Direction getMove() {
        //TODO:

        //change direction when moveCount is 5
        if (moveCount == CHANGE_DIR)
        {
            //randomize direction based on what num is generated
            Random randDir = new Random();
            int dir = randDir.nextInt(NUM_DIR);
            
            if (dir == 0)
            {
                currDir = Direction.NORTH;
               
            }
            else if (dir == 1)
            {
                currDir = Direction.SOUTH;
             
            }
            else if (dir == EAST_NUM)
            {
                currDir = Direction.EAST;
            }
            else
            {
                currDir = Direction.WEST;
                
            }          

            //reset moveCount once direction changed
            moveCount = 0;        
        }

        moveCount++;

        return currDir;
    }

    /**
     * Eat every 5th ecnounter of food
     * @param none
     * @return boolean true or false if Feline will eat
     * */
    @Override
    public boolean eat() {
        //TODO
        
        if (eatCount == EAT)
        {
            return true;
        }
        else
        {
            eatCount++;
        }

        return false;
    }

    /**
     * Always pounce as attack
     * @param opponent Foe fighting against
     * @return attack performed by Feline
     * */
    public Attack getAttack(String opponent){
        //TODO

        return Attack.POUNCE;
    }
 
}
