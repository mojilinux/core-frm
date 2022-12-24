package com.core.framework.common.mapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperUtil {
    private static final Logger LOGGER = LogManager.getLogger(ModelMapperUtil.class);
    private static Mapper mapper;

    @Autowired(required = true)
    public ModelMapperUtil(Mapper mapper) {
        ModelMapperUtil.mapper = mapper;
    }

    private static Mapper getMapper() {
        if (mapper != null) {
            return mapper;
        } else {
            try {
                mapper = new DozerBeanMapper();
                LOGGER.info("not spring dozer");
            } catch (Exception var1) {
                LOGGER.info(var1);
                mapper = null;
            }
        }
        return mapper;
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        return getMapper().map(entity, outClass);
    }

    public static <D, T> List<D> mapList(final List<T> entityList, Class<D> outCLass) {
        return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
    }

    public static <D, T> Page<D> mapPage(final Page<T> entityPage, Class<D> outCLass) {
        List<D> list = entityPage.getContent().stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
        return new PageImpl<>(list, entityPage.getPageable(), entityPage.getTotalElements());
    }

    public static <S, D> D map(final S source, D destination) {
        getMapper().map(source, destination);
        return destination;
    }
}
