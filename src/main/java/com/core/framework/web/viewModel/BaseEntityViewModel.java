package com.core.framework.web.viewModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public abstract class BaseEntityViewModel<T> implements Serializable {
    private static final long serialVersionUID = 4295229462159851306L;
    private T id;
    private String ip = "127.0.0.1";
    private Integer version;
    private Date createdDate;
    private Date updatedDate;
    private String createdDateShamsi;
    private String updateDateShamsi;

    public BaseEntityViewModel() {
    }

    public BaseEntityViewModel(T id) {
        this.id = id;
    }
}
