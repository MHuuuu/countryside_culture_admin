package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.Chunk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface ChunkRepository extends JpaRepository<Chunk, Integer>, JpaSpecificationExecutor<Chunk> {

}
