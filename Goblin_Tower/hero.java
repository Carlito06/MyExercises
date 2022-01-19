import java.lang.Math;

public class hero {

   private double maxHealth;
   private double currentHealth;
   private double attackPower;
   private double defensePower;
   private int [] potions;
   private int gold;

   public hero() //constructor
   {
    setMaxHealth((int) (Math.random()*11 + 20));
    setCurrentHealth(maxHealth);
    setDefensePower((int) (Math.random()*5 + 1));
    setAttackPower((int) (Math.random()*3 + 1));
    setPotions(potions);

    this.gold = 0;
   }

   public hero(int gold) //constructor if player wants to play again (gold = previous runs gold)
   {
    setMaxHealth((int) (Math.random()*11 + 20));
    setCurrentHealth(maxHealth);
    setDefensePower((int) (Math.random()*5 + 1));
    setAttackPower((int) (Math.random()*3 + 1));
    setPotions(potions);
    

    this.gold = gold;
   }

    public double getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public double getAttackPower() {
        return attackPower;
    }
    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getDefensePower() {
        return defensePower;
    }
    public void setDefensePower(double defensePower) {
        this.defensePower = defensePower;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

public int getGold()
{
    return gold;
}

public void setPotions(int [] potions)
{
    this.potions = new int[5];

    for (int i = 0; i<this.potions.length;i++)
    {
        this.potions[i] = 2;
    }
}

public int getPotions()
{
    int potionsCounter = 0;

    for (int i =0; i < this.potions.length;i++)
    {
        if (potions[i]==2)
        {
            potionsCounter++;
        }
    }

    return potionsCounter;

}

public void showStats()
{

    System.out.println("PLAYER STATS");
    System.out.println("HEALTH: "+getCurrentHealth()+"/"+getMaxHealth());
    System.out.println("ATTACK POWER: "+getAttackPower());
    System.out.println("DEFENSE POWER: "+getDefensePower());
    System.out.println("POTIONS: "+ getPotions());
    System.out.println("GOLD: "+ getGold());
    System.out.println("");


}

public void drinkPotion()
{
    if (getCurrentHealth()<getMaxHealth())
    {
        for (int i = 0; i < this.potions.length;i++)
        {
         if (this.potions[i] == 2)
            {
                setCurrentHealth(this.currentHealth+=this.potions[i]);
                this.potions[i] = 0;
                System.out.println("You drank a potion!");
                System.out.println("HEALTH: "+this.currentHealth+"/"+this.maxHealth);
                break;

               

                
            }

            if (i == this.potions.length-1)
            {
                System.out.println("You have 0 potions");

            }


        }
    }

    else{
        System.out.println("HEALTH AT MAXIMUM (CAN NOT DRINK!)");

    }

    System.out.println("");


}

public void buyPotion()
{
    if (this.gold >= 6) // if you have enough gold
    {
        

        for (int i = 0; i < this.potions.length;i++)
        {

         if (this.potions[i] == 0)
            {
                this.potions[i] = 2;

                System.out.println("You bought a potion!");
                this.gold-=6;
                break;
            }

            if (i == this.potions.length-1)
            {
                System.out.println("MAX AMOUNT OF POTIONS! CAN NOT BUY MORE");
                break;
            }
        }
    }


    System.out.println("");

    
}






    
}
