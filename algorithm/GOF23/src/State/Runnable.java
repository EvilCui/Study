package State;

public class Runnable extends ThreadState {
    public Runnable() {
        stateName = "就绪状态";
        System.out.println("当前线程处于就绪状态");
    }

    public void getCPU(ThreadContext hj){
        System.out.println("获得CPU时间--");
        if (stateName.equals("就绪状态")){
            hj.setState(new New());
        }else{
            System.out.println("当前线程不是就绪状态，无法调用RUNNABLE");
        }
    }
}
