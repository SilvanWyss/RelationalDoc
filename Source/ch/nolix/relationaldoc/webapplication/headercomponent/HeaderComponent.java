package ch.nolix.relationaldoc.webapplication.headercomponent;

import ch.nolix.relationaldocapi.webapplicationapi.contextapi.IRelationalDocContext;
import ch.nolix.system.application.component.ComponentWithDataAdapter;
import ch.nolix.system.application.webapplication.WebClientSession;
import ch.nolix.system.webgui.atomiccontrol.Label;
import ch.nolix.systemapi.webguiapi.atomiccontrolapi.LabelRole;
import ch.nolix.systemapi.webguiapi.mainapi.IControl;
import ch.nolix.techapi.relationaldocapi.dataaapterapi.IDataAdapter;

public final class HeaderComponent
extends ComponentWithDataAdapter<HeaderController, IRelationalDocContext, IDataAdapter> {
	
	public HeaderComponent(
		final IDataAdapter initialDataAdapter,
		final WebClientSession<IRelationalDocContext> session
	) {
		super(new HeaderController(session), initialDataAdapter);
	}
	
	@Override
	protected IControl<?, ?> createControl(final HeaderController controller, final IDataAdapter dataAdapter) {
		return
		new Label()
		.setRole(LabelRole.TITLE)
		.setText("Relational Doc");
	}
	
	@Override
	protected void doRegistrations(final HeaderController controller) {
		//Does nothing.
	}
}
