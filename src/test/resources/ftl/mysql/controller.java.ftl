package ${package.Controller};

<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
<#else>
</#if>
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import cn.erectpine.mybootdemo.common.web.ResponseTemplate;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if swagger2>
@ApiModelProperty(value = "${field.comment}")
<#else>
</#if>
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    ${table.serviceName} ${table.entityPath}Service;

    <#if swagger2>
    @ApiOperation("${table.comment!}-列表")
    <#else>
    </#if>
    @GetMapping
    public ResponseTemplate page${entity}(<#if swagger2>@ApiIgnore <#else></#if>Page<${entity}> page, ${entity} ${table.entityPath}) {
        return ResponseTemplate.success(${table.entityPath}Service.page${entity}(page, ${table.entityPath}));
    }

    <#if swagger2>
    @ApiOperation("根据id获取${table.comment!}详情")
    <#else>
    </#if>
    @GetMapping("/{id}")
    public ResponseTemplate page${entity}(@PathVariable Long id) {
        return ResponseTemplate.success(${table.entityPath}Service.page${entity}(id));
    }

    <#if swagger2>
    @ApiOperation("新增-${table.comment!}")
    <#else>
    </#if>
    @PostMapping
    public ResponseTemplate insert${entity}(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.insert${entity}(${table.entityPath});
        return ResponseTemplate.success();
    }

    <#if swagger2>
    @ApiOperation("修改-${table.comment!}")
    <#else>
    </#if>
    @PutMapping
    public ResponseTemplate update${entity}(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.update${entity}(${table.entityPath});
        return ResponseTemplate.success();
    }

    <#if swagger2>
    @ApiOperation("删除-${table.comment!}")
    <#else>
    </#if>
    @DeleteMapping("/{id}")
    public ResponseTemplate delete${entity}(@PathVariable("id") Long id) {
        ${table.entityPath}Service.delete${entity}(id);
        return ResponseTemplate.success();
    }

}
</#if>
