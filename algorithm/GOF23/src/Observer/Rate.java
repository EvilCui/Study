package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标
 */
public abstract class Rate {
    protected List<Company> companies = new ArrayList<>();

    void add(Company company){
        companies.add(company);
    };

    void remove(Company company){
        companies.remove(company);
    };

    abstract void notifyObserver(int number);
}
