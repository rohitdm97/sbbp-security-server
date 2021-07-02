package com.rohitdm97.sbbpserver.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

import com.rohitdm97.sbbpserver.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends AbstractEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {

    default Predicate True(CriteriaBuilder cb) {
        return cb.and();
    }

    default Predicate False(CriteriaBuilder cb) {
        return cb.or();
    }

}
