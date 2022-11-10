package com.lami.framework.common.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperUtil {
	private static final ModelMapper modelMapper;

	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
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
