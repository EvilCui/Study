public class TestJoin {
    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("子线程1结束");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("子线程2结束");
            }
        });

        //启动
        thread1.start();
        thread2.start();
        System.out.println("等待所有子线程结束");

        //等待子线程执行完毕，返回
        thread1.join();
        thread2.join();
    }
}
