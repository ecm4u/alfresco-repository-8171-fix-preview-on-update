/**
 * Copyright (C) 2015 - 2023 ecm4u GmbH <https://www.ecm4u.de>
 *
 * This file is part of ecm4u's Alfresco Virtual Appliance Patches
 *
 * ecm4u's Alfresco Virtual Appliance Patches are free software: you can 
 * redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, 
 * either version 3 of the License, or (at your option) any later version.
 *
 * ecm4u's Alfresco Virtual Appliance Patches are distributed in the hope
 * that they will be useful, but WITHOUT ANY WARRANTY; without even the 
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco Virtual Appliance Patches. If not, see
 * <http://www.gnu.org/licenses/>.
 *
 * Linked to Alfresco
 * Copyright (C) 2005 - 2023 Alfresco Software Limited.
 */

package de.ecm4u.alfresco.content.behavior;

import org.alfresco.repo.content.ContentServicePolicies;
import org.alfresco.repo.content.ContentServicePolicies.OnContentUpdatePolicy;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;

public class NodeRefExistsBehaviorWrapprer implements ContentServicePolicies.OnContentUpdatePolicy {

	private final ContentServicePolicies.OnContentUpdatePolicy delegate;
	private final NodeService nodeService;

	public NodeRefExistsBehaviorWrapprer(OnContentUpdatePolicy delegate, NodeService nodeService) {
		this.delegate = delegate;
		this.nodeService = nodeService;
	}

	public void onContentUpdate(NodeRef nodeRef, boolean newContent) {
		if (nodeService.exists(nodeRef)) {
			delegate.onContentUpdate(nodeRef, newContent);
		}
	}
}
