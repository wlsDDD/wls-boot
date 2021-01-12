package cn.erectpine.mybootdemo.project.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理员信息表
 * </p>
 *
 * @author wls
 * @since 2021-01-12
 */
@Data
@Accessors(chain = true)
@TableName("manager")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键，自增策略
     */
    @TableId(value = "manager_id", type = IdType.AUTO)
    private Integer       managerId;
    /**
     * 用户名
     */
    private String        managerName;
    /**
     * 登录账户
     */
    private String        account;
    /**
     * 登录密码
     */
    private String        password;
    /**
     * 管理员邮箱
     */
    private String        email;
    /**
     * 账户描述
     */
    private String        description;
    /**
     * 管理员类型：1-超级管理员(集团唯一)，2-普通管理员
     */
    private Integer       type;
    /**
     * 管理员状态
     */
    private Boolean       managerStatus;
    /**
     * 所属集团代码，与超级管理员关联，在超级管理员注册时自动生成32位UUID
     */
    private String        groupCode;
    /**
     * 上级管理员ID，即超级管理员ID，超级管理员值为0
     */
    private Integer       parentId;
    /**
     * 风险预警开关：0-关闭/1-开启，默认为关闭
     */
    private Integer       riskWarning;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 上次登陆时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 是否过期
     */
    private Boolean       accountNonExpired;
    /**
     * 是否锁定
     */
    private Boolean       accountNonLocked;
    private Boolean       credentialsNonExpired;
    private String        createBy;
    private String        updateBy;
    /**
     * 角色
     */
    private Integer       roleId;
    
}
