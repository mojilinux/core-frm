package com.core.framework.domain.coreFile;

import com.core.framework.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;

@Getter
@Setter
@Entity
@Table(name = "APP_CORE_FILE")
@GenericGenerator(name = "sequence_db", strategy = "org.hibernate.id.UUIDGenerator")
public class CoreFile extends BaseEntity<String> {

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_CODE", nullable = false, unique = true)
    private String fileCode;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "ATTACHMENT")
    private Blob attachment;
}
