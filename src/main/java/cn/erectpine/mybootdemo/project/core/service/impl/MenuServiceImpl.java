package cn.erectpine.mybootdemo.project.core.service.impl;

import cn.erectpine.mybootdemo.common.web.BaseEntity;
import cn.erectpine.mybootdemo.project.core.entity.Menu;
import cn.erectpine.mybootdemo.project.core.mapper.MenuMapper;
import cn.erectpine.mybootdemo.project.core.service.IMenuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author wls
 * @since 2021-01-14
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    
    @Autowired
    MenuMapper menuMapper;
    
    /**
     * 菜单权限表-列表
     *
     * @param page 分页参数
     * @param menu 查询条件
     * @return 分页列表
     */
    @Override
    public IPage<Menu> pageMenu(Page<Menu> page, Menu menu) {
        return page(page, Wrappers.lambdaQuery(menu).orderByDesc(Menu::getCreateTime).select(Menu::getMenuName, BaseEntity::getCreateTime));
    }
    
    /**
     * 根据id获取菜单权限表详情
     *
     * @param id id
     * @return {@link Menu}
     */
    @Override
    public Menu getMenuById(Long id) {
        return getById(id);
    }
    
    /**
     * 新增-菜单权限表
     *
     * @param menu 菜单权限表
     */
    @Override
    public void insertMenu(Menu menu) {
        save(menu);
    }
    
    /**
     * 修改-菜单权限表
     *
     * @param menu 菜单权限表
     */
    @Override
    public void updateMenu(Menu menu) {
        updateById(menu);
    }
    
    /**
     * 删除-菜单权限表
     *
     * @param id id
     */
    @Override
    public void deleteMenu(Long id) {
        removeById(id);
    }
    
}
