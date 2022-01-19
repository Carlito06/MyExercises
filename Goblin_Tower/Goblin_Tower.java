import java.util.*;

public class Goblin_Tower
{
    static int steps = 0;
    static int level = 1;
    static String input;
    static hero player;
    static goblin enemy;

    public static void main (String args[])
    {


        System.out.println("Would you like to play Goblin Tower? (Yes/No)");
        Scanner sc = new Scanner (System.in);

        input = sc.nextLine();
        input = input.toLowerCase();

        if (input.equals("yes"))
        {
            player = new hero(); 
            double defense = player.getDefensePower(); // player defense resets every battle

            while(player.getCurrentHealth()>0)
            {
                System.out.println("Would you like to take a STEP now? Or would you like to see STATS (STEP/STATS/POTION)");
                input = sc.nextLine();
                input = input.toLowerCase();

                if (input.equals("step"))
                {
                    steps++;

                    if (steps%10 == 0)
                    {
                        level++;
                        System.out.println("Would you like to buy a potion?(YES/NO)");


                        input = sc.nextLine();
                        input = input.toLowerCase();

                        while (input.equals("yes"))
                        {
                            if (player.getGold()<=6)
                            {
                                System.out.println("NOT ENOUGH GOLD!");
                                input ="";
                                break;
                            }

                            if (input.equals("yes") && player.getPotions()<5) // if player has less than 5 potions you can buy more
                            {
                                player.buyPotion();

                                System.out.println("Would you like to another?(YES/NO)");

                                input = sc.nextLine();
                                input = input.toLowerCase();
                            }

                            else
                            {
                                System.out.println("MAXIMUM AMOUNT OF POTIONS HELD");
                                System.out.println("PLAYER EXITS THE SHOP!");
                            }
                        }


                        input = "";

                    }

                    if (randomEncounter())
                    {
                        System.out.println("RANDOM ENCOUNTER!");
                        System.out.println("");



                        enemy = new goblin(); 
                        enemy.showStats();

                        player.showStats();




                        while (enemy.getCurrentHealth() > 0 || player.getCurrentHealth() <= 0)
                        {
                            System.out.println("");

                            System.out.println("Would you like to ATTACK, see your STATS, or drink a POTION (ATTACK/STATS/POTION/)");

                            input = sc.nextLine();
                            input = input.toLowerCase();

                            if (input.equals("attack"))
                            {
                                if (enemy.getDefensePower() > 0) // if there is some defense power, hit that first
                                {
                                 System.out.println("You hit through the Goblin Defense");
                                 System.out.println("");


                                 enemy.setDefensePower(enemy.getDefensePower()-player.getAttackPower());

                                    if (enemy.getDefensePower() < 0) // if goblin defense power is negative after attacking transfer negative number to current health
                                    {
                                       System.out.println("Some damage peirced through his defense!");
                                       System.out.println("");


                                        enemy.setCurrentHealth(enemy.getCurrentHealth()+enemy.getDefensePower());
                                        enemy.setDefensePower(0);
                                    }
                                }

                                    else // else if theres no defense power hit the goblin directly
                                    {
                                    System.out.println("You hit the Goblin directly!");
                                    enemy.setCurrentHealth(enemy.getCurrentHealth()-player.getAttackPower());

                                    }

                                    if (enemy.getCurrentHealth() <= 0)
                                    {
                                        System.out.println("THE GOBLIN IS SLAIN!");
                                        System.out.println("YOU GAIN +2 GOLD!");
                                        System.out.println("");
                                        player.setGold(player.getGold()+2);

                                        player.setDefensePower(defense);
                                    }
                            
                                    else  // if the goblin is not dead, hit the player back
                                    {
                                        System.out.println("The goblin hits you back!");
                                        System.out.println("");

                                        if (player.getDefensePower() > 0) // if there is some defense power, hit that first
                                        {
                                            System.out.println("The goblin hits through your Defense!");
                                            System.out.println("");

                                            player.setDefensePower(player.getDefensePower()-enemy.getAttackPower());

                                            if (player.getDefensePower() < 0) // if player defense power is negative after attacking transfer negative number to current health
                                            {
                                                System.out.println("Some damage peirced through your defense!");
                                                System.out.println("");
    
    
                                                player.setCurrentHealth(player.getCurrentHealth()+player.getDefensePower());
                                                player.setDefensePower(0);
                                            }

                                        }

                                        else // else if theres no defense power hit the player directly
                                        {
                                            System.out.println("The Goblin hit you directly!");
                                            player.setCurrentHealth(player.getCurrentHealth()-enemy.getAttackPower());
                                            System.out.println("");

                                        }

                                        if (player.getCurrentHealth()<=0) // break out of loop if player dies
                                        {
                                            break; 
                                        }

                                        System.out.println("Player Defense: "+player.getDefensePower());
                                        System.out.println("Player Health: "+player.getCurrentHealth()+"/"+player.getMaxHealth());

                                        System.out.println("");

                                        System.out.println("Goblin Defense: "+enemy.getDefensePower());
                                        System.out.println("Goblin Health: "+enemy.getCurrentHealth()+"/"+enemy.getMaxHealth());

                                    }
                            }

                            else if (input.equals("potion"))
                            {
                                player.drinkPotion();
                            }

                            else if (input.equals("stats"))
                            {
                                showStats(player);
                                enemy.showStats();
                            }
                        }

    
                    }
                }

                else if (input.equals("potion"))
                {
                     player.drinkPotion();
                }

                else if (input.equals("stats"))
                {
                    showStats(player);
                }

                input = "";

                if (player.getCurrentHealth()<=0)
                {
                    System.out.println("YOU DIED!");
                    System.out.println("Would you like to restart with the same amount of gold? (Yes/No)");

                    input = sc.nextLine();
                    input = input.toLowerCase();

                    if (input.equals("yes"))
                    {
                        steps =0;
                        level=1;
                        player = new hero(player.getGold());
                        defense = player.getDefensePower();
                    }
                    
                    else{break;}

                }


            }

            System.out.println("GAME OVER!");
            System.out.println("");

            System.out.println("FINAL SCORE");
            System.out.println("STEPS TAKEN: "+ steps);
            System.out.println("LEVELS: "+ level);

        }


        sc.close();
    }

    private static void showStats(hero player)
    {
        player.showStats();
        System.out.println("STEPS TAKE: "+ steps);
        System.out.println("CURRENT LEVEL: "+ level);

    }

    private static Boolean randomEncounter() // random number gernator (coin flip) for goblin encounter
    {
        int x = (int) (Math.random()*2);
        if (x == 1)
        {return true;}

        return false;
    }
}