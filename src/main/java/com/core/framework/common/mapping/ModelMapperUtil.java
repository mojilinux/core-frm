package com.core.framework.common.mapping;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperUtil {

    @Autowired
	private static final DozerBeanMapper modelMapper;
	static {
		modelMapper = new DozerBeanMapper();
	}

	/**
	 * Hide from public usage.
	 */
	private ModelMapperUtil() {
	}

	public static <D, T> D map(final T entity, Class<D> outClass) {
		return modelMapper.map(entity, outClass);
	}

	public static <D, T> List<D> mapList(final List<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}

	public static <S, D> D map(final S source, D destination) {
		modelMapper.map(source, destination);
		return destination;
	}
}
