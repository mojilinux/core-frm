package com.lami.framework.web.controller.actionGroup;

import com.lami.framework.common.mapping.ModelMapperUtil;
import com.lami.framework.domain.actionGroup.ActionGroup;
import com.lami.framework.service.actionGroup.IActionGroupService;
import com.lami.framework.web.controller.BaseController;
import com.lami.framework.web.viewModel.actionGroup.ActionGroupViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actionGroup")
public class ActionGroupController extends BaseController {
	@Autowired
	private IActionGroupService iActionGroupService;

	@GetMapping(value = "/load/{id}")
	public ActionGroupViewModel load(@PathVariable Long id) {
		return ModelMapperUtil.map(iActionGroupService.load(id), ActionGroupViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<ActionGroupViewModel> list() {
		return ModelMapperUtil.mapList(iActionGroupService.getAll(), ActionGroupViewModel.class);
	}

	@GetMapping(value = "/list/{groupId}")
	public List<ActionGroupViewModel> userGroups(@PathVariable Long groupId) {
		return ModelMapperUtil.mapList(iActionGroupService.loadActionsByGroup(groupId), ActionGroupViewModel.class);
	}


	@PostMapping(value = "/save")
	public Long getUser(@RequestBody ActionGroupViewModel entity) {
		return iActionGroupService.save(ModelMapperUtil.map(entity, ActionGroup.class));
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return iActionGroupService.deleteById(id);
	}

}
