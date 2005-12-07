/*
 * $Id: WorkspaceFunctionMenu.java,v 1.12 2005/12/07 21:39:23 tryggvil Exp $
 * Created on 2.11.2004
 *
 * Copyright (C) 2004 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.workspace;

import java.util.Iterator;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.FacesContext;
import com.idega.core.view.KeyboardShortcut;
import com.idega.core.view.ViewManager;
import com.idega.core.view.ViewNode;
import com.idega.presentation.IWContext;
import com.idega.webface.WFBlock;
import com.idega.webface.WFLinkMenu;
import com.idega.webface.WFVerticalMenu;


/**
 * This class holds a "function menu" in the workspace environment for the current selected tab.
 * This menu is usually displayd to the left on the page.
 *  Last modified: $Date: 2005/12/07 21:39:23 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">Tryggvi Larusson</a>
 * @version $Revision: 1.12 $
 */
public class WorkspaceFunctionMenu extends WFBlock {

	/**
	 * 
	 */
	public WorkspaceFunctionMenu() {
		this("#{localizedStrings['com.idega.workspace']['functions']}");
	}

	/**
	 * @param titleBarText
	 */
	public WorkspaceFunctionMenu(String titleBarText) {
		super(titleBarText);
		this.setNoMarginsOnMainArea();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see com.idega.webface.WFBlock#initializeContent()
	 */
	protected void initializeComponent(FacesContext context) {

		ViewManager viewmanager = ViewManager.getInstance(context);
		
		ViewNode workspace = viewmanager.getWorkspaceRoot();
		ViewNode node = workspace.getChild(getApplication());
		
		
		WFVerticalMenu menu = new WFVerticalMenu();
		String menuId = menu.getId();
		if(menuId==null){
			menu.setId(this.getId()+"menu1");
		}
		
		add(menu);
	
		populateMenu(menu,node);
	}
	
	public void setApplication(String application){
		this.getAttributes().put("application_menu",application);
	}
	
	public String getApplication(){
		return (String)getAttributes().get("application_menu");
	}
	
	public void populateMenu(WFLinkMenu menu,ViewNode node){
		FacesContext context = FacesContext.getCurrentInstance();
		for (Iterator iter = node.getChildren().iterator(); iter.hasNext();) {
			ViewNode childNode = (ViewNode) iter.next();
			if(maySeeNode(context,childNode)){
				if(childNode.getChildren().size()>0){
					WFVerticalMenu subMenu = new WFVerticalMenu();
					HtmlOutputLink link = subMenu.setMenuHeader(childNode.getName(),childNode.getURIWithContextPath());
					//Add a shortcut key if the view node has one
					KeyboardShortcut shortCut = childNode.getKeyboardShortcut();
					if(shortCut!=null){
						link.setAccesskey(shortCut.getActionKey());
					}
					
					menu.addMenuItem(subMenu);
					
					populateMenu(subMenu,childNode);
					
				}
				else{
					String url = childNode.getURIWithContextPath();
					String name = childNode.getName();
					HtmlOutputLink link =  menu.addLink(name,url);
					
					//Add a shortcut key if the view node has one
					KeyboardShortcut shortCut = childNode.getKeyboardShortcut();
					if(shortCut!=null){
						link.setAccesskey(shortCut.getActionKey());
					}
				}
			}
		}
	}
	
	protected boolean maySeeNode(FacesContext context,ViewNode node){
		boolean isRendered = node.isVisibleInMenus();
		if(isRendered){
			IWContext iwc = IWContext.getIWContext(context);
			return ViewManager.getInstance(context).hasUserAcess(node,iwc);
		}
		else{
			return false;
		}
	}
}
