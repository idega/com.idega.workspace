/*
 * $Id: WorkspaceLoginPage.java,v 1.16 2008/12/16 11:58:32 laddi Exp $
 * Created on 13.7.2004 in project com.idega.core
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

import com.idega.block.login.presentation.Login2;
import com.idega.block.login.presentation.LoginWithSMSCode;
import com.idega.idegaweb.IWMainApplication;
import com.idega.presentation.IWContext;
import com.idega.presentation.Page;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.ListItem;
import com.idega.presentation.text.Lists;
import com.idega.presentation.text.Text;
import com.idega.servlet.filter.IWAuthenticator;
import com.idega.util.StringUtil;
import com.idega.webface.WFBezel;
import com.idega.webface.WFContainer;

/**
 * <p>
 * This is the component for the default login page in the idegaWeb Workspace.
 * </p>
 * Last modified: $Date: 2008/12/16 11:58:32 $ by $Author: laddi $
 *
 * @author <a href="mailto:tryggvil@idega.com">Tryggvi Larusson</a>
 * @version $Revision: 1.16 $
 */
public class WorkspaceLoginPage extends Page {

	private final static String IW_BUNDLE_IDENTIFIER = "com.idega.webface";

	String backgroundColor = "#B0B29D";

	public WorkspaceLoginPage() {
		setTransient(false);
		setOnLoad("");
	}

	@Override
	public String getBundleIdentifier() {
		return IW_BUNDLE_IDENTIFIER;
	}

	// public void main(IWContext iwc) {
	public void initializeContent(FacesContext context) {
		IWContext iwc = IWContext.getIWContext(context);

		addNotifications(iwc);
		enableReverseAjax(iwc);
		enableChromeFrame(iwc);

		IWMainApplication iwma = iwc.getIWMainApplication();
		Page thePage = this;
		String productName = iwma.getProductInfo().getFullProductName();
		thePage.setTitle(productName);

		thePage.setStyleClass("ws_body loginpage");

		WFBezel outer = new WFBezel();
		outer.setStyleClass("ws_mainlogin_outer");

		WFBezel middle = new WFBezel();
		middle.setStyleClass("ws_mainlogin_middle");
		outer.add(middle);

		WFBezel loginBox = new WFBezel();
		loginBox.setStyleClass("ws_mainloginbox");
		middle.add(loginBox);

		add(outer);

		WFBezel middleBox = new WFBezel();
		middleBox.setStyleClass("ws_mainloginbox_middle");
		loginBox.add(middleBox);

		WFBezel logo = new WFBezel();
		logo.setStyleClass("logo");
		middleBox.add(logo);

		middleBox.add(getProductName(iwma));

		Login2 login = null;
		if (iwma.getSettings().getBoolean("login.two_steps_auth", false)) {
			login = new LoginWithSMSCode();
			String secondStepUI = iwma.getSettings().getProperty("login.second_step_ui");
			if (!StringUtil.isEmpty(secondStepUI)) {
				login.setSmsAuthenticationFaceletPath(secondStepUI);
			}
		} else {
			login = new Login2();
		}
		login.setEnterSubmits(true);
		login.setGenerateContainingForm(false);

		String redirectUri = iwc.getParameter(IWAuthenticator.PARAMETER_REDIRECT_URI_ONLOGON);
		String loginUri = null;

		if (redirectUri != null && !redirectUri.equals("")) {
			loginUri = redirectUri;
		}
		else {
			loginUri = iwma.getWorkspaceURI();
		}

		login.setAllowCookieLogin(true);
		login.setFocusOnLoad(true);
		login.setURLToRedirectToOnLogon(loginUri);

		middleBox.add(login);

		WFContainer cText = new WFContainer();
		cText.setStyleClass("domaininfo");
		HtmlOutputText tText = new HtmlOutputText();
		tText.setValue(iwma.getIWApplicationContext().getDomain().getName());
		cText.add(tText);
		//form.add(cText);

		middleBox.add(getVersionInfo(iwma));
		middleBox.add(getBuildId(iwma));

		//AboutSystemButton aboutbutton = new AboutSystemButton();
		//form.add(aboutbutton);

		//form.add(getCopyrightText());

		WFBezel copyrightBox = new WFBezel();
		copyrightBox.setStyleClass("ws_maincopyrightbox");
		loginBox.add(copyrightBox);

		Lists list = new Lists();
		copyrightBox.add(list);

		ListItem item = new ListItem();
		Link link = new Link("idega@idega.com", "mailto:idega@idega.com");
		item.add(link);
		list.add(item);

		item = new ListItem();
		item.add(new Text("&middot;"));
		list.add(item);

		item = new ListItem();
		link = new Link("www.idega.com", "http://www.idega.com");
		link.setTarget(Link.TARGET_BLANK_WINDOW);
		item.add(link);
		list.add(item);
	}

	protected UIComponent getVersionInfo(IWMainApplication iwma) {
		WFContainer cText = new WFContainer();
		cText.setStyleClass("versioninfo");
		HtmlOutputText tText = new HtmlOutputText();
		tText.setValue(iwma.getProductInfo().getVersion());
		cText.add(tText);
		return cText;
	}

	protected UIComponent getProductName(IWMainApplication iwma) {
		WFContainer cText = new WFContainer();
		cText.setStyleClass("productinfo");
		HtmlOutputText tText = new HtmlOutputText();

		String productName = iwma.getSettings().getProperty("product_name");
		if (StringUtil.isEmpty(productName))
			productName = iwma.getProductInfo().getFullProductName();
		tText.setValue(productName);
		cText.add(tText);
		return cText;
	}

	protected UIComponent getBuildId(IWMainApplication iwma) {
		WFContainer cText = new WFContainer();
		cText.setStyleClass("buildid");
		HtmlOutputText tText = new HtmlOutputText();
		tText.setValue(iwma.getProductInfo().getBuildId());
		cText.add(tText);
		return cText;
	}

	protected UIComponent getCopyrightText(IWMainApplication iwma) {
		WFContainer cText = new WFContainer();
		cText.setStyleClass("copyrighttext");
		HtmlOutputText tText = new HtmlOutputText();
		tText.setValue(iwma.getProductInfo().getCopyrightText());
		cText.add(tText);
		return cText;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.faces.component.UIComponent#encodeBegin(javax.faces.context.FacesContext)
	 */
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		if (!isInitalized()) {
			initializeContent(context);
			setInitialized(true);
		}

		super.encodeBegin(context);
	}

	/**
	 * <p>
	 * TODO tryggvil describe method setInitialized
	 * </p>
	 *
	 * @param b
	 */
	private void setInitialized(boolean b) {
		getAttributes().put("initialized", Boolean.valueOf(b));
	}

	/**
	 * <p>
	 * TODO tryggvil describe method isInitalized
	 * </p>
	 *
	 * @return
	 */
	private boolean isInitalized() {
		Boolean b = (Boolean) getAttributes().get("initialized");
		if (b != null) {
			return b.booleanValue();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.faces.component.UIComponent#encodeChildren(javax.faces.context.FacesContext)
	 */
	@Override
	public void encodeChildren(FacesContext context) throws IOException {
		super.encodeChildren(context);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.faces.component.UIComponent#encodeEnd(javax.faces.context.FacesContext)
	 */
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		super.encodeEnd(context);
	}
}