package com.core.framework.web.controller.userGroup;

import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.userGroup.UserGroup;
import com.core.framework.service.userGroup.IUserGroupService;
import com.core.framework.web.controller.BaseController;
import com.core.framework.web.viewModel.user.LiteUserViewModel;
import com.core.framework.web.viewModel.user.UserViewModel;
import com.core.framework.web.viewModel.userGroup.UserGroupViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping(value = "/grid")
    public Page<UserGroupViewModel> pagination(Pageable pageable) {
        return ModelMapperUtil.mapPage(iUserGroupService.getAllGrid(pageable), UserGroupViewModel.class);
    }

    @GetMapping(value = "/getAllByGroupId/{groupId}")
    public List<UserGroupViewModel> getAllByGroupId(@PathVariable String groupId) {
        return ModelMapperUtil.mapList(iUserGroupService.getAllByGroupId(groupId), UserGroupViewModel.class);
    }

    @GetMapping(value = "/getAllOutsideUsers/{groupId}")
    public List<LiteUserViewModel> getAllOutsideUsers(@PathVariable String groupId) {
        return ModelMapperUtil.mapList(iUserGroupService.getAllOutsideUsers(groupId), LiteUserViewModel.class);
    }


    @GetMapping(value = "/list/{userId}")
    public List<UserGroupViewModel> userGroups(@PathVariable String userId) {
        return ModelMapperUtil.mapList(iUserGroupService.loadByUser(userId), UserGroupViewModel.class);
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody UserGroupViewModel entity) {
        return iUserGroupService.save(ModelMapperUtil.map(entity, UserGroup.class));
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return iUserGroupService.deleteById(id);
    }

}
