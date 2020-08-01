package State;

public class ThreadContext {
    private ThreadState state;

    //初始状态
    public ThreadContext() {
        state = new New();
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public void start(){
        ((New)state).start(this);
    }

    public void getCPU(){
        ((Runnable)state).getCPU(this);
    }

}
