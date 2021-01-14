package cn.erectpine.mybootdemo.project.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.erectpine.mybootdemo.project.core.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author wls
 * @since 2021-01-14
 */
public interface IUserService extends IService<User> {

    /**
     * 用户信息表-列表
     *
     * @param page      分页参数
     * @param user 查询条件
    * @return 分页列表
    */
    IPage<User> pageUser(Page<User> page, User user);

    /**
    * 根据id获取用户信息表详情
    *
    * @param id id
    * @return {@link User}
    */
    User getUserById(Long id);

    /**
    * 新增-用户信息表
    *
    * @param user 用户信息表
    */
    void insertUser(User user);

    /**
    * 修改-用户信息表
     *
     * @param user 用户信息表
     */
    void updateUser(User user);

    /**
     * 删除-用户信息表
     *
     * @param id id
     */
    void deleteUser(Long id);

}
