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

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;

import com.idega.presentation.PageTag;

/**
 * JSP tag for Workspace
 * <p>
 * Last modified: $Date: 2006/04/09 11:45:30 $ by $Author: laddi $
 *
 * @author tryggvil
 * @version $Revision: 1.6 $
 */
public class WorkspacePageTag extends PageTag {

	private Object layout;
	private Object showFunctionMenu;

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

			String layout = getValue(this.layout);
			if (layout != null) {
				page.setLayout(layout);
			}

			Boolean showFunctionMenu = isShowFunctionMenu();
			if (showFunctionMenu == null) {
				showFunctionMenu = Boolean.TRUE;
				setShowFunctionMenu(showFunctionMenu);
			}
			page.setShowFunctionMenu(showFunctionMenu);
		}
	}

	@Override
	public void release() {
		super.release();

		layout = null;
		showFunctionMenu = null;
	}

	public Object getLayout() {
		return layout;
	}
	public void setLayout(Object layout) {
		this.layout = layout;
	}

	public Boolean isShowFunctionMenu() {
		if (showFunctionMenu == null) {
			return Boolean.TRUE;
		}

		if (showFunctionMenu instanceof ValueExpression) {
			return (Boolean) ((ValueExpression) showFunctionMenu).getValue(getELContext());
		} else if (showFunctionMenu instanceof Boolean) {
			return (Boolean) showFunctionMenu;
		} else if (showFunctionMenu instanceof String) {
			return Boolean.valueOf((String) showFunctionMenu);
		}

		return Boolean.TRUE;
	}

	public Object getShowFunctionMenu() {
		return showFunctionMenu;
	}
	public void setShowFunctionMenu(Object showFunctionMenu) {
		this.showFunctionMenu = showFunctionMenu;
	}
}