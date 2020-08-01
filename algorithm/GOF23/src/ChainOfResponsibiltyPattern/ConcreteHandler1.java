package ChainOfResponsibiltyPattern;

public class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(String request) {
        if(request.equals("1")){
            System.out.println("1负责处理请求");
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
