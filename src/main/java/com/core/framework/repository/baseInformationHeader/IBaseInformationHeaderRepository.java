package com.core.framework.repository.baseInformationHeader;

import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import com.core.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBaseInformationHeaderRepository extends IGenericRepository<BaseInformationHeader, String> {

    @Query(value = "select e from BaseInformationHeader e where e.topic =:title")
    BaseInformationHeader loadByTitle(@Param("title") String title);
}
