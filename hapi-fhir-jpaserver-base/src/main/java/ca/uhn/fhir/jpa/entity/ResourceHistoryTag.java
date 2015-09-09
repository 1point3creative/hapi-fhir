package ca.uhn.fhir.jpa.entity;

/*
 * #%L
 * HAPI FHIR JPA Server
 * %%
 * Copyright (C) 2014 - 2015 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HFJ_HISTORY_TAG")
public class ResourceHistoryTag extends BaseTag implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name = "PID")
	private Long myId;
	
	@ManyToOne()
	@JoinColumn(name="RES_VER_PID", referencedColumnName="PID", nullable=false)
	private ResourceHistoryTable myResourceHistory;

	@Column(name = "RES_TYPE", length = ResourceTable.RESTYPE_LEN, nullable=false)
	private String myResourceType;

	@Column(name="RES_ID", nullable=false)
	private Long myResourceId;

	public String getResourceType() {
		return myResourceType;
	}


	public void setResourceType(String theResourceType) {
		myResourceType = theResourceType;
	}


	public Long getResourceId() {
		return myResourceId;
	}


	public void setResourceId(Long theResourceId) {
		myResourceId = theResourceId;
	}


	public ResourceHistoryTag() {
	}
	

	public ResourceHistoryTag(ResourceHistoryTable theResourceHistoryTable, TagDefinition theTag) {
		setTag(theTag);
		setResource(theResourceHistoryTable);
		setResourceId(theResourceHistoryTable.getResourceId());
		setResourceType(theResourceHistoryTable.getResourceType());
	}

	public ResourceHistoryTable getResourceHistory() {
		return myResourceHistory;
	}

	public void setResource(ResourceHistoryTable theResourceHistory) {
		myResourceHistory = theResourceHistory;
	}

}
