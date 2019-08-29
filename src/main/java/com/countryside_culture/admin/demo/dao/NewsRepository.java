package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsRepository extends JpaRepository<News,Integer> {
    Page<News> findAllByEditorId(int editorId, Pageable pageable);
    Page<News> findAllByExamStatusGreaterThan(int status,Pageable pageable);
}
