package cn.erectpine.mybootdemo.common.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 核心工具类
 *
 * @Author wls
 * @Date 2021/1/12 11:58
 */
public class CoreUtil {
    
    /**
     * 自定义树相关属性配置
     * 树属性配置参考  {@link TreeNodeConfig}
     */
    public static final TreeNodeConfig TREE_CONFIG;
    
    static {
        TREE_CONFIG = new TreeNodeConfig();
        TREE_CONFIG.setIdKey("id");
        TREE_CONFIG.setParentIdKey("pid");
        TREE_CONFIG.setWeightKey("createTime");
    }
    
    /**
     * 列表转树
     *
     * @param list 列表
     * @return {@link List} 树列表
     * @Author wls
     */
    public static <T> List<Tree<Long>> toTree(List<T> list) {
        return TreeUtil.build(list, 0L, TREE_CONFIG, (treeNode, tree) -> tree.putAll(BeanUtil.beanToMap(treeNode)));
    }
    
    /**
     * 列表转树
     *
     * @param list     列表
     * @param rootNode 是否不存在根节点
     *                 true 不存在,自动寻找无上级节点成为根节点;
     *                 false 存在根节点且为0 此时直接调用 toTree(List<T> list)
     * @return {@link List} 树列表
     * @Author wls
     */
    public static <T> List<Tree<Long>> toTree(List<T> list, boolean rootNode) {
        if (rootNode) {
            return toTree(list.parallelStream().peek(e -> {
                Map<String, Object> map = BeanUtil.beanToMap(e);
                if (list.parallelStream().noneMatch(value -> BeanUtil.beanToMap(value).get(TREE_CONFIG.getIdKey())
                                                                     .equals(map.get(TREE_CONFIG.getParentIdKey())))) {
                    map.put(TREE_CONFIG.getParentIdKey(), 0L);
                    e = (T) BeanUtil.toBean(map, e.getClass());
                }
            }).collect(Collectors.toList()));
        }
        return toTree(list);
    }
    
    /**
     * 浅拷贝-拷贝属性
     * 将old类中的属性拷贝到fresh中
     * 拷贝规则: 属性名相同
     *
     * @param old   源对象
     * @param fresh 拷贝后的对象
     * @return fresh
     */
    public static <T> T convertFor(Object old, T fresh) {
        BeanUtils.copyProperties(old, fresh);
        return fresh;
    }
    
    /**
     * 获取日期echarts
     *
     * @param days 时间段
     * @return {@link Map}
     */
    public static Map<String, Long> getDateEchartsMap(Integer days) {
        return getDateEchartsMap(LocalDateTime.now(), days);
    }
    
    /**
     * 获取日期echarts
     *
     * @param now  当前时间
     * @param days 时间段
     * @return {@link Map}
     */
    public static Map<String, Long> getDateEchartsMap(LocalDateTime now, Integer days) {
        Map<String, Long> map = new TreeMap<>();
        for (int i = 0; i < days; i++) {
            LocalDateTime offset = LocalDateTimeUtil.offset(now, -i, ChronoUnit.DAYS);
            String format = LocalDateTimeUtil.format(offset, DatePattern.NORM_DATE_PATTERN);
            map.put(format, 0L);
        }
        return map;
    }
}
