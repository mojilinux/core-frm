package com.core.framework.service.baseInformationHeader;

import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.baseInformationHeader.IBaseInformationHeaderRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BaseInformationHeaderService extends GenericService<BaseInformationHeader, String> implements IBaseInformationHeaderService {

    @Autowired
    private IBaseInformationHeaderRepository iBaseInformationHeaderRepository;

    @Override
    protected IGenericRepository<BaseInformationHeader, String> getGenericRepo() {
        return iBaseInformationHeaderRepository;
    }

    @Override
    public BaseInformationHeader loadByTitle(String title) {
        return iBaseInformationHeaderRepository.loadByTitle(title);
    }

    @Override
    public Page<BaseInformationHeader> getAllGrid(Pageable pageable, String topic) {
        return iBaseInformationHeaderRepository.getAllGrid(pageable, topic);
    }
}
