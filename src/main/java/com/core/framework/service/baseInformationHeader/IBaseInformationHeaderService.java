package com.core.framework.service.baseInformationHeader;

import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import com.core.framework.service.IGenericService;
import com.core.framework.web.viewModel.baseInformationHeader.BaseInformationHeaderViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBaseInformationHeaderService extends IGenericService<BaseInformationHeader, String> {

    public BaseInformationHeader loadByTitle(String title);

    Page<BaseInformationHeader> getAllGrid(Pageable pageable, String topic);
}
