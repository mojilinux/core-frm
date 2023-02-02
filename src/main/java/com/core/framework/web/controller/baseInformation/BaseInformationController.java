package com.core.framework.web.controller.baseInformation;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.baseInformation.BaseInformation;
import com.core.framework.service.baseInformation.IBaseInformationService;
import com.core.framework.web.viewModel.baseInformation.BaseInformationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("baseInformation")
public class BaseInformationController {

    @Autowired
    private IBaseInformationService iBaseInformationService;

    @GetMapping(value = "/load/{id}")
    public BaseInformationViewModel load(@PathVariable String id) {
        return ModelMapperUtil.map(iBaseInformationService.load(id), BaseInformationViewModel.class);
    }

    @GetMapping(value = "/list")
    public List<BaseInformationViewModel> list() {
        return ModelMapperUtil.mapList(iBaseInformationService.getAll(), BaseInformationViewModel.class);
    }

    @GetMapping(value = "/rootListByHeaderId/{headerId}")
    public List<BaseInformationViewModel> rootList(@PathVariable String headerId) {
        return ModelMapperUtil.mapList(iBaseInformationService.rootListByHeaderId(headerId), BaseInformationViewModel.class);
    }

    @GetMapping(value = "/listByHeaderId/{headerId}")
    public List<BaseInformationViewModel> listByHeaderId(@PathVariable String headerId) {
        return ModelMapperUtil.mapList(iBaseInformationService.getAll(headerId), BaseInformationViewModel.class);
    }

    @GetMapping(value = "/listByMasterId/{id}")
    public List<BaseInformationViewModel> listByMasterId(@PathVariable String id) {
        return ModelMapperUtil.mapList(iBaseInformationService.listByMasterId(id), BaseInformationViewModel.class);
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody BaseInformationViewModel entity) {
        return iBaseInformationService.save(ModelMapperUtil.map(entity, BaseInformation.class));
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return iBaseInformationService.deleteById(id);
    }

}
