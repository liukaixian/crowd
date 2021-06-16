package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    public List<Admin> getAll() {

      return   adminMapper.selectByExample(new AdminExample());
    }

    public Admin doLogin(Admin admin) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andLoginAcctEqualTo(admin.getLoginAcct());
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList == null || adminList.size() == 0){
            throw  new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        if(adminList.size() > 1 ){
            throw  new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }
        Admin adminDB = adminList.get(0);
        if(adminDB ==null){
            throw  new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        String userPswdDB = adminDB.getUserPswd();
        String userPswdFrom = admin.getUserPswd();
        String userPswdmd5 = CrowdUtil.md5(userPswdFrom);
        if (!Objects.equals(userPswdDB,userPswdmd5)){
            throw  new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        return adminDB ;
    }

    @Override
    public PageInfo<Admin> selectAdminByKeywordAndPage(String keyword,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectAdminByKeyword(keyword);
        return new PageInfo<>(admins);
    }

    @Override
    public int doRemoveAdminById(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }
}
