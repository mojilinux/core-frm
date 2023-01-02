package com.core.framework.repository.baseInformation;

import com.core.framework.domain.baseInformation.BaseInformation;
import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import com.core.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBaseInformationRepository extends IGenericRepository<BaseInformation,String> {

    @Query(value = "select e from BaseInformation e where e.parent.id  = :headerId")
    List<BaseInformation> getAll(@Param("headerId") String headerId);
}
