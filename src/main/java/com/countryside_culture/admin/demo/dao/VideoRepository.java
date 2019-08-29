package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VideoRepository extends JpaRepository<Video,Integer> {
    Page<Video> findAllByAuthorId(int authorId, Pageable pageable);
    Page<Video> findAllByStatusGreaterThan(int status, Pageable pageable);
}
