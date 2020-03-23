package com.it.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.dao.UserMapper;
import com.it.entity.PageResult;
import com.it.entity.User;
import com.it.entity.UserExample;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 返回全部列表
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    /**
     * 返回分页列表
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page = (Page<User>) userMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     * @param user
     */
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    /**
     * 修改
     * @param user
     */
    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public User findOne(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {
        for(Long id : ids){
            userMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 条件查询（分页）
     * @param user
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageResult findPage(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user != null){
//            if(brand.getName() != null && brand.getName().length() > 0){
//                criteria.andNameLike("%"+brand.getName()+"%");
//            }
//            if(brand.getFirstChar() != null && brand.getFirstChar().length() > 0){
//                criteria.andFirstCharEqualTo(brand.getFirstChar());
//            }
        }
        Page<User> page = (Page<User>)userMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
