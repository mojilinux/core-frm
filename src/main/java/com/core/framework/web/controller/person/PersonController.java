package com.core.framework.web.controller.person;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.person.Person;
import com.core.framework.service.person.IPersonService;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.action.ActionViewModel;
import com.core.framework.web.viewModel.person.PersonViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController {
    @Autowired
    private IPersonService iPersonService;

    @GetMapping(value = "/grid")
    public Page<PersonViewModel> pagination(Pageable pageable) {
        return ModelMapperUtil.mapPage(iPersonService.getAllGrid(pageable), PersonViewModel.class);
    }

    @GetMapping(value = "/list")
    public List<PersonViewModel> list() {
        return ModelMapperUtil.mapList(iPersonService.getAll(), PersonViewModel.class);
    }

    @GetMapping(value = "/load/{id}")
    public PersonViewModel load(@PathVariable String id) {
        return ModelMapperUtil.map(iPersonService.load(id), PersonViewModel.class);
    }

    @GetMapping(value = "/loadByNationalCode/{nationalCode}")
    public PersonViewModel loadByNationalCode(@PathVariable String nationalCode) {
        return ModelMapperUtil.map(iPersonService.loadByNationalCode(nationalCode), PersonViewModel.class);
    }


    @PostMapping(value = "/save")
    public String save(@RequestBody PersonViewModel entity) {
        return iPersonService.save(ModelMapperUtil.map(entity, Person.class));
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return iPersonService.deleteById(id);
    }

}
