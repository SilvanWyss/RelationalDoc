package ch.nolix.relationaldoc.webapplication.objectoverviewcomponent;

import ch.nolix.coreapi.containerapi.baseapi.IContainer;
import ch.nolix.coreapi.containerapi.singlecontainerapi.ISingleContainer;
import ch.nolix.relationaldocapi.webapplicationapi.contextapi.IRelationalDocContext;
import ch.nolix.system.application.component.Component;
import ch.nolix.system.application.webapplication.WebClientSession;
import ch.nolix.system.webgui.atomiccontrol.Label;
import ch.nolix.system.webgui.linearcontainer.FloatContainer;
import ch.nolix.system.webgui.linearcontainer.VerticalStack;
import ch.nolix.systemapi.webguiapi.atomiccontrolapi.LabelRole;
import ch.nolix.systemapi.webguiapi.mainapi.IControl;
import ch.nolix.techapi.relationaldocapi.datamodelapi.IAbstractableObject;

public final class ObjectOverviewComponent extends Component<ObjectOverviewController, IRelationalDocContext> {
	
	public ObjectOverviewComponent(
		final ISingleContainer<IAbstractableObject> baseObject,
		final WebClientSession<IRelationalDocContext> session
	) {
		super(new ObjectOverviewController(baseObject, session));
	}
	
	@Override
	protected IControl<?, ?> createControl(final ObjectOverviewController controller) {
		return
		new VerticalStack()
		.addControl(
			new Label()
			.setRole(LabelRole.LEVEL1_HEADER)
			.setText(controller.getHeader()),		
			new FloatContainer()
			.addControls(createObjectPanelControls(controller))
		);
	}
	
	@Override
	protected void doRegistrations(final ObjectOverviewController controller) {
		//Does nothing.
	}
	
	private IContainer<? extends IControl<?, ?>> createObjectPanelControls(final ObjectOverviewController controller) {
		return controller.getStoredObjects().to(this::createObjectPanelControl);
	}
	
	private IControl<?, ?> createObjectPanelControl(final IAbstractableObject object) {
		return
		new VerticalStack()
		.addControl(
			new Label()
			.setText(object.getName())
		);
	}
}
