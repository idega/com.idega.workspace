/*
 * Created on 6.8.2004
 *
 * Copyright (C) 2004 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.workspace;

import java.io.Serializable;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.idega.block.login.presentation.Login2;
import com.idega.core.view.KeyboardShortcut;
import com.idega.core.view.ViewManager;
import com.idega.core.view.ViewNode;
import com.idega.idegaweb.IWMainApplication;
import com.idega.presentation.IWContext;
import com.idega.presentation.text.Text;
import com.idega.webface.WFContainer;
import com.idega.webface.WFMenu;
import com.idega.webface.WFTabBar;
import com.idega.webface.WFUtil;
import com.idega.webface.event.WFTabEvent;


/**
 * This class holds a "tab" or "task" style bar in the Workspace environment for 
 * all available applications/perspectives for a user.
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version 1.0
 */
public class WorkspaceBar extends WFContainer implements  Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 3257572806178189623L;

	private final static String P = "cms_page_"; // Parameter prefix
	
	private final static String MAIN_TASKBAR_ID = P + "main_taskbar";
	public static String MAIN_STYLE_CLASS="ws_mainbar";
	public static String MAIN_NAVIGATION_STYLE_CLASS="ws_mainnavigation";
	public static String LOGIN_STYLE_CLASS="ws_smallloginbox";
	public static String APP_DECORATION_STYLE_CLASS="ws_appdecor";
	public static String APP_INFO_STYLE_CLASS="ws_appinfo";
	
	/**
	 * 
	 */
	public WorkspaceBar() {
		super();
	}
	
	public void initializeComponent(FacesContext context){
		setStyleClass(MAIN_STYLE_CLASS);
		addApplicationDecoration();
		UIComponent login = getLogin();
		add(login);
		addApplicationInstallationInfo();
		addTabbar();
	}

	/**
	 * 
	 */
	private UIComponent getLogin() {
		WFContainer div = new WFContainer();
		div.setStyleClass(LOGIN_STYLE_CLASS);
		
		Login2 login = new Login2();
		//login.setLayout(Login.SINGLE_LINE);
		//login.setNoStyles();
		
		div.getChildren().add(login);
		
		return div;
		//WFLogin login = new WFLogin();
		//login.setHeight("60");
		//login.setWidth("70");
		//login.setAllowCookieLogin(true);
		//login.setLayoutSingleLine();
		
		//this.add(login);
	}

	/**
	 * 
	 */
	private UIComponent addTabbar() {
		WFMenu bar = getMainTaskbar();
		add(bar);
		return bar;
	}

	/**
	 * 
	 */
	private UIComponent addApplicationDecoration() {
		WFContainer div = new WFContainer();
		div.setStyleClass(APP_DECORATION_STYLE_CLASS);
		add(div);
		return div;
//		WFPlainOutputText text = new WFPlainOutputText();
//		text.setValue("<i>e</i>Platform");
//		div.add(text);
	}

	
	private UIComponent addApplicationInstallationInfo() {
		WFContainer div = new WFContainer();
		div.setStyleClass(APP_INFO_STYLE_CLASS);
		
		HtmlOutputText text = new HtmlOutputText();
		String infoString = IWMainApplication.getDefaultIWApplicationContext().getDomain().getName();
		text.setValue(infoString);
		div.getChildren().add(text);
				
		add(div);
		return div;
//		WFPlainOutputText text = new WFPlainOutputText();
//		text.setValue("<i>e</i>Platform");
//		div.add(text);
	}



	/**
	 * Returns the main task bar selector. 
	 */
	protected WFMenu getMainTaskbar() {

		WFTabBar tb = new WFTabBar();
		tb.setId(MAIN_TASKBAR_ID);
		tb.setStyleClass(MAIN_NAVIGATION_STYLE_CLASS);
		//tb.setMenuStyleClass("ws_mainnavigation");
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		ViewManager viewManager = ViewManager.getInstance(context);
		
		ViewNode workspaceNode = viewManager.getWorkspaceRoot();
//		IWMainApplication iwma = IWMainApplication.getIWMainApplication(context);
		
		for (Iterator iter = workspaceNode.getChildren().iterator(); iter.hasNext();) {
			ViewNode subNode = (ViewNode) iter.next();
			if(maySeeNode(context,subNode)){
				String url = subNode.getURIWithContextPath();
				HtmlOutputLink link =  tb.addLink(subNode.getName(),url);
				
				//Add a shortcut key if the view node has one
				KeyboardShortcut shortCut = subNode.getKeyboardShortcut();
				if(shortCut!=null){
					link.setAccesskey(shortCut.getActionKey());
				}
			}
		}
		
		return tb;
	}
	
	protected boolean maySeeNode(FacesContext context,ViewNode node){
		boolean isRendered = node.isVisibleInMenus();
		if(isRendered){
			IWContext iwc = IWContext.getIWContext(context);
			return ViewManager.getInstance(context).hasUserAccess(node,iwc);
		}
		else{
			return false;
		}
	}
	
	/**
	 * Returns the content admin perspective.
	 */
	protected UIComponent getContentPerspective() {
		UIComponent perspective = new Text("Content");
		return perspective;
	}

	/**
	 * Returns the content admin perspective.
	 */
	protected UIComponent getWebViewPerspective() {
		UIComponent perspective = new Text("Webview");
		return perspective;
	}

	/**
	 * Returns the content admin perspective.
	 */
	protected UIComponent getBuilderPerspective() {
		UIComponent perspective = new Text("Builder");
		return perspective;
	}	
	
	
	/**
	 * Called when the edit mode in the article block changes.
	 * @see com.idega.webface.event.WFTabListener#taskbarButtonPressed() 
	 */
	public void tabPressed(WFTabEvent e) {
		e.getTabbedPane();
		/*UIComponent articleVersionBlock = t.findComponent(ArticleVersionBlock.ARTICLE_VERSION_BLOCK_ID);
		if (t.getSelectedButtonId().equals(ArticleBlock.TASK_ID_PREVIEW)) {
			articleVersionBlock.setRendered(true);
		} else {
			articleVersionBlock.setRendered(false);			
		}*/
	}

	
	/**
	 * @see javax.faces.event.ActionListener#processAction(javax.faces.event.ActionEvent)
	 */
	public void processAction(ActionEvent event) {
		UIComponent link = event.getComponent();
		WFUtil.getParameter(link, "id");
		/*WFTabBar tb = (WFTabBar) link.getParent().getParent().getParent().findComponent(MAIN_TASKBAR_ID);
		tb.setSelectedButtonId(TASK_ID_EDIT);
		ArticleBlock ab = (ArticleBlock) tb.findComponent(ArticleBlock.ARTICLE_BLOCK_ID);
		ab.setEditMode();

		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "clear");
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setLocaleId", "sv");
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setHeadline", "headline");
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setBody", id);
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setAuthor", "author");
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setComment", "comment");
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setDescription", "description");
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setSource", "source");
		if (link.getId().equals(ArticleListBean.ARTICLE_ID)) {
			WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setStatus", ContentItemCase.STATUS_PUBLISHED);
		} else {
			WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setStatus", ContentItemCase.STATUS_UNDER_REVIEW);
		}
		WFUtil.invoke(ARTICLE_ITEM_BEAN_ID, "setMainCategoryId", new Integer(3));

		ab.updateEditButtons();*/
	}
		

}