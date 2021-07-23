package com.study.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.study.drug.mapper.ReturngoodsMapper;
import com.study.drug.pojo.Returngoods;
import com.study.drug.service.ReturngoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 收到退货service实现类
 */
@Service
public class ReturngoodsServiceImpl extends ServiceImpl<ReturngoodsMapper, Returngoods> implements ReturngoodsService {

    @Resource
    private ReturngoodsMapper returngoodsMapper;

    /**
     * 分页查询收到退货数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-收到退货名称
     * @return
     */
    @Override
    public IPage<Returngoods> selectReturngoodsPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(param)){
            queryWrapper.like("dname",param);
        }
        Page<Returngoods> page = new Page<>(pageNum,pageSize);
        return returngoodsMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条收到退货信息
     *
     * @param returngoods
     */
    @Override
    public int addReturngoods(Returngoods returngoods) {
        return returngoodsMapper.insert(returngoods);
    }

    /**
     * 修改一条收到退货信息
     *
     * @param returngoods
     */
    @Override
    public int editReturngoods(Returngoods returngoods) {
        return returngoodsMapper.updateById(returngoods);
    }

    /**
     * 根据主键id查询一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public Returngoods queryReturngoodsById(Integer id) {
        return returngoodsMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public int delReturngoodsById(Integer id) {
        return returngoodsMapper.deleteById(id);
    }

}
