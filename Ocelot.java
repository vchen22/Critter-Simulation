/**
 * Author: Vicki Chen
 * CSE8B Login: cs8bwahm
 * Date: 2/18/19
 * File: Ocelot.java
 * Source of Help: PA4 write up, Piazza, CSE8B Tutors
 *
 * This file contains the subclass Ocelot of Leopard.
 * It creates an Ocelot object with all its specified Ocelot attributes
 * */

import java.awt.*;

/**
 * This class contains methods that specifies an Ocelot's color,
 * attacking habits, and its buff behavior. 
 * */
public class Ocelot extends Leopard
{
    private static final String DP_NAME = "Oce";
    private static final int CONFID_5 = 5;
    private static final String LION_OBJ = "Lion";
    private static final String SLEEPY_LION = "nioL";
    private static final String FELINE_OBJ = "Fe";
    private static final String LEOPARD_OBJ = "Lpd";
    private static final int ADD_SUB_KILLS = 3;
    private static final String BUFF_LION = "LION";
    private static final String BUFF_LEOPARD = "lalalala~~~~";

    /**
     * Initializes an ocelot object with its display name
     * @param none
     * @return void
     * */
    public Ocelot()
    {
        this.displayName = DP_NAME;
    }
   
    /** 
     * Set color of Ocelot object
     * @param none
     * @return Color light gray
     * */
    @Override
    public Color getColor()
    {
        return Color.LIGHT_GRAY;
    }

    /** 
     * Generate attack based on confidence or randomize one
     * @param opponent Foe fighting against
     * @return type of attack that the Ocelot will perform 
     * */
    @Override
    public Attack getAttack(String opponent)
    {
        
        if (confidence > CONFID_5)
        {
            //sratch attack based on what opponent
            if (opponent.equals(LION_OBJ) || opponent.equals(SLEEPY_LION) ||
                    opponent.equals(FELINE_OBJ) || 
                    opponent.equals(LEOPARD_OBJ) || 
                    opponent.equals(BUFF_LION) || 
                    opponent.equals(BUFF_LEOPARD))

            {
                return Attack.SCRATCH;
            }
            else
            {
                return Attack.POUNCE;
            }
        }
        else
        {
            //call helper method to randomize an attack
            return generateAttack();
        }
                    
    }

    /**
     * Add 3 kills for every ocelot alive
     * @param s CritterState being buffed
     * @return void
     * */
    public void buffBehavior(CritterState s)
    {
        s.kills += ADD_SUB_KILLS;
    }

    /**
     * Subtract 3 kills for every ocelot alive
     * @param s CritterState being debuffed
     * @return void
     * */
    @Override
    public void debuff(CritterState s)
    {
        s.kills -= ADD_SUB_KILLS;
    }
    
    
}
