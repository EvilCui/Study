package Iterator;

import java.util.List;

public class ConcreteIterator implements newIterator {
    private List<Object> list = null;
    private int index = -1;
    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        Object object = list.get(index);
        return object;
    }

    @Override
    public Object next() {
        Object object = null;
        if(this.hasnext()){
            object = list.get(++index);
        }
        return object;
    }

    @Override
    public boolean hasnext() {
        if(index <list.size()-1){
            return true;
        }else{
            return false;
        }
    }
}
