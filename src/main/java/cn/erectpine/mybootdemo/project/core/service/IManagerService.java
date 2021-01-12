package cn.erectpine.mybootdemo.project.core.service;

import cn.erectpine.mybootdemo.project.core.entity.Manager;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员信息表 服务类
 * </p>
 *
 * @author wls
 * @since 2021-01-12
 */
public interface IManagerService extends IService<Manager> {

    /**
     * 管理员信息表-列表
     *
     * @param page      分页参数
     * @param manager 查询条件
     * @return 分页列表
     */
    IPage<Manager> pageManager(Page<Manager> page, Manager manager);
    
    /**
     * 根据id获取管理员信息表详情
     *
     * @param id id
     * @return {@link Manager}
     */
    Manager getManagerById(Long id);

    /**
     * 新增-管理员信息表
     *
     * @param manager 管理员信息表
     */
    void insertManager(Manager manager);

    /**
     * 修改-管理员信息表
     *
     * @param manager 管理员信息表
     */
    void updateManager(Manager manager);

    /**
     * 删除-管理员信息表
     *
     * @param id id
     */
    void deleteManager(Long id);

}
