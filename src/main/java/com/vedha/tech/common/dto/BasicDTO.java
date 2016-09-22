package com.vedha.tech.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.constants.Permit;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public abstract class BasicDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private String createdBy;
	
	@Getter @Setter
	private Date creationDate;
	
	@Getter @Setter
	private String modifiedBy;
	
	@Getter @Setter
	private Date modificationDate;
	
	@Getter @Setter
	private String rcdStatus;
	
	@Getter @Setter
	private String reasonCode;
	
	@Getter @Setter
	private int versionNum;
	
	@Getter @Setter
	private ActionMode actionMode;
	
	
	
	
}
