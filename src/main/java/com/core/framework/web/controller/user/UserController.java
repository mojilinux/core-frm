package com.core.framework.web.controller.user;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.user.User;
import com.core.framework.service.user.IUserService;
import com.core.framework.utils.SecurityUtil;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.user.AuthenticatedUserViewModel;
import com.core.framework.web.viewModel.user.LiteUserViewModel;
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
    public LiteUserViewModel load(@PathVariable String id) {
        return ModelMapperUtil.map(iUserService.load(id), LiteUserViewModel.class);
    }

    @GetMapping(value = "/loadAllInfo/{id}")
    public UserViewModel loadAllInfo(@PathVariable String id) {
        return ModelMapperUtil.map(iUserService.load(id), UserViewModel.class);
    }

    @GetMapping(value = "/list")
    public List<LiteUserViewModel> list() {
        return ModelMapperUtil.mapList(iUserService.getAll(), LiteUserViewModel.class);
    }

    @GetMapping(value = "/grid")
    public Page<LiteUserViewModel> page(Pageable pageable) {
        return ModelMapperUtil.mapPage(iUserService.getAllGrid(pageable), LiteUserViewModel.class);
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public String save(@RequestBody UserViewModel entity) {
        return iUserService.save(ModelMapperUtil.map(entity, User.class));
    }

    @PostMapping(value = "/signUp")
    @ResponseBody
    public String signUp(@RequestBody UserViewModel entity) {
        return iUserService.signUp(entity);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return iUserService.deleteById(id);
    }

    @GetMapping(value = "/unLock/{id}")
    public boolean unLock(@PathVariable String id) {
        return iUserService.unLock(id);
    }

    @GetMapping(value = "/authenticated/authorities")
    public List<String> authenticatedUserAuthoritiesList() {
        return iUserService.authenticatedUserAuthoritiesList();
    }

    @GetMapping(value = "/authenticated/info")
    public AuthenticatedUserViewModel authenticatedUserDetails() {
        AuthenticatedUserViewModel authenticatedUser = ModelMapperUtil.map(SecurityUtil.getAuthenticatedUser(), AuthenticatedUserViewModel.class);
        authenticatedUser.setAuthorities(iUserService.authenticatedUserAuthoritiesList());
        return authenticatedUser;
    }

    @GetMapping(value = "/checkUserNameExists/{username}")
    public boolean checkUserNameExists(@PathVariable String username) {
        return iUserService.checkUserNameExists(username);
    }
}
