package com.core.framework.web.controller.userGroup;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.userGroup.UserGroup;
import com.core.framework.service.userGroup.IUserGroupService;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.userGroup.UserGroupViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userGroup")
public class UserGroupController extends BaseController {
	@Autowired
	private IUserGroupService iUserGroupService;

	@GetMapping(value = "/load/{id}")
	public UserGroupViewModel load(@PathVariable String id) {
		return ModelMapperUtil.map(iUserGroupService.load(id), UserGroupViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<UserGroupViewModel> list() {
		return ModelMapperUtil.mapList(iUserGroupService.getAll(), UserGroupViewModel.class);
	}

	@GetMapping(value = "/list/{userId}")
	public List<UserGroupViewModel> userGroups(@PathVariable String userId) {
		return ModelMapperUtil.mapList(iUserGroupService.loadByUser(userId), UserGroupViewModel.class);
	}


	@PostMapping(value = "/save")
	public String getUser(@RequestBody UserGroupViewModel entity) {
		return iUserGroupService.save(ModelMapperUtil.map(entity, UserGroup.class));
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return iUserGroupService.deleteById(id);
	}

}
