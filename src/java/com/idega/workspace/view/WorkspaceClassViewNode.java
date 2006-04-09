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
 *  Last modified: $Date: 2006/04/09 11:45:30 $ by $Author: laddi $
 * 
 * @author <a href="mailto:tryggvil@idega.com">tryggvil</a>
 * @version $Revision: 1.5 $
 */
public class WorkspaceClassViewNode extends ComponentClassViewNode {

	private boolean maximizeBlockVertically=false;
	
	/**
	 * @param iwma
	 */
	public WorkspaceClassViewNode() {
		this(IWMainApplication.getDefaultIWMainApplication());
	}
	
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
		block.setMaximizedVertically(isMaximizeBlockVertically());
		//block.setMaximizedVertically(true);
		if(componentInstance!=null){
			block.getChildren().add(componentInstance);
		}
		form.getChildren().add(block);
		
		return page;
	}

	
	/**
	 * @return Returns the maximizeBlockVertically.
	 */
	public boolean isMaximizeBlockVertically() {
		return this.maximizeBlockVertically;
	}

	
	/**
	 * @param maximizeBlockVertically The maximizeBlockVertically to set.
	 */
	public void setMaximizeBlockVertically(boolean maximizeBlockVertically) {
		this.maximizeBlockVertically = maximizeBlockVertically;
	}
	
}
