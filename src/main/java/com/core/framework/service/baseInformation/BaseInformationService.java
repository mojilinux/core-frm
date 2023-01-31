package com.core.framework.service.baseInformation;

import com.core.framework.domain.baseInformation.BaseInformation;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.baseInformation.IBaseInformationRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseInformationService extends GenericService<BaseInformation, String> implements IBaseInformationService {

    @Autowired
    private IBaseInformationRepository iBaseInformationRepository;

    @Override
    protected IGenericRepository<BaseInformation, String> getGenericRepo() {
        return iBaseInformationRepository;
    }

    @Override
    public List<BaseInformation> getAll(String headerId) {
        return iBaseInformationRepository.getAll(headerId);
    }

    @Override
    public List<BaseInformation> rootListByHeaderId(String headerId) {
        return iBaseInformationRepository.rootList(headerId);
    }

    @Override
    public List<BaseInformation> listByMasterId(String id) {
        return iBaseInformationRepository.listByMasterId(id);
    }
}
