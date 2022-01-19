import java.lang.Math;

public class goblin {
    private double maxHealth;
    private double currentHealth;
    private double defensePower;
    private double attackPower;

    public goblin()
    {

    setMaxHealth((int) (Math.random()*6 + 5));
    setCurrentHealth(maxHealth);
    setDefensePower((int) (Math.random()*2 + 1));
    setAttackPower((int) (Math.random()*2 + 2));

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
public void setAttackPower(int attackPower) {
    this.attackPower = attackPower;
}

public double getDefensePower() {
    return defensePower;
}
public void setDefensePower(double defensePower) {
    this.defensePower = defensePower;
}

public void showStats()
{
    System.out.println("GOBLIN STATS");

    System.out.println("HEALTH: "+getCurrentHealth()+"/"+getMaxHealth());
    System.out.println("ATTACK POWER: "+getAttackPower());
    System.out.println("DEFENSE POWER: "+getDefensePower());    
    System.out.println("");


}

}
