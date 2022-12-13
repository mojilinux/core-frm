package com.core.framework.web.controller.group;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.group.Group;
import com.core.framework.service.group.IGroupService;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.action.ActionViewModel;
import com.core.framework.web.viewModel.group.GroupViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
public class GroupController extends BaseController {
	@Autowired
	private IGroupService iGroupService;

	@GetMapping(value = "/load/{id}")
	public GroupViewModel load(@PathVariable String id) {
		return ModelMapperUtil.map(iGroupService.load(id), GroupViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<GroupViewModel> list() {
		return ModelMapperUtil.mapList(iGroupService.getAll(), GroupViewModel.class);
	}

	@PostMapping(value = "/save")
	public String save(@RequestBody ActionViewModel entity) {
		return iGroupService.save(ModelMapperUtil.map(entity, Group.class));
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return iGroupService.deleteById(id);
	}

}
