package com.core.framework.service.user;

import com.core.framework.domain.user.User;
import com.core.framework.service.IGenericService;
import com.core.framework.web.viewModel.user.ChangePasswordDto;
import com.core.framework.web.viewModel.user.UserViewModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUserService extends IGenericService<User, String> {
    UserDetails loadUserByUsername(String username);

    UserDetails loadUserByUsernameForAuthenticate(String username) throws UsernameNotFoundException;

    List<String> authenticatedUserAuthoritiesList();

	List<String> authenticatedUserRoles();

	String save(User user);
    String signUp(UserViewModel userViewModel);

    boolean unLock(String id);

    boolean checkUserNameExists(String username);

    boolean changePassword(ChangePasswordDto  changePasswordDto);
}
