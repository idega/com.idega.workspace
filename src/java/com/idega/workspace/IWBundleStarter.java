/*
 * $Id: IWBundleStarter.java,v 1.2 2005/03/06 13:17:44 tryggvil Exp $
 * Created on 27.1.2005
 *
 * Copyright (C) 2005 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.workspace;

import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.idegaweb.include.GlobalIncludeManager;


/**
 * 
 *  Last modified: $Date: 2005/03/06 13:17:44 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.2 $
 */
public class IWBundleStarter implements IWBundleStartable {

	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#start(com.idega.idegaweb.IWBundle)
	 */
	public void start(IWBundle starterBundle) {

		//Register the style sheet:
		GlobalIncludeManager gbi = GlobalIncludeManager.getInstance();
		gbi.addBundleStyleSheet(starterBundle.getBundleIdentifier(),"/style/workspace.css");
		
	}

	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#stop(com.idega.idegaweb.IWBundle)
	 */
	public void stop(IWBundle starterBundle) {
		// TODO Auto-generated method stub
	}
}
