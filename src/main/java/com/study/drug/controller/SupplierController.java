package com.study.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.drug.common.ResultMapUtil;
import com.study.drug.pojo.Supplier;
import com.study.drug.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 供应商相关的controller
 */
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 转向供应商页面
     */
    @GetMapping("/toSupplier")
    public String supplier(){
        return "supplier";
    }

    /**
     * 分页查询供应商列表
     * layui的分页参数是page和limit
     * page:即pageNum表示第几页
     * limit:即pageSize表示每页多少条数据
     */
    @RequestMapping(value = "/supplierQueryPage")
    @ResponseBody
    public Object supplierQueryPage(String param, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int limit){
        try{
            IPage<Supplier> iPage = supplierService.selectSupplierPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向供应商新增页面
     */
    @RequestMapping(value = "/supplierPage")
    public String supplierPage(){
        return "supplierPage";
    }

    /**
     * 添加一个供应商
     */
    @RequestMapping(value = "/supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier){
        try{
            supplier.setCreatetime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向供应商编辑页面
     */
    @RequestMapping(value = "/supplierQueryById")
    public String supplierQueryById(@RequestParam("id")Integer id, Model model){
        //将信息回显
        Supplier supplier = supplierService.querySupplierById(id);
        model.addAttribute("obj",supplier);
        return "supplierPage";
    }

    /**
     * 修改一个供应商
     */
    @RequestMapping(value = "/supplierEdit")
    @ResponseBody
    public Object supplierEdit(Supplier supplier){
        try{
            int i = supplierService.editSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个供应商
     */
    @RequestMapping(value = "/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try{
            int i = supplierService.delSupplierById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有供应商
     */
    @RequestMapping(value = "/supplieList")
    @ResponseBody
    public Object supplieList(){
        List<Supplier> supplierList = supplierService.querySupplierList();
        return ResultMapUtil.getHashMapList(supplierList);
    }

}





















