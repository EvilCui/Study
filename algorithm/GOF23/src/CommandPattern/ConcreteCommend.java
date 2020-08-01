package CommandPattern;

public class ConcreteCommend implements Command {
    private Receiver receiver;

    public ConcreteCommend() {
        receiver = new Receiver();
    }

    @Override
    public void executor() {
        receiver.action();
    }
}
