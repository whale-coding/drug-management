package com.study.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.study.drug.common.ResultMapUtil;
import com.study.drug.pojo.Billinfo;
import com.study.drug.service.BillinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 账单信息相关的controller
 */
@Controller
@RequestMapping(value = "/billinfo")
public class BillinfoController {

    @Resource
    private BillinfoService billinfoService;

    /**
     * 转向账单信息页面
     */
    @RequestMapping
    public String billinfo(){
        return "billinfo";
    }

    /**
     * 分页查询账单信息列表
     */
    @RequestMapping(value = "/billinfoQueryPage")
    @ResponseBody
    public Object billinfoQueryPage(String param, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int limit){
        try{
            IPage<Billinfo> iPage = billinfoService.selectBillinfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向账单信息新增页面
     */
    @RequestMapping(value = "/billinfoPage")
    public String billinfoPage(){
        return "billinfoPage";
    }

    /**
     * 添加一个账单信息
     */
    @RequestMapping(value = "/billinfoAdd")
    @ResponseBody
    public Object billinfoAdd(Billinfo billinfo){
        try{
            int i = billinfoService.addBillinfo(billinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向账单信息编辑页面
     */
    @RequestMapping(value = "/billinfoQueryById")
    public String billinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "billinfoPage";
    }

    /**
     * 修改一个账单信息
     */
    @RequestMapping(value = "/billinfoEdit")
    @ResponseBody
    public Object billinfoEdit(Billinfo billinfo){
        try{
            int i = billinfoService.editBillinfo(billinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个账单信息
     */
    @RequestMapping(value = "/billinfoDelById")
    @ResponseBody
    public Object billinfoDelById(Integer id){
        try{
            int i = billinfoService.delBillinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















