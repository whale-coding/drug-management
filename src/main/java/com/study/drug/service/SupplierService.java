package com.study.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.drug.pojo.Supplier;


import java.util.List;

/**
 * 供应商的service接口
 */
public interface SupplierService extends IService<Supplier> {
    /**
     * 分页查询供应商数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-供应商名称
     * @return
     */
    IPage<Supplier> selectSupplierPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条供应商信息
     * @param supplier
     */
    int addSupplier(Supplier supplier);

    /**
     * 修改一条供应商信息
     * @param supplier
     */
    int editSupplier(Supplier supplier);

    /**
     * 根据主键id查询一个供应商对象
     * @param id
     * @return
     */
    Supplier querySupplierById(Integer id);

    /**
     * 根据主键id删除一个供应商对象
     * @param id
     * @return
     */
    int delSupplierById(Integer id);

    /**
     * 查询所有供应商
     * @return
     */
    List<Supplier> querySupplierList();
}
