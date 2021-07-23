package com.study.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.study.drug.common.ResultMapUtil;
import com.study.drug.pojo.Returngoods;
import com.study.drug.service.ReturngoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 收到退货相关的controller
 */
@Controller
@RequestMapping(value = "/returngoods")
public class ReturngoodsController {

    @Resource
    private ReturngoodsService returngoodsService;

    /**
     * 转向收到退货页面
     */
    @RequestMapping
    public String returngoods(){
        return "returngoods";
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping(value = "/returngoodsQueryPage")
    @ResponseBody
    public Object returngoodsQueryPage(String param, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int limit){
        try{
            IPage<Returngoods> iPage = returngoodsService.selectReturngoodsPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货新增页面
     */
    @RequestMapping(value = "/returngoodsPage")
    public String returngoodsPage(){
        return "returngoodsPage";
    }

    /**
     * 添加一个收到退货
     */
    @RequestMapping(value = "/returngoodsAdd")
    @ResponseBody
    public Object returngoodsAdd(Returngoods returngoods){
        try{
            int i = returngoodsService.addReturngoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping(value = "/returngoodsQueryById")
    public String returngoodsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returngoods returngoods = returngoodsService.queryReturngoodsById(id);
        model.addAttribute("obj",returngoods);
        return "returngoodsPage";
    }

    /**
     * 修改一个收到退货
     */
    @RequestMapping(value = "/returngoodsEdit")
    @ResponseBody
    public Object returngoodsEdit(Returngoods returngoods){
        try{
            int i = returngoodsService.editReturngoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个收到退货
     */
    @RequestMapping(value = "/returngoodsDelById")
    @ResponseBody
    public Object returngoodsDelById(Integer id){
        try{
            int i = returngoodsService.delReturngoodsById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















