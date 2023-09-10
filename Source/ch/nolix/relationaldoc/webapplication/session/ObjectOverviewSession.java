package ch.nolix.relationaldoc.webapplication.session;

import ch.nolix.core.container.singlecontainer.SingleContainer;
import ch.nolix.coreapi.containerapi.singlecontainerapi.ISingleContainer;
import ch.nolix.relationaldoc.webapplication.headercomponent.HeaderComponent;
import ch.nolix.relationaldoc.webapplication.objectoverviewcomponent.ObjectOverviewComponent;
import ch.nolix.relationaldocapi.webapplicationapi.contextapi.IRelationalDocContext;
import ch.nolix.system.application.webapplication.WebClientSession;
import ch.nolix.system.webgui.linearcontainer.VerticalStack;
import ch.nolix.systemapi.webguiapi.basecontainerapi.ContainerRole;
import ch.nolix.systemapi.webguiapi.mainapi.IControl;
import ch.nolix.techapi.relationaldocapi.dataaapterapi.IDataAdapter;
import ch.nolix.techapi.relationaldocapi.datamodelapi.IAbstractableObject;
import ch.nolix.template.webgui.style.StyleCatalogue;

public final class ObjectOverviewSession extends WebClientSession<IRelationalDocContext> {
	
	private final IAbstractableObject baseObject;
	
	public ObjectOverviewSession() {
		this(new SingleContainer<>());
	}
	
	public ObjectOverviewSession(final ISingleContainer<IAbstractableObject> baseObject) {
		if (baseObject.containsAny()) {
			this.baseObject = baseObject.getStoredElement();
		} else {
			this.baseObject = null;
		}
	}
	
	@Override
	protected void initialize() {
		try (final var dataAdater = getStoredApplicationContext().createDataAdapter()) {
			getStoredGui()
			.pushLayerWithRootControl(
				createRootControl(dataAdater)
			)
			.setStyle(StyleCatalogue.DARK_STYLE);
		}
	}
	
	private IControl<?, ?> createRootControl(final IDataAdapter dataAdapter) {
		return
		new VerticalStack()
		.setRole(ContainerRole.OVERALL_CONTAINER)
		.addControl(
			new HeaderComponent(dataAdapter, this).getStoredControl(),
			new ObjectOverviewComponent(SingleContainer.withElementOrEmpty(baseObject), this).getStoredControl()
		);
	}
}
