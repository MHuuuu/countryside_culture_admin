package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.News;
import com.countryside_culture.admin.demo.entity.Video;
import com.countryside_culture.admin.demo.entity.VideoCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface VideoRepository extends JpaRepository<Video,Integer> {
//    @Query(value = "SELECT new com.countryside_culture.admin.demo.entity.VideoCustom(v.id,v.title,v.publish_time,v.status) " +
//                    "FROM video v " +
//                    "WHERE v.author_id= :authorId ")
//    List<VideoCustom> findByAuthorId(@Param("authorId") int authorId,
//                                     Pageable pageable);

    Page<Video> findAllByAuthorId(int authorId, Pageable pageable);
    Page<Video> findAllByStatusGreaterThan(int status, Pageable pageable);
}
