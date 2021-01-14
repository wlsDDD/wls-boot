package cn.erectpine.mybootdemo.project.core.service.impl;

import cn.erectpine.mybootdemo.project.core.entity.User;
import cn.erectpine.mybootdemo.project.core.mapper.UserMapper;
import cn.erectpine.mybootdemo.project.core.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wls
 * @since 2021-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    
    @Autowired
    UserMapper userMapper;
    
    /**
     * 用户信息表-列表
     *
     * @param page 分页参数
     * @param user 查询条件
     * @return 分页列表
     */
    @Override
    public IPage<User> pageUser(Page<User> page, User user) {
        return page(page, Wrappers.lambdaQuery(user).orderByDesc(User::getCreateTime));
    }
    
    /**
     * 根据id获取用户信息表详情
     *
     * @param id id
     * @return {@link User}
     */
    @Override
    public User getUserById(Long id) {
        return getById(id);
    }
    
    /**
     * 新增-用户信息表
     *
     * @param user 用户信息表
     */
    @Override
    public void insertUser(User user) {
        save(user);
    }
    
    /**
     * 修改-用户信息表
     *
     * @param user 用户信息表
     */
    @Override
    public void updateUser(User user) {
        updateById(user);
    }
    
    /**
     * 删除-用户信息表
     *
     * @param id id
     */
    @Override
    public void deleteUser(Long id) {
        removeById(id);
    }
    
}
