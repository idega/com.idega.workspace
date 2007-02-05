/**
 * $Id: AboutWindow.java,v 1.1 2007/02/05 06:53:42 tryggvil Exp $
 * Created in 2007 by tryggvil
 *
 * Copyright (C) 2000-2007 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.workspace;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import com.idega.webface.WFContainer;
import com.idega.webface.WFUtil;


/**
 * <p>
 * Window that displays information about the current system
 * </p>
 *  Last modified: $Date: 2007/02/05 06:53:42 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.1 $
 */
public class AboutWindow extends WorkspacePage {
	
	
	public void initializeContent(FacesContext context){
		
		setLayout(LAYOUT_COMPACT);
		
		this.setId("aboutpage");
		
		UIForm form = new HtmlForm();
		this.getChildren().add(form);
		
		super.initializeContent(context);
		
		super.setShowFunctionMenu(false);
		super.getWorkspaceBar().setShowLoginLogout(false);
		
		
		WFContainer aboutContainer = new WFContainer();
		aboutContainer.setStyleClass("aboutcontainer");
		this.add(aboutContainer);
		
		addLine(aboutContainer,"#{localizedStrings['com.idega.workspace']['solutionname']}","#{idegaweb_application.productInfo.name}");
		addLine(aboutContainer,"#{localizedStrings['com.idega.workspace']['solutionversion']}","#{idegaweb_application.productInfo.version}");
		addLine(aboutContainer,"#{localizedStrings['com.idega.workspace']['installedmodules']}","#{localizedStrings['com.idega.core']['installedmodulessee']}","/window/aboutmodules/");
		addLine(aboutContainer,"#{localizedStrings['com.idega.workspace']['solutionvendorname']}","#{idegaweb_application.productInfo.vendor}","#{idegaweb_application.productInfo.vendorUrl}");
		addLine(aboutContainer,"#{localizedStrings['com.idega.workspace']['setuppartyname']}","#{idegaweb_application.installationInfo.setupPartyName}","http://www.idega.com");
		addLine(aboutContainer,"#{localizedStrings['com.idega.workspace']['hostingpartyname']}","#{idegaweb_application.installationInfo.hostingPartyName}","http://www.anza.is");
		addLine(aboutContainer,"#{localizedStrings['com.idega.workspace']['solutionlicencee']}","#{idegaweb_application.installationInfo.licenceOwner.name}");
		
		WFContainer logoContainer = new WFContainer();
		logoContainer.setStyleClass("logocontainer");
		aboutContainer.add(logoContainer);
		
		HtmlGraphicImage vendorImage = new HtmlGraphicImage();
		ValueBinding vendorImageVB = WFUtil.createValueBinding("#{idegaweb_application.productInfo.vendorLogoUrl}");
		vendorImage.setValueBinding("value",vendorImageVB);
		vendorImage.setStyleClass("logoimage");
		logoContainer.add(vendorImage);
		
		HtmlGraphicImage licenceeImage = new HtmlGraphicImage();
		ValueBinding licenceeImageVB = WFUtil.createValueBinding("#{idegaweb_application.installationInfo.licenceOwner.logoUrl}");
		licenceeImage.setValueBinding("value",licenceeImageVB);
		licenceeImage.setStyleClass("logoimage");
		logoContainer.add(licenceeImage);
		
		WFContainer copyrightContainer = new WFContainer();
		copyrightContainer.setStyleClass("copyrightcontainer");
		HtmlOutputText crtext = WFUtil.getTextVB("idegaweb_application.productInfo.copyrightText");
		copyrightContainer.getChildren().add(crtext);
		this.add(copyrightContainer);
	}
	
	protected void addLine(UIComponent container, String label, String text){
		addLine(container,label,text,null);
	}
		
	protected void addLine(UIComponent container, String label, String text,String url){
		WFContainer line = new WFContainer();
		line.setStyleClass("line");
		container.getChildren().add(line);
		
		WFContainer lineLabel = new WFContainer();
		lineLabel.setStyleClass("label");
		line.add(lineLabel);
		HtmlOutputText uiLabel = new HtmlOutputText();
		if(WFUtil.isValueBinding(label)){
			ValueBinding vb = WFUtil.createValueBinding(label);
			uiLabel.setValueBinding("value",vb);
		}
		else{
			uiLabel.setValue(label);
		}
		lineLabel.add(uiLabel);
		
		WFContainer lineText = new WFContainer();
		lineText.setStyleClass("text");
		line.add(lineText);
		
		HtmlOutputText systemNameText = new HtmlOutputText();
		if(WFUtil.isValueBinding(text)){
			ValueBinding vb = WFUtil.createValueBinding(text);
			systemNameText.setValueBinding("value",vb);
		}
		else{
			systemNameText.setValue(text);
		}
		
		if(url==null){
			lineText.add(systemNameText);
		}
		else{
			HtmlOutputLink link = new HtmlOutputLink();
			if(WFUtil.isValueBinding(url)){
				ValueBinding vb = WFUtil.createValueBinding(url);
				link.setValueBinding("value",vb);
			}
			else{
				link.setValue(url);
			}
			link.getChildren().add(systemNameText);
			link.setTarget("_new");
			lineText.add(link);
		}
	}
	
}
