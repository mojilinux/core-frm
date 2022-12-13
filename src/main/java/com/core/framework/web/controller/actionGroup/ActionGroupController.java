package com.core.framework.web.controller.actionGroup;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.actionGroup.ActionGroup;
import com.core.framework.service.actionGroup.IActionGroupService;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.actionGroup.ActionGroupViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actionGroup")
public class ActionGroupController extends BaseController {
	@Autowired
	private IActionGroupService iActionGroupService;

	@GetMapping(value = "/load/{id}")
	public ActionGroupViewModel load(@PathVariable String id) {
		return ModelMapperUtil.map(iActionGroupService.load(id), ActionGroupViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<ActionGroupViewModel> list() {
		return ModelMapperUtil.mapList(iActionGroupService.getAll(), ActionGroupViewModel.class);
	}

	@GetMapping(value = "/list/{groupId}")
	public List<ActionGroupViewModel> userGroups(@PathVariable String groupId) {
		return ModelMapperUtil.mapList(iActionGroupService.loadActionsByGroup(groupId), ActionGroupViewModel.class);
	}


	@PostMapping(value = "/save")
	public String save(@RequestBody ActionGroupViewModel entity) {
		return iActionGroupService.save(ModelMapperUtil.map(entity, ActionGroup.class));
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return iActionGroupService.deleteById(id);
	}

}
