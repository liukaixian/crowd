package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    public void saveAdmin(Admin admin);

  List<Admin> getAll();

    Admin doLogin(Admin admin);

    PageInfo<Admin> selectAdminByKeywordAndPage(String keyword, int pageNum, int pageSize);

    int doRemoveAdminById(Integer id);
}
