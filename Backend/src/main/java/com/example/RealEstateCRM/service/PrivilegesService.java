package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Privilege;

import java.util.List;
import java.util.Set;

public interface PrivilegesService {
    public Privilege generatePrivilege(Privilege privilege);

    //FOR SECURITY
    public List<String> getActivePriviledgeColumnsForMultipleRoles(String emailId);

//    public List<String> getActivePrivilegeColumns(String emailId);
}
