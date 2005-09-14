/*
 * $Id: WorkspacePageTag.java,v 1.3 2005/09/14 01:30:03 tryggvil Exp $
 *
 * Copyright (C) 2004 Idega. All Rights Reserved.
 *
 * This software is the proprietary information of Idega.
 * Use is subject to license terms.
 *
 */
package com.idega.workspace;

import javax.faces.component.UIComponent;
import com.idega.presentation.PageTag;

/**
 * JSP tag for Workspace
 * <p>
 * Last modified: $Date: 2005/09/14 01:30:03 $ by $Author: tryggvil $
 *
 * @author tryggvil
 * @version $Revision: 1.3 $
 */
public class WorkspacePageTag extends PageTag {
	
	String layout;
	
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
	
	
	/* (non-Javadoc)
	 * @see com.idega.presentation.PageTag#setProperties(javax.faces.component.UIComponent)
	 */
	protected void setProperties(UIComponent component) {
		// TODO Auto-generated method stub
		super.setProperties(component);
		WorkspacePage page = (WorkspacePage)component;
		if(layout!=null){
			page.setLayout(layout);
		}
	}

	public void setLayout(String layout){
		this.layout=layout;
	}
}
