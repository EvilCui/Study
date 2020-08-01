import java.util.Iterator;
import java.util.Scanner;

public class Input {
    int[] data;

    //输入数据
    public int[] readFile(Scanner sc) {

        Bag oldData = new Bag();    //从文件中按行读取的原始数据
        while (sc.hasNextLine()) {
            String olddata = sc.nextLine();
            oldData.add(olddata);
        }
        Iterator<String> iterator = oldData.iterator();
        String temp[];
        int v, w;
        int N =0;
        while (iterator.hasNext()) {
            temp = iterator.next().split(",");
            v = Integer.parseInt(temp[0]);
            data[N++] = v;
            w = Integer.parseInt(temp[1]);
            data[N++] = w;
        }
        return data;//存储所有路径的数组 有重复
    }
}
