package com.core.framework.service.baseInformationHeader;

import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import com.core.framework.service.IGenericService;

public interface IBaseInformationHeaderService extends IGenericService<BaseInformationHeader, Long> {

    public BaseInformationHeader loadByTitle(String title);
}
