/*
 * $Id: WorkspacePageTag.java,v 1.2 2005/03/08 10:30:53 gimmi Exp $
 *
 * Copyright (C) 2004 Idega. All Rights Reserved.
 *
 * This software is the proprietary information of Idega.
 * Use is subject to license terms.
 *
 */
package com.idega.workspace;

import com.idega.presentation.PageTag;

/**
 * JSP tag for Workspace
 * <p>
 * Last modified: $Date: 2005/03/08 10:30:53 $ by $Author: gimmi $
 *
 * @author tryggvil
 * @version $Revision: 1.2 $
 */
public class WorkspacePageTag extends PageTag {
	
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
