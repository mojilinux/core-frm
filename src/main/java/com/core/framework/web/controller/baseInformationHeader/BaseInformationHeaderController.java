package com.core.framework.web.controller.baseInformationHeader;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import com.core.framework.service.baseInformationHeader.IBaseInformationHeaderService;
import com.core.framework.web.viewModel.baseInformationHeader.BaseInformationHeaderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("baseInformationHeader")
public class BaseInformationHeaderController {

    @Autowired
    private IBaseInformationHeaderService iBaseInformationHeaderService;

    @GetMapping(value = "/load/{id}")
    public BaseInformationHeaderViewModel load(@PathVariable String id) {
        return ModelMapperUtil.map(iBaseInformationHeaderService.load(id), BaseInformationHeaderViewModel.class);
    }


    @GetMapping(value = "/loadByTitle")
    public BaseInformationHeaderViewModel loadByTitle(@RequestParam String title) {
        return ModelMapperUtil.map(iBaseInformationHeaderService.loadByTitle(title), BaseInformationHeaderViewModel.class);
    }

    @GetMapping(value = "/grid")
    public Page<BaseInformationHeaderViewModel> page(Pageable pageable, String topic) {
        return ModelMapperUtil.mapPage(iBaseInformationHeaderService.getAllGrid(pageable, topic), BaseInformationHeaderViewModel.class);
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody BaseInformationHeaderViewModel entity) {
        return iBaseInformationHeaderService.save(ModelMapperUtil.map(entity, BaseInformationHeader.class));
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return iBaseInformationHeaderService.deleteById(id);
    }

}
