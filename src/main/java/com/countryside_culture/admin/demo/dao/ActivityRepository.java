package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.Activity;
import com.countryside_culture.admin.demo.entity.AdminUser;
import com.countryside_culture.admin.demo.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Page<Activity> findAll(Pageable pageable);
}
