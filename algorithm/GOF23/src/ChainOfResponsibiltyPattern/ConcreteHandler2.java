package ChainOfResponsibiltyPattern;

public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String request) {
        if(request.equals("2")){
            System.out.println("2负责处理请求");
        }
        else{
            if(getNext() != null){
                getNext().handleRequest(request);
            }
            else{
                System.out.println("无人处理");
            }
        }
    }
}
