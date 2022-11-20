package com.lami.framework.web.controller.user;

import com.lami.framework.common.mapping.ModelMapperUtil;
import com.lami.framework.domain.user.User;
import com.lami.framework.service.user.IUserService;
import com.lami.framework.web.controller.BaseController;
import com.lami.framework.web.viewModel.user.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private IUserService iUserService;

	@GetMapping(value = "/load/{id}")
	public UserViewModel load(@PathVariable Long id) {
		return ModelMapperUtil.map(iUserService.load(id), UserViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<UserViewModel> list() {
		return ModelMapperUtil.mapList(iUserService.getAll(), UserViewModel.class);
	}

	@PostMapping(value = "/save")
	public Long getUser(@RequestBody UserViewModel entity) {
		return iUserService.save(ModelMapperUtil.map(entity, User.class));
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return iUserService.deleteById(id);
	}

}
