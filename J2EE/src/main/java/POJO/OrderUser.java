package POJO;
import java.util.Date;

/**
 * 一对一表，继承原表的结构，添加另一张表的属性
 */
public class OrderUser extends Order {
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date created;
    private Date updated;
}
