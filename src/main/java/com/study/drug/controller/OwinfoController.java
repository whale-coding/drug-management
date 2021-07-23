package com.study.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.study.drug.common.ResultMapUtil;
import com.study.drug.pojo.Owinfo;
import com.study.drug.service.OwinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 药品出入库相关的controller
 */
@Controller
@RequestMapping(value = "/owinfo")
public class OwinfoController {

    @Resource
    private OwinfoService owinfoService;

    /**
     * 转向药品出入库页面
     */
    @RequestMapping
    public String owinfo(){
        return "owinfo";
    }

    /**
     * 分页查询药品出入库列表
     */
    @RequestMapping(value = "/owinfoQueryPage")
    @ResponseBody
    public Object owinfoQueryPage(String param, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int limit){
        try{
            IPage<Owinfo> iPage = owinfoService.selectOwinfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品出入库新增页面
     */
    @RequestMapping(value = "/owinfoPage")
    public String owinfoPage(){
        return "owinfoPage";
    }

    /**
     * 添加一个药品出入库
     */
    @RequestMapping(value = "/owinfoAdd")
    @ResponseBody
    public Object owinfoAdd(Owinfo owinfo){
        try{
            owinfo.setCreatetime(new Date());
            int i = owinfoService.addOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品出入库编辑页面
     */
    @RequestMapping(value = "/owinfoQueryById")
    public String owinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Owinfo owinfo = owinfoService.queryOwinfoById(id);
        model.addAttribute("obj",owinfo);
        return "owinfoPage";
    }

    /**
     * 修改一个药品出入库
     */
    @RequestMapping(value = "/owinfoEdit")
    @ResponseBody
    public Object owinfoEdit(Owinfo owinfo){
        try{
            int i = owinfoService.editOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品出入库
     */
    @RequestMapping(value = "/owinfoDelById")
    @ResponseBody
    public Object owinfoDelById(Integer id){
        try{
            int i = owinfoService.delOwinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















