package ji_chu;


public class FixedCapacityStack {
    private String[] a;
    private int N ;
    public FixedCapacityStack(int cap){
        a = new String[cap];
    }
    public boolean isEmpty(){
        return N == 0 ;
    }
    public int Size(){
        return N;
    }
    public int Size;
    public void push(String item){
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }
}


