package Memento;

/**
 * 备忘录模式
 */
public class Originator {
    private int HP;
    private int atk;
    private int def;

    public void init(){
        this.HP = 100;
        this.atk = 100;
        this.def = 100;
    }



    public Mementor save(){
        return new Mementor(HP,atk,def);
    }

    public void recovery(Mementor mementor){
        this.HP = mementor.getHP();
        this.atk = mementor.getAtk();
        this.def = mementor.getDef();
    }

    public void show(){
        System.out.println(HP+" "+ atk +" "+def);
    }

    public void change(){
        this.HP = 0;
        this.atk = 0;
        this.def = 0;
    }
}
