package Mediator;

public class Iraq extends Country {
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void Declare(String message) {
        mediator.Declare(message, this);
    }

    public void GetMessage(String message){
        System.out.println("伊拉克获得对方消息"+message);
    }
}
