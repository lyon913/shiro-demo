package com.whr.web;

import com.whr.dto.SysUserQueryKey;
import com.whr.model.SysUser;
import com.whr.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Lyon on 2017/7/12.
 */
@Controller
@RequestMapping("/admin/user")
@SessionAttributes("user")
public class SysUserController {

    private static String VIEW_USER_FORM = "user/createOrUpdate";

    @Autowired
    private SysUserService us;

    /**
     * 创建新用户
     * @param m
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreateForm(Model m){

        //staffNo临时赋值，正式代码应从staff表获取
        SysUser user = us.newUser();
        m.addAttribute("user",user);
        return VIEW_USER_FORM;
    }

    /**
     * 处理创建新用户表单
     * @param user
     * @param bind
     * @param status
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreateForm(@ModelAttribute("user") @Valid SysUser user, BindingResult bind, SessionStatus status){
        if(bind.hasErrors()){
            return VIEW_USER_FORM;
        }

        us.saveOrUpdate(user);
        status.setComplete();
        return "redirect:/admin/user/list";
    }

    /**
     * 初始化更新用户信息表单
     * @param m
     * @return
     */
    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable int userId, Model m){

        //staffNo临时赋值，正式代码应从staff表获取
        SysUser user = us.getById(userId);
        m.addAttribute("user",user);
        return VIEW_USER_FORM;
    }

    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute("user") @Valid SysUser user, BindingResult bind, SessionStatus status){
        if(bind.hasErrors()){
            return VIEW_USER_FORM;
        }

        us.saveOrUpdate(user);
        status.setComplete();
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model m){
        SysUserQueryKey key = new SysUserQueryKey();
        List<SysUser> userList = us.query(key);
        m.addAttribute("key",key);
        m.addAttribute("list",userList);
        return "user/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String list(@ModelAttribute SysUserQueryKey key, Model m){
        List<SysUser> userList = us.query(key);
        m.addAttribute("list", userList);
        m.addAttribute("key",key);
        return "user/list";
    }
}
