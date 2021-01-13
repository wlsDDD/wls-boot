package cn.erectpine.mybootdemo.project.core.controller;

import cn.erectpine.mybootdemo.common.annotation.Log;
import cn.erectpine.mybootdemo.common.enums.BusinessType;
import cn.erectpine.mybootdemo.common.web.ResponseTemplate;
import cn.erectpine.mybootdemo.project.core.entity.Manager;
import cn.erectpine.mybootdemo.project.core.service.IManagerService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员信息表 前端控制器
 * </p>
 *
 * @author wls
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/core/manager")
public class ManagerController {
    
    @Autowired
    IManagerService managerService;
    
    /**
     * 管理员信息表-分页列表
     */
    @Log(businessType = BusinessType.SELECT)
    @PostMapping("/list")
    public ResponseTemplate pageManager(@RequestBody Page<Manager> page, Manager manager) {
        return ResponseTemplate.success(managerService.pageManager(page, manager));
    }
    
    /**
     * 根据id获取管理员信息表详情
     */
    @GetMapping("/{id}")
    public ResponseTemplate getManagerById(@PathVariable Long id) {
        return ResponseTemplate.success(managerService.getManagerById(id));
    }
    
    /**
     * 新增-管理员信息表
     */
    @PostMapping
    public ResponseTemplate insertManager(@RequestBody Manager manager) {
        managerService.insertManager(manager);
        return ResponseTemplate.success();
    }
    
    /**
     * 修改-管理员信息表
     */
    @PutMapping
    public ResponseTemplate updateManager(@RequestBody Manager manager) {
        managerService.updateManager(manager);
        return ResponseTemplate.success();
    }
    
    /**
     * 删除-管理员信息表
     */
    @DeleteMapping("/{id}")
    public ResponseTemplate deleteManager(@PathVariable("id") Long id) {
        managerService.deleteManager(id);
        return ResponseTemplate.success();
    }
    
}
