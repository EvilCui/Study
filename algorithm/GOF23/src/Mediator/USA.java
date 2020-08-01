package Mediator;

public class USA extends Country {
    public USA(UnitedNations mediator) {
        super(mediator);
    }

    public void Declare(String message) {
        mediator.Declare(message, this);
    }

    public void GetMessage(String message){
        System.out.println("美国获得对方消息"+message);
    }
}
