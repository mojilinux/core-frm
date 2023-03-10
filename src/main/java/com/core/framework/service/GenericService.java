package com.core.framework.service;

import com.core.framework.domain.BaseEntity;
import com.core.framework.domain.user.User;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.utils.DateUtility;
import com.core.framework.utils.SecurityUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public abstract class GenericService<T extends BaseEntity, PK extends Serializable> implements IGenericService<T, PK> {

    public GenericService() {

    }

    protected abstract IGenericRepository<T, PK> getGenericRepo();

    @Override
    public T load(PK entityId) {
        return (T) this.getGenericRepo().findById(entityId).get();
    }

    @Override
    public List<T> getAll() {
        return toList(this.getGenericRepo().findAll());
    }

    @Override
    public Page<T> getAllGrid(Pageable pageable) {
        return this.getGenericRepo().findAll(pageable);
    }

    @Transactional
    @Override
    public PK save(T entity) {
        User authenticatedUser = SecurityUtil.getAuthenticatedUser();
        if (entity.getId() == null) {
            entity.setCreatedBy(authenticatedUser);
            entity.setCreatedDate(DateUtility.todayJalaliDateAndTime());
        }
        entity.setUpdatedBy(authenticatedUser);
        entity.setUpdatedDate(DateUtility.todayJalaliDateAndTime());
        return (PK) this.getGenericRepo().save(entity).getId();
    }

    @Transactional
    @Override
    public boolean deleteById(PK id) {
        this.getGenericRepo().deleteById(id);
        return true;
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }
}
