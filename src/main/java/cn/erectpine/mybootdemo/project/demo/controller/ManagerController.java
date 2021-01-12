package cn.erectpine.mybootdemo.project.demo.controller;

import cn.erectpine.mybootdemo.common.web.ResponseTemplate;
import cn.erectpine.mybootdemo.project.demo.entity.Manager;
import cn.erectpine.mybootdemo.project.demo.service.IManagerService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员信息表 前端控制器
 * </p>
 *
 * @author wls
 * @since 2021-01-08
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    IManagerService managerService;

    @PostMapping("/list")
    public ResponseTemplate pageManager(@RequestBody Page<Manager> page, Manager manager) {
        return ResponseTemplate.success(managerService.pageManager(page, manager));
    }

    @GetMapping("/{id}")
    public ResponseTemplate pageManager(@PathVariable Long id) {
        return ResponseTemplate.success(managerService.pageManager(id));
    }

    @PostMapping
    public ResponseTemplate insertManager(@RequestBody Manager manager) {
        managerService.insertManager(manager);
        return ResponseTemplate.success();
    }

    @PutMapping
    public ResponseTemplate updateManager(@RequestBody Manager manager) {
        managerService.updateManager(manager);
        return ResponseTemplate.success();
    }

    @DeleteMapping("/{id}")
    public ResponseTemplate deleteManager(@PathVariable("id") Long id) {
        managerService.deleteManager(id);
        return ResponseTemplate.success();
    }

}
