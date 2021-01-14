package cn.erectpine.mybootdemo.project.core.service.impl;

import cn.erectpine.mybootdemo.project.core.entity.Dept;
import cn.erectpine.mybootdemo.project.core.mapper.DeptMapper;
import cn.erectpine.mybootdemo.project.core.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author wls
 * @since 2021-01-14
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    /**
     * 部门表-列表
     *
     * @param page  分页参数
     * @param dept 查询条件
     * @return 分页列表
     */
    @Override
    public IPage<Dept> pageDept(Page<Dept> page, Dept dept) {
        return page(page, Wrappers.lambdaQuery(dept).orderByDesc(Dept::getCreateTime));
    }

    /**
     * 根据id获取部门表详情
     *
     * @param id id
     * @return {@link Dept}
     */
    @Override
    public Dept getDeptById(Long id) {
        return getById(id);
    }

    /**
     * 新增-部门表
     *
     * @param dept 部门表
     */
    @Override
    public void insertDept(Dept dept) {
        save(dept);
    }

    /**
     * 修改-部门表
     *
     * @param dept 部门表
     */
    @Override
    public void updateDept(Dept dept) {
        updateById(dept);
    }

    /**
     * 删除-部门表
     *
     * @param id id
     */
    @Override
    public void deleteDept(Long id) {
        removeById(id);
    }

}
