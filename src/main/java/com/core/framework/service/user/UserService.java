package com.core.framework.service.user;

import com.core.framework.common.exception.ApplicationException;
import com.core.framework.common.mapping.ModelMapperUtil;
import com.core.framework.domain.action.Action;
import com.core.framework.domain.group.Group;
import com.core.framework.domain.person.Person;
import com.core.framework.domain.user.User;
import com.core.framework.domain.user.UserMapper;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.user.IUserRepository;
import com.core.framework.service.GenericService;
import com.core.framework.service.actionGroup.IActionGroupService;
import com.core.framework.service.person.IPersonService;
import com.core.framework.service.userGroup.IUserGroupService;
import com.core.framework.utils.HashUtil;
import com.core.framework.utils.SecurityUtil;
import com.core.framework.web.viewModel.user.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService extends GenericService<User, String> implements IUserService, UserDetailsService {

	@Autowired
	private IUserRepository iUserRepository;

	@Autowired
	private IUserGroupService iUserGroupService;

	@Autowired
	private IActionGroupService iActionGroupService;

	@Autowired
	private IPersonService iPersonService;

	@Override
	protected IGenericRepository<User, String> getGenericRepo() {
		return iUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = iUserRepository.findByUserName(username);
		if (user == null) {
			throw new ApplicationException("Incorrect Credentials", 401);
		}
		List<Group> groups = iUserGroupService.loadByUser(user.getId());
		List<Action> actionsList = new ArrayList<>();
		groups.forEach(g -> {
			List<Action> actions = iActionGroupService.loadActionsByGroup(g.getId());
			actionsList.addAll(actions);
		});
		Set<Action> set = new HashSet<>(actionsList);
		actionsList.clear();
		actionsList.addAll(set);
		user.setActions(actionsList);
		return UserMapper.userToPrincipal(user);
	}

	@Override
	public UserDetails loadUserByUsernameForAuthenticate(String username) throws UsernameNotFoundException {
		User user = iUserRepository.findByUserName(username);
		if (user == null) {
			throw new ApplicationException("Incorrect Credentials", 401);
		}
		if (!user.isActivated()) {
			throw new ApplicationException("User " + username + " was not activated", 401);
		}
		if (user.isLock()) {
			throw new ApplicationException("User " + username + " Locked.", 401);
		}
		List<Group> groups = iUserGroupService.loadByUser(user.getId());
		List<Action> actionsList = new ArrayList<>();
		groups.forEach(g -> {
			List<Action> actions = iActionGroupService.loadActionsByGroup(g.getId());
			actionsList.addAll(actions);
		});
		Set<Action> set = new HashSet<>(actionsList);
		actionsList.clear();
		actionsList.addAll(set);
		user.setActions(actionsList);
		return UserMapper.userToPrincipal(user);
	}

	@Override
	public List<String> authenticatedUserAuthoritiesList() {
		List<String> authorities = new ArrayList<>();
		SecurityUtil.getAuthenticatedUserAuthorities().forEach(a -> {
			authorities.add(a.getAuthority());
		});
		return authorities;
	}

	@Override
	public List<String> authenticatedUserRoles() {
		return SecurityUtil.getAuthenticatedUserRoles().stream().map(r -> r.name()).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public String save(User user) {
		if (user.getId() == null) {
			user.setPassword(HashUtil.hashPassword(user.getPassword()));
		}
		else {
			User currentUser = iUserRepository.findById(user.getId()).get();
			user.setPassword(currentUser.getPassword());
		}

		user.getRoles().forEach(r -> {
			if (!SecurityUtil.hasCurrentUserThisAuthority(r.name())) {
				throw new ApplicationException("دسترسی غیر مجاز به نقش");
			}
		});
		return super.save(user);
	}

	@Transactional
	@Override
	public String signUp(UserViewModel entity) {
		User user = ModelMapperUtil.map(entity, User.class);
		if (user.getId() == null) {
			user.setPassword(HashUtil.hashPassword(entity.getPassword()));
			Person person = new Person();
			person.setFirstName(entity.getFirstName());
			person.setLastName(entity.getLastName());
			String entityId = iPersonService.save(person);
			person.setId(entityId);
			user.setPerson(person);
		}
		return super.save(user);
	}

	@Override
	@Transactional
	public boolean unLock(String id) {
		User user = iUserRepository.findById(id).get();
		user.setLock(false);
		super.save(user);
		return true;
	}

	@Override
	public boolean checkUserNameExists(String username) {
		User suggestUserName = iUserRepository.findByUserName(username);
		if (suggestUserName == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
