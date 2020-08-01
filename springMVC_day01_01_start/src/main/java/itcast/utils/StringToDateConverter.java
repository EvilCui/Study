package itcast.utils;

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDateConverter implements Converter<String,Date>{

    /**
     * String s 传入进来的字符串
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        //判断
        if(s == null ){
            throw new RuntimeException("请传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try{
            //把字符串转换日期
            return  df.parse(s);
        }catch (Exception e){
            throw new RuntimeException("错误");
        }
    }
}
