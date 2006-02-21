/**
 * 
 */
package com.idega.workspace.view;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import com.idega.core.view.ComponentClassViewNode;
import com.idega.core.view.ViewNode;
import com.idega.idegaweb.IWMainApplication;
import com.idega.webface.WFBlock;
import com.idega.workspace.WorkspacePage;


/**
 * <p>
 * TODO tryggvil Describe Type WorkspaceClassViewNode
 * </p>
 *  Last modified: $Date: 2006/02/21 16:17:40 $ by $Author: laddi $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.2 $
 */
public class WorkspaceClassViewNode extends ComponentClassViewNode {

	/**
	 * @param iwma
	 */
	public WorkspaceClassViewNode(IWMainApplication iwma) {
		super(iwma);
	}
	
	/**
	 */
	public WorkspaceClassViewNode(String viewId) {
		super(viewId);
	}	
	
	/**
	 * @param viewId the ViewId of this node (must be unique under its parent)
	 * @param parent the Parent of this node. This node will be added as a child under its parent implicitly by this constructor
	 */
	public WorkspaceClassViewNode(String viewId,ViewNode parent) {
		super(viewId,parent);
	}	
	
	/* (non-Javadoc)
	 * @see com.idega.core.view.ComponentClassViewNode#createComponent(javax.faces.context.FacesContext)
	 */
	public UIComponent createComponent(FacesContext context) {
		
		WorkspacePage page = new WorkspacePage();
		
		UIForm form = new HtmlForm();
		page.getChildren().add(form);
		UIComponent componentInstance=null;
		try{
			componentInstance = super.createComponent(context);
		}
		catch(Exception e){}
		
		WFBlock block = new WFBlock();
		block.setTitle(getName());
		//block.setMaximizedVertically(true);
		if(componentInstance!=null){
			block.getChildren().add(componentInstance);
		}
		form.getChildren().add(block);
		
		return page;
	}
	
}
