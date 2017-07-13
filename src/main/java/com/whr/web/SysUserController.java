package com.whr.web;

import com.whr.dto.SysUserQueryKey;
import com.whr.dto.ValidationResult;
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

    private static final String VIEW_USER_FORM = "user/createOrUpdate";
    private static final String VIEW_USER_LIST = "user/list";

    @Autowired
    private SysUserService us;

    /**
     * 创建新用户
     * @param m
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreateForm(Model m){

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

        //验证用户登录名是否可用
        ValidationResult loginNameResult = us.validateLoginName(user.getLoginName());
        if(loginNameResult.isValidationError()){
            bind.rejectValue(loginNameResult.getProperty(),"",loginNameResult.getMessage());
        }

        if(bind.hasErrors()){
            //表单验证错误，返回页面修改
            return VIEW_USER_FORM;
        }
        //保存
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

    /**
     * 处理编辑用户的表单
     * @param user
     * @param bind
     * @param status
     * @return
     */
    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute("user") @Valid SysUser user, BindingResult bind, SessionStatus status){
        if(bind.hasErrors()){
            //表单验证错误，返回页面修改
            return VIEW_USER_FORM;
        }
        //保存
        us.saveOrUpdate(user);
        status.setComplete();
        return "redirect:/admin/user/list";
    }

    /**
     * 查询列表初始化
     * @param m
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model m){
        SysUserQueryKey key = new SysUserQueryKey();
        List<SysUser> userList = us.query(key);
        m.addAttribute("key",key);
        m.addAttribute("list",userList);
        return VIEW_USER_LIST;
    }

    /**
     * 查询请求处理
     * @param key
     * @param m
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String list(@ModelAttribute SysUserQueryKey key, Model m){
        List<SysUser> userList = us.query(key);
        m.addAttribute("list", userList);
        m.addAttribute("key",key);
        return VIEW_USER_LIST;
    }

    /**
     * 删除用户
     * @param userId
     * @param m
     * @return
     */
    @RequestMapping(value = "/{userId}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int userId, Model m){
        us.delete(userId);
        return "redirect:/admin/user/list";
    }
}
