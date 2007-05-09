/*
 * $Id: IWBundleStarter.java,v 1.5 2007/05/09 18:12:28 valdas Exp $
 * Created on 27.1.2005
 *
 * Copyright (C) 2005 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.workspace;

import com.idega.core.view.ComponentClassViewNode;
import com.idega.core.view.ViewNode;
import com.idega.faces.WindowViewManager;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.idegaweb.include.GlobalIncludeManager;


/**
 * 
 *  Last modified: $Date: 2007/05/09 18:12:28 $ by $Author: valdas $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.5 $
 */
public class IWBundleStarter implements IWBundleStartable {

	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#start(com.idega.idegaweb.IWBundle)
	 */
	public void start(IWBundle starterBundle) {

		//Register the style sheet:
		GlobalIncludeManager gbi = GlobalIncludeManager.getInstance();
		gbi.addBundleStyleSheet(starterBundle.getBundleIdentifier(),"/style/workspace.css");
		gbi.addBundleStyleSheet(starterBundle.getBundleIdentifier(),"/style/iframe.css");
		
		
		WindowViewManager wViewManager = WindowViewManager.getInstance(starterBundle.getApplication());
		
		ViewNode baseWindow = wViewManager.getWindowNode();
		if(baseWindow!=null){
			ComponentClassViewNode node = new ComponentClassViewNode("about",baseWindow);
			node.setComponentBased(true);
			node.setComponentClass(AboutWindow.class);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#stop(com.idega.idegaweb.IWBundle)
	 */
	public void stop(IWBundle starterBundle) {
		// TODO Auto-generated method stub
	}
}
