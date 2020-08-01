package dao;

import domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 在Mybatis中针对CRUD一共四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {

    /**
     * 查询所有用户
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update({"update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}"})
    void updateUser(User user);

    /**
     * 删除用户
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);

    /**
     * 根据ID查询用户
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer userId);

    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

    /**
     * 查询总用户数量
     */
    @Select("select count(*) from user")
    int findTotalUser();
}
