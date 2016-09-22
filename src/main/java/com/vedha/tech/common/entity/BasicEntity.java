package com.vedha.tech.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import com.vedha.tech.common.constants.ActionMode;


@MappedSuperclass
public abstract class BasicEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(updatable=false)
	@Getter @Setter
	private String createdBy;
	
	@Column(updatable=false)
	@Getter @Setter
	private Date creationDate;
	
	@Getter @Setter
	private String modifiedBy;
	
	@Getter @Setter
	private Date modificationDate;
	
	@Getter @Setter
	private String rcdStatus;
	
	@Getter @Setter
	private int versionNum;
	
	@Transient
	@Getter @Setter
	private String reasonCode;
		
	@Transient
	@Getter @Setter
	private ActionMode actionMode;
	
	@Transient
	@Getter @Setter
	private boolean auditFlag;
	
	@Transient
	@Getter @Setter
	private String processId;

	
}
