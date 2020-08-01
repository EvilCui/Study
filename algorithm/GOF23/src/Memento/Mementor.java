package Memento;

public class Mementor {
    private int HP;
    private int atk;
    private int def;

    public Mementor(int HP, int atk, int def) {
        this.HP = HP;
        this.atk = atk;
        this.def = def;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
