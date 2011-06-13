/**
 * 
 */
package com.idega.workspace.view;

import java.util.Collection;
import com.idega.core.view.ApplicationViewNode;
import com.idega.core.view.ViewNode;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWMainApplication;
import com.idega.util.CoreConstants;


/**
 * <p>
 * TODO tryggvil Describe Type WorkspaceApplicationNode
 * </p>
 *  Last modified: $Date: 2008/01/24 17:04:44 $ by $Author: valdas $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.3 $
 */
public class WorkspaceApplicationNode extends ApplicationViewNode {

	/**
	 * @param viewId
	 * @param parent
	 */
	public WorkspaceApplicationNode(String viewId, ViewNode parent,Collection roles) {
		super(viewId, parent);
		
		IWMainApplication iwma = getIWMainApplication();
		IWBundle workspaceBundle = iwma.getBundle(CoreConstants.WORKSPACE_BUNDLE_IDENTIFIER);
		setFaceletUri(workspaceBundle.getFaceletURI("workspace.xhtml"));
		setAuthorizedRoles(roles);
		
	}
}
