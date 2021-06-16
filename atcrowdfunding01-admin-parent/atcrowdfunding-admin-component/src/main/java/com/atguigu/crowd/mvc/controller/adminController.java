package com.atguigu.crowd.mvc.controller;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.ResultEntity;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin

@Controller
public class adminController {

    @Autowired
    private AdminService adminService;



    @RequestMapping("do/admin/login")
    public String doLogin(Admin admin, HttpServletRequest request) {
        Admin adminDB = adminService.doLogin(admin);
        request.getSession().setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,adminDB);
        return "redirect:/to/pages/main";
    }
    @RequestMapping("do/admin/logout")
    public String doLogout(Admin admin, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/to/pages/login";
    }
    @RequestMapping("do/admin/selectAdminByKeywordAndPage")
    public String selectAdminByKeyword(
            @RequestParam(value = "keyword",defaultValue = "") String keyword,
            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
            ModelMap modelMap
                                       ) {
        PageInfo pageInfo = adminService.selectAdminByKeywordAndPage(keyword,pageNum,pageSize);
        modelMap.addAttribute("pageInfo",pageInfo);
        modelMap.addAttribute("keyword",keyword);
        return "user";
    }
    @RequestMapping("do/admin/remove/{id}/{pageNum}/{keyword}.do")
    public String doRemoveAdminById(@PathVariable("id") Integer id,
                                    @PathVariable("pageNum") Integer pageNum,
                                    @PathVariable("keyword") String keyword
                                    ) {
        int count = adminService.doRemoveAdminById(id);
        return "redirect:/do/admin/selectAdminByKeywordAndPage?pageNum"+pageNum+"&keyword="+keyword;
    }



//    @ResponseBody
//    @RequestMapping("test/test.do")
//    public List getAllAdmin() {
//        List<Admin> adminList = adminService.getAll();
//        return adminList;
//    }
//
//    @ResponseBody
//    @RequestMapping("test/test1.do")
//    public  Admin testAjax(){
//        String a= null;
//        System.out.println(a.length());
//
//        return new Admin() ;
//    }
//
//    @ResponseBody
//    @RequestMapping("test/test2.do")
//    public ResultEntity<Student> testComposeObject(@RequestBody Student student) {
//
//        return ResultEntity.successWithData(student);
//    }
//
//    @RequestMapping("test/test3.do")
//    public String getSuccess() {
//
//        return "success";
//    }
}
