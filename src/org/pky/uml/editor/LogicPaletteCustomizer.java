/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.pky.uml.editor;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.gef.ui.palette.customize.DefaultEntryPage;
import org.eclipse.gef.ui.palette.customize.DrawerEntryPage;
import org.eclipse.gef.ui.palette.customize.EntryPage;

/**
 * PaletteCustomizer for the logic example.
 * 
 * @author Pratik Shah
 */
public class LogicPaletteCustomizer 
	extends PaletteCustomizer 
{
	
protected static final String ERROR_MESSAGE 
									= LogicMessages.PaletteCustomizer_InvalidCharMessage;
	
/**
 * @see org.eclipse.gef.ui.palette.PaletteCustomizer#getPropertiesPage(PaletteEntry)
 */
public EntryPage getPropertiesPage(PaletteEntry entry) {
	if (entry.getType().equals(PaletteDrawer.PALETTE_TYPE_DRAWER)) {
		return new LogicDrawerEntryPage();
	}
	return new LogicEntryPage();
}

/**
 * @see org.eclipse.gef.ui.palette.PaletteCustomizer#revertToSaved()
 */
public void revertToSaved() {
}


/**
 * @see org.eclipse.gef.ui.palette.PaletteCustomizer#save()
 */
public void save() {
}

private class LogicEntryPage extends DefaultEntryPage {
	protected void handleNameChanged(String text) {
		if (text.indexOf('*') >= 0) {
			getPageContainer().showProblem(ERROR_MESSAGE);
		} else {
			super.handleNameChanged(text);
			getPageContainer().clearProblem();
		}
	}
}

private class LogicDrawerEntryPage extends DrawerEntryPage {
	protected void handleNameChanged(String text) {
		if (text.indexOf('*') >= 0) {
			getPageContainer().showProblem(ERROR_MESSAGE);
		} else {
			super.handleNameChanged(text);
			getPageContainer().clearProblem();
		}
	}
}

}
