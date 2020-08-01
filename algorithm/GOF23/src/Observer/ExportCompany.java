package Observer;

/**
 * 具体观察者
 */
public class ExportCompany implements Company{
    @Override
    public void response(int number) {
        if(number>0){
            System.out.println("汇率上升"+number+"个基点，出口公司利润下降");
        }else{
            System.out.println("汇率下降"+number+"个基点，出口公司利润上升");
        }
    }
}
