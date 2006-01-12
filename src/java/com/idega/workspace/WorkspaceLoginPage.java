/*
 * $Id: WorkspaceLoginPage.java,v 1.9 2006/01/12 15:33:13 tryggvil Exp $ Created on 13.7.2004
 * in project com.idega.core
 * 
 * Copyright (C) 2004-2005 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to
 * license terms.
 */
package com.idega.workspace;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import com.idega.block.login.presentation.Login;
import com.idega.idegaweb.IWMainApplication;
import com.idega.presentation.IWContext;
import com.idega.presentation.Page;
import com.idega.presentation.Table;
import com.idega.servlet.filter.IWAuthenticator;
import com.idega.webface.WFBezel;
import com.idega.webface.WFContainer;
import com.idega.webface.WFUtil;

/**
 * <p>
 * This is the component for the default login page in the idegaWeb Workspace.
 * </p>
 * Last modified: $Date: 2006/01/12 15:33:13 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">Tryggvi Larusson</a>
 * @version $Revision: 1.9 $
 */
public class WorkspaceLoginPage extends Page {
	private final static String IW_BUNDLE_IDENTIFIER = "com.idega.webface";

	String backgroundColor = "#B0B29D";

	public WorkspaceLoginPage() {
		setTransient(false);
	}
	public String getBundleIdentifier() {
		return IW_BUNDLE_IDENTIFIER;
	}
	//public void main(IWContext iwc) {
	public void initializeContent(FacesContext context){
		IWContext iwc = IWContext.getIWContext(context);

		IWMainApplication iwma = iwc.getIWMainApplication();
		Page thePage = this;
		String productName = iwma.getProductInfo().getFullProductName();
		thePage.setTitle(productName);
		thePage.setStyleClass("ws_loginpage");

		Table pageTable = new Table(1, 1);	
		pageTable.setWidth("100%");
		pageTable.setHeight("100%");
		pageTable.setCellpadding(0);
		pageTable.setCellspacing(0);
		pageTable.setAlignment(1, 1, "center");
		pageTable.setVerticalAlignment(1, 1, "middle");
		add(pageTable);
		
		WFBezel loginBox = new WFBezel();
		loginBox.setStyleClass("ws_mainloginbox");
		
		//This is a hack to make form elements respond in IE with a transparent IE
		WFContainer ieHack = new WFContainer();
		ieHack.setStyleClass("iehack");
		ieHack.setStyleAttribute("position","relative");
		ieHack.setStyleAttribute("margin","0");
		ieHack.setStyleAttribute("padding","0");
		loginBox.add(ieHack);
		pageTable.add(loginBox);
		

		boolean isLoggedOn = false;
		try {
			isLoggedOn = iwc.isLoggedOn();
		}
		catch (Exception e) {
			isLoggedOn = false;
		}

		if (isLoggedOn) {
			//commented out this is now a security hole:
			//IWControlCenter iwcc = new IWControlCenter();
			//loginBox.add(iwcc);
		}	
			//WFLogin login = new WFLogin();
			Login login = new Login();
			login.setAllowCookieLogin(true);
			login.setUseRegularButton();
			login.setNoStyles();
			login.setHeight("60");
			login.setWidth("70");
			
			String redirectUri = iwc.getParameter(IWAuthenticator.PARAMETER_REDIRECT_URI_ONLOGON);
			String loginUri=null;
			
			if(redirectUri!=null&&!redirectUri.equals("")){
				loginUri=redirectUri;
			}
			else{
				loginUri=iwma.getWorkspaceURI();
			}
			
			//login.setAllowCookieLogin(true);
			login.setUrlToForwardToOnLogin(loginUri);
			
			loginBox.add(login);


		loginBox.add(getProductName());
		loginBox.add(getVersionInfo());
		loginBox.add(getBuildId());
		loginBox.add(getCopyrightText());
		
	}

	
	protected UIComponent getVersionInfo(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("versioninfo");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.version");
		cText.add(tText);
		return cText;
	}
	
	protected UIComponent getProductName(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("productinfo");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.fullProductName");
		cText.add(tText);
		return cText;
	}
	
	protected UIComponent getBuildId(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("buildid");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.buildId");
		cText.add(tText);
		return cText;
	}

	protected UIComponent getCopyrightText(){
		WFContainer cText = new WFContainer();
		cText.setStyleClass("copyrighttext");
		HtmlOutputText tText = WFUtil.getTextVB(IWMainApplication.APPLICATION_BEAN_ID+".productInfo.copyrightText");
		cText.add(tText);
		return cText;
	}		
	
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponent#encodeBegin(javax.faces.context.FacesContext)
	 */
	public void encodeBegin(FacesContext context) throws IOException {
		if(!isInitalized()){
			initializeContent(context);
			setInitialized(true);
		}
		
		super.encodeBegin(context);
	}
	/**
	 * <p>
	 * TODO tryggvil describe method setInitialized
	 * </p>
	 * @param b
	 */
	private void setInitialized(boolean b) {
		getAttributes().put("initialized",Boolean.valueOf(b));
	}
	/**
	 * <p>
	 * TODO tryggvil describe method isInitalized
	 * </p>
	 * @return
	 */
	private boolean isInitalized() {
		Boolean b = (Boolean) getAttributes().get("initialized");
		if(b!=null){
			return b.booleanValue();
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponent#encodeChildren(javax.faces.context.FacesContext)
	 */
	public void encodeChildren(FacesContext context) throws IOException{
		super.encodeChildren(context);
	}
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponent#encodeEnd(javax.faces.context.FacesContext)
	 */
	public void encodeEnd(FacesContext context) throws IOException {
		super.encodeEnd(context);
	}
}