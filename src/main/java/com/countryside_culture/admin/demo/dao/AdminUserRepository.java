package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.entity.AdminUserCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {

    public AdminUser findAdminUserByUsernameAndPassword(String userName, String password);

    @Query(nativeQuery = true,
            value = "SELECT a.*,r.role\n" +
                    "FROM admin a\n" +
                    "LEFT JOIN user_role ur ON ur.user_id=a.id\n" +
                    "LEFT JOIN role r ON r.id=ur.role_id\n" +
                    "WHERE a.id= :id")
    public List<Object[]> findAdminUserInfoById(@Param("id") Integer id);
}
