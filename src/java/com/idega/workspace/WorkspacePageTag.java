/*
 * $Id: WorkspacePageTag.java,v 1.1 2005/01/26 19:15:14 tryggvil Exp $
 *
 * Copyright (C) 2004 Idega. All Rights Reserved.
 *
 * This software is the proprietary information of Idega.
 * Use is subject to license terms.
 *
 */
package com.idega.workspace;

import javax.faces.webapp.UIComponentTag;

/**
 * JSP tag for Workspace
 * <p>
 * Last modified: $Date: 2005/01/26 19:15:14 $ by $Author: tryggvil $
 *
 * @author tryggvil
 * @version $Revision: 1.1 $
 */
public class WorkspacePageTag extends UIComponentTag {
	
	/**
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	public String getRendererType() {
		return null;
	}
		
	/**
	 * @see javax.faces.webapp.UIComponentTag#getComponentType()
	 */
	public String getComponentType() {
		return "WorkspacePage";
	}
}
