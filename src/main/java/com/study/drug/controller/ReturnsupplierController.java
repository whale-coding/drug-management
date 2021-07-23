package com.study.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.study.drug.common.ResultMapUtil;
import com.study.drug.pojo.Returnsupplier;
import com.study.drug.service.ReturnsupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 退货给供应商相关的controller
 */
@Controller
@RequestMapping(value = "/returnsupplier")
public class ReturnsupplierController {

    @Resource
    private ReturnsupplierService returnsupplierService;

    /**
     * 转向退货给供应商页面
     */
    @RequestMapping
    public String returnsupplier(){
        return "returnsupplier";
    }

    /**
     * 分页查询退货给供应商列表
     */
    @RequestMapping(value = "/returnsupplierQueryPage")
    @ResponseBody
    public Object returnsupplierQueryPage(String param, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int limit){
        try{
            IPage<Returnsupplier> iPage = returnsupplierService.selectReturnsupplierPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向退货给供应商新增页面
     */
    @RequestMapping(value = "/returnsupplierPage")
    public String returnsupplierPage(){
        return "returnsupplierPage";
    }

    /**
     * 添加一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierAdd")
    @ResponseBody
    public Object returnsupplierAdd(Returnsupplier returnsupplier){
        try{
            int i = returnsupplierService.addReturnsupplier(returnsupplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向退货给供应商编辑页面
     */
    @RequestMapping(value = "/returnsupplierQueryById")
    public String returnsupplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returnsupplier returnsupplier = returnsupplierService.queryReturnsupplierById(id);
        model.addAttribute("obj",returnsupplier);
        return "returnsupplierPage";
    }

    /**
     * 修改一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierEdit")
    @ResponseBody
    public Object returnsupplierEdit(Returnsupplier returnsupplier){
        try{
            int i = returnsupplierService.editReturnsupplier(returnsupplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierDelById")
    @ResponseBody
    public Object returnsupplierDelById(Integer id){
        try{
            int i = returnsupplierService.delReturnsupplierById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















