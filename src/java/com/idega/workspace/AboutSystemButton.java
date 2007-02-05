/**
 * $Id: AboutSystemButton.java,v 1.1 2007/02/05 06:53:42 tryggvil Exp $
 * Created in 2007 by tryggvil
 *
 * Copyright (C) 2000-2007 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.workspace;

import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.FacesContext;
import com.idega.presentation.text.Text;
import com.idega.webface.WFContainer;


/**
 * <p>
 * TODO tryggvil Describe Type AboutSystemButton
 * </p>
 *  Last modified: $Date: 2007/02/05 06:53:42 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.1 $
 */
public class AboutSystemButton extends WFContainer {

	@Override
	protected void initializeComponent(FacesContext context) {
		setStyleClass("aboutsystem");
		
		HtmlOutputLink link = new HtmlOutputLink();
		link.setValue("javascript:iwOpenWindow('/window/about/','aboutSystemWindow','0','0','0','0','0','0','0','0','350','400');");
		link.setTitle("About this system");
		link.setStyleClass("aboutlink");
		
		Text text = new Text();
		text.setText("About this system");
		//text.setStyleClass("text");
		link.getChildren().add(text);
		
		//Text nbsp = Text.getNonBrakingSpace();
		//link.getChildren().add(nbsp);
		
		/*WFContainer altText = new WFContainer();
		altText.setStyleClass("text");
		link.getChildren().add(altText);
		
		HtmlOutputText text = new HtmlOutputText();
		text.setValue("About this system");
		altText.getChildren().add(text);
		*/
		
		
		this.getChildren().add(link);
		
		
	}
}
