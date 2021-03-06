package collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Department {
    private String name;
    private String []empName;//这里int的数组也可以注入成功
    private List<Employee> empList;
    private Map<String,Employee> empMap;
    private Properties pp;
    private Set<Employee> empSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEmpName() {
        return empName;
    }

    public void setEmpName(String[] empName) {
        this.empName = empName;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public Map<String, Employee> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<String, Employee> empMap) {
        this.empMap = empMap;
    }

    public Properties getPp() {
        return pp;
    }

    public void setPp(Properties pp) {
        this.pp = pp;
    }

    public Set<Employee> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Employee> empSet) {
        this.empSet = empSet;
    }
}
