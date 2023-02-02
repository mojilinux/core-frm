package com.core.framework.service.baseInformation;

import com.core.framework.domain.baseInformation.BaseInformation;
import com.core.framework.service.IGenericService;

import java.util.List;

public interface IBaseInformationService extends IGenericService<BaseInformation, String> {


    List<BaseInformation> getAll(String headerId);

    List<BaseInformation> rootListByHeaderId(String headerId);

    List<BaseInformation> listByMasterId(String id);
}
