package com.core.framework.web.controller.action;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.action.Action;
import com.core.framework.service.action.IActionService;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.action.ActionViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("action")
public class ActionController extends BaseController {

    @Autowired
    private IActionService iActionService;

    @GetMapping(value = "/load/{id}")
    public ActionViewModel load(@PathVariable String id) {
        return ModelMapperUtil.map(iActionService.load(id), ActionViewModel.class);
    }

    @GetMapping(value = "/list")
    public List<ActionViewModel> list() {
        return ModelMapperUtil.mapList(iActionService.getAll(), ActionViewModel.class);
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody ActionViewModel entity) {
        return iActionService.save(ModelMapperUtil.map(entity, Action.class));
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return iActionService.deleteById(id);
    }

}
