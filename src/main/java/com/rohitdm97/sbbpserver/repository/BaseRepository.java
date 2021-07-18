package com.rohitdm97.sbbpserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E> extends JpaRepository<E, Integer>, JpaSpecificationExecutor<E> {
}
