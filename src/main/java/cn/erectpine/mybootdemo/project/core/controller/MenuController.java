package cn.erectpine.mybootdemo.project.core.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.erectpine.mybootdemo.project.core.entity.Menu;
import cn.erectpine.mybootdemo.project.core.service.IMenuService;
import org.springframework.web.bind.annotation.RestController;
import cn.erectpine.mybootdemo.common.web.ResponseTemplate;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author wls
 * @since 2021-01-14
 */
@RestController
@RequestMapping("/core/menu")
public class MenuController {

    @Autowired
    IMenuService menuService;

    /**
     * 菜单权限表-分页列表
     */
    @PostMapping("/list")
    public ResponseTemplate pageMenu(@RequestBody Page<Menu> page, Menu menu) {
        return ResponseTemplate.success(menuService.pageMenu(page, menu));
    }

    /**
     * 根据id获取菜单权限表详情
     */
    @GetMapping("/{id}")
    public ResponseTemplate getMenuById(@PathVariable Long id) {
        return ResponseTemplate.success(menuService.getMenuById(id));
    }

    /**
     * 新增-菜单权限表
     */
    @PostMapping
    public ResponseTemplate insertMenu(@RequestBody Menu menu) {
        menuService.insertMenu(menu);
        return ResponseTemplate.success();
    }

    /**
     * 修改-菜单权限表
     */
    @PutMapping
    public ResponseTemplate updateMenu(@RequestBody Menu menu) {
        menuService.updateMenu(menu);
        return ResponseTemplate.success();
    }

    /**
     * 删除-菜单权限表
     */
    @DeleteMapping("/{id}")
    public ResponseTemplate deleteMenu(@PathVariable("id") Long id) {
        menuService.deleteMenu(id);
        return ResponseTemplate.success();
    }

}
