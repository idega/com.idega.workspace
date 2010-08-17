/*
 * $Id: WorkspacePageTag.java,v 1.6 2006/04/09 11:45:30 laddi Exp $
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
import com.idega.util.StringUtil;

/**
 * JSP tag for Workspace
 * <p>
 * Last modified: $Date: 2006/04/09 11:45:30 $ by $Author: laddi $
 *
 * @author tryggvil
 * @version $Revision: 1.6 $
 */
public class WorkspacePageTag extends PageTag {

	private String layout;
	private String showFunctionMenu;

	@Override
	public String getRendererType() {
		return null;
	}

	@Override
	public String getComponentType() {
		return "WorkspacePage";
	}

	@Override
	protected void setProperties(UIComponent component) {
		super.setProperties(component);

		if (component instanceof WorkspacePage) {
			WorkspacePage page = (WorkspacePage) component;

			page.setLayout(getLayout());
			if (StringUtil.isEmpty(getShowFunctionMenu())) {
				setShowFunctionMenu(Boolean.TRUE.toString());
			}
			page.setShowFunctionMenu(Boolean.valueOf(getShowFunctionMenu()));
		}
	}

	@Override
	public void release() {
		super.release();

		layout = null;
		showFunctionMenu = null;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getShowFunctionMenu() {
		return showFunctionMenu;
	}

	public void setShowFunctionMenu(String showFunctionMenu) {
		this.showFunctionMenu = showFunctionMenu;
	}
}