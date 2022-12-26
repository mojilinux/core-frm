package com.core.framework.web.controller.user;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.user.User;
import com.core.framework.service.user.IUserService;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.user.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private IUserService iUserService;

	@GetMapping(value = "/load/{id}")
	public UserViewModel load(@PathVariable String id) {
		return ModelMapperUtil.map(iUserService.load(id), UserViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<UserViewModel> list() {
		return ModelMapperUtil.mapList(iUserService.getAll(), UserViewModel.class);
	}

	@GetMapping(value = "/grid")
	public Page<UserViewModel> page(Pageable pageable) {
		return ModelMapperUtil.mapPage(iUserService.getAllGrid(pageable), UserViewModel.class);
	}

	@PostMapping(value = "/save")
	@ResponseBody
	public String save(@RequestBody UserViewModel entity) {
		return iUserService.save(entity);
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return iUserService.deleteById(id);
	}

	@GetMapping(value = "/authenticated/authorities")
	public List<String> authenticatedUserAuthoritiesList() {
		return iUserService.authenticatedUserAuthoritiesList();
	}

}
