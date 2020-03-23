package com.it.service;

import com.it.entity.PageResult;
import com.it.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 返回全部列表
     * @return
     */
    public List<User> findAll();

    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加
     * @param user
     */
    public void add(User user);

    /**
     * 修改
     * @param user
     */
    public void update(User user);

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public User findOne(Long id);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 条件查询（分页）
     * @param user
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(User user, int pageNum, int pageSize);

}
