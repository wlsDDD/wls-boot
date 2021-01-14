package cn.erectpine.mybootdemo.project.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.erectpine.mybootdemo.project.core.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author wls
 * @since 2021-01-14
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 菜单权限表-列表
     *
     * @param page      分页参数
     * @param menu 查询条件
    * @return 分页列表
    */
    IPage<Menu> pageMenu(Page<Menu> page, Menu menu);

    /**
    * 根据id获取菜单权限表详情
    *
    * @param id id
    * @return {@link Menu}
    */
    Menu getMenuById(Long id);

    /**
    * 新增-菜单权限表
    *
    * @param menu 菜单权限表
    */
    void insertMenu(Menu menu);

    /**
    * 修改-菜单权限表
     *
     * @param menu 菜单权限表
     */
    void updateMenu(Menu menu);

    /**
     * 删除-菜单权限表
     *
     * @param id id
     */
    void deleteMenu(Long id);

}
