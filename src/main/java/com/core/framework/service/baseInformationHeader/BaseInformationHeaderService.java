package com.core.framework.service.baseInformationHeader;

import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.baseInformationHeader.IBaseInformationHeaderRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseInformationHeaderService extends GenericService<BaseInformationHeader, Long> implements IBaseInformationHeaderService {

    @Autowired
    private IBaseInformationHeaderRepository iBaseInformationHeaderRepository;

    @Override
    protected IGenericRepository<BaseInformationHeader, Long> getGenericRepo() {
        return iBaseInformationHeaderRepository;
    }

    @Override
    public BaseInformationHeader loadByTitle(String title) {
        return iBaseInformationHeaderRepository.loadByTitle(title);
    }
}
