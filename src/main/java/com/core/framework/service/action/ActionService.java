package com.core.framework.service.action;

import com.core.framework.domain.action.Action;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.action.IActionRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService extends GenericService<Action, Long> implements IActionService {

    @Autowired
    private IActionRepository iActionRepository;

    @Override
    protected IGenericRepository<Action, Long> getGenericRepo() {
        return iActionRepository;
    }
}
