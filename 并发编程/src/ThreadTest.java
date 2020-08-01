import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static class MyThread extends java.lang.Thread{
        @Override
        public void run() {
            System.out.println("我是子线程");;
        }
    }

    public static class RunableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("我是子线程");
        }
    }

    public static class CallerTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "hi";
        }
    }

   // public static void main(String[] args) {
        //创建线程
        //MyThread t = new MyThread();
        //启动线程
        //t.start();

     //   RunableTask r = new RunableTask();
    //    new Thread(r).start();
     //   new Thread(r).start();
    //}

    public static void main(String[] args) throws InterruptedException {
        //创建异步任务
        FutureTask<String> t = new FutureTask<String>(new CallerTask());
        //启动线程
        new Thread(t).start();
        try {
            String res = t.get();
            System.out.println(res);
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }


}
