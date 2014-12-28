package org.primefaces.cookbook.controller.chapter11;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * NavigationContext.
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@Named
@SessionScoped
public class NaviController implements Serializable {

	public String getMenuitemStyleClass(final String page) {
		final String viewId = getViewId();
		if (viewId != null && viewId.equals(page)) {
			return "ui-state-active";
		}

		return "";
	}

	private String getViewId() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String viewId = fc.getViewRoot().getViewId();
		String selectedComponent;
		if (viewId != null) {
			selectedComponent = viewId.substring(viewId.lastIndexOf("/") + 1, viewId.lastIndexOf("."));
		} else {
			selectedComponent = null;
		}

		return selectedComponent;
	}
}