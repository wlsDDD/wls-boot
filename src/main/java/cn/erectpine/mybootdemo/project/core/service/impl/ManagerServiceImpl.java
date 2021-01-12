package cn.erectpine.mybootdemo.project.core.service.impl;

import cn.erectpine.mybootdemo.project.core.entity.Manager;
import cn.erectpine.mybootdemo.project.core.mapper.ManagerMapper;
import cn.erectpine.mybootdemo.project.core.service.IManagerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员信息表 服务实现类
 * </p>
 *
 * @author wls
 * @since 2021-01-12
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Autowired
    ManagerMapper managerMapper;

    /**
     * 管理员信息表-列表
     *
     * @param page  分页参数
     * @param manager 查询条件
     * @return 分页列表
     */
    @Override
    public IPage<Manager> pageManager(Page<Manager> page, Manager manager) {
        return page(page, Wrappers.lambdaQuery(manager).orderByDesc(Manager::getCreateTime));
    }
    
    /**
     * 根据id获取管理员信息表详情
     *
     * @param id id
     * @return {@link Manager}
     */
    @Override
    public Manager getManagerById(Long id) {
        return getById(id);
    }

    /**
     * 新增-管理员信息表
     *
     * @param manager 管理员信息表
     */
    @Override
    public void insertManager(Manager manager) {
        save(manager);
    }

    /**
     * 修改-管理员信息表
     *
     * @param manager 管理员信息表
     */
    @Override
    public void updateManager(Manager manager) {
        updateById(manager);
    }

    /**
     * 删除-管理员信息表
     *
     * @param id id
     */
    @Override
    public void deleteManager(Long id) {
        removeById(id);
    }

}
