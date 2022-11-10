package com.lami.framework.repository.action;

import com.lami.framework.domain.action.Action;
import com.lami.framework.repository.IGenericRepository;
import org.springframework.data.repository.CrudRepository;

public interface IActionRepository extends IGenericRepository<Action, Long> {
}
