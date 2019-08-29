package com.countryside_culture.admin.demo.dao;

import com.countryside_culture.admin.demo.entity.Chunk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChunkRepository extends JpaRepository<Chunk, Integer>, JpaSpecificationExecutor<Chunk> {

}
