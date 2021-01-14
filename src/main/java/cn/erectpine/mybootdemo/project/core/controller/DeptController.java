package cn.erectpine.mybootdemo.project.core.controller;

import cn.erectpine.mybootdemo.common.web.ResponseTemplate;
import cn.erectpine.mybootdemo.project.core.entity.Dept;
import cn.erectpine.mybootdemo.project.core.service.IDeptService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author wls
 * @since 2021-01-14
 */
@RestController
@RequestMapping("/core/dept")
public class DeptController {
    
    @Autowired
    IDeptService deptService;
    
    /**
     * 部门表-分页列表
     */
    @PostMapping("/list")
    public ResponseTemplate pageDept(@RequestBody Page<Dept> page, Dept dept) {
        return ResponseTemplate.success(deptService.pageDept(page, dept));
    }
    
    /**
     * 根据id获取部门表详情
     */
    @GetMapping("/{id}")
    public ResponseTemplate getDeptById(@PathVariable Long id) {
        return ResponseTemplate.success(deptService.getDeptById(id));
    }
    
    /**
     * 新增-部门表
     */
    @PostMapping
    public ResponseTemplate insertDept(@RequestBody Dept dept) {
        deptService.insertDept(dept);
        return ResponseTemplate.success();
    }
    
    /**
     * 修改-部门表
     */
    @PutMapping
    public ResponseTemplate updateDept(@RequestBody Dept dept) {
        deptService.updateDept(dept);
        return ResponseTemplate.success();
    }
    
    /**
     * 删除-部门表
     */
    @DeleteMapping("/{id}")
    public ResponseTemplate deleteDept(@PathVariable("id") Long id) {
        deptService.deleteDept(id);
        return ResponseTemplate.success();
    }
    
}
