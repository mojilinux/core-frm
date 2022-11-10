package com.lami.framework.web.controller.group;

import com.lami.framework.common.mapping.ModelMapperUtil;
import com.lami.framework.domain.group.Group;
import com.lami.framework.service.action.IActionService;
import com.lami.framework.service.group.IGroupService;
import com.lami.framework.web.controller.BaseController;
import com.lami.framework.web.viewModel.action.ActionViewModel;
import com.lami.framework.web.viewModel.group.GroupViewModel;
import com.lami.framework.web.viewModel.user.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
public class GroupController extends BaseController {
	@Autowired
	private IGroupService iGroupService;

	@GetMapping(value = "/load/{id}")
	public GroupViewModel load(@PathVariable Long id) {
		return ModelMapperUtil.map(iGroupService.load(id), GroupViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<GroupViewModel> list() {
		return ModelMapperUtil.mapList(iGroupService.getAll(), GroupViewModel.class);
	}

	@PostMapping(value = "/save")
	public Long getUser(@RequestBody ActionViewModel entity) {
		return iGroupService.save(ModelMapperUtil.map(entity, Group.class));
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return iGroupService.deleteById(id);
	}

}
