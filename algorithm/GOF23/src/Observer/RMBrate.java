package Observer;

/**
 * 具体目标
 */
public class RMBrate extends Rate {


    @Override
    void notifyObserver(int number) {
        System.out.println("目标改变");
        for(Company company:companies){
            company.response(number);
        }
    }
}
