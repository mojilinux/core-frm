package com.core.framework.service.baseInformation;

import com.core.framework.domain.baseInformation.BaseInformation;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.baseInformation.IBaseInformationRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseInformationService extends GenericService<BaseInformation, Long> implements IBaseInformationService {

    @Autowired
    private IBaseInformationRepository iBaseInformationRepository;

    @Override
    protected IGenericRepository<BaseInformation, Long> getGenericRepo() {
        return iBaseInformationRepository;
    }
}
