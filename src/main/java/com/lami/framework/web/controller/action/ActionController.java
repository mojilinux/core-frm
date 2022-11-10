package com.lami.framework.web.controller.action;

import com.lami.framework.common.mapping.ModelMapperUtil;
import com.lami.framework.domain.action.Action;
import com.lami.framework.service.action.IActionService;
import com.lami.framework.web.controller.BaseController;
import com.lami.framework.web.viewModel.action.ActionViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("action")
public class ActionController extends BaseController {

	@Autowired
	private IActionService iActionService;

	@GetMapping(value = "/load/{id}")
	public ActionViewModel load(@PathVariable Long id) {
		return ModelMapperUtil.map(iActionService.load(id), ActionViewModel.class);
	}

	@GetMapping(value = "/list")
	public List<ActionViewModel> list() {
		return ModelMapperUtil.mapList(iActionService.getAll(), ActionViewModel.class);
	}

	@PostMapping(value = "/save")
	public Long getUser(@RequestBody ActionViewModel entity) {
		return iActionService.save(ModelMapperUtil.map(entity, Action.class));
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return iActionService.deleteById(id);
	}

}
