package com.droy.pedecorator;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IDecoratorManager;

public class ProjectDecorator extends LabelProvider implements ILabelDecorator {

	public static final String ID = "com.droy.PEDecorator.decorator";

	public static ProjectDecorator getInstance() {
		IDecoratorManager decoratorManager = Activator.getDefault().getWorkbench().getDecoratorManager();

		// check that this decorator is enabled
		if (decoratorManager.getEnabled(ID)) {
			return (ProjectDecorator) decoratorManager.getLabelDecorator(ID);
		}

		// we are disabled
		return null;
	}

	public Image decorateImage(Image image, Object element) {
		// we could decorate image here...
		return null;
	}

	public String decorateText(String text, Object element) {
		// we decorate name of the project here...
		if (element instanceof IProject) {
			return text + " " + ((IProject) element).getLocationURI();
		}
		return "decoration " + text;
	}

}
