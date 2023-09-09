package ch.nolix.relationaldoc.webapplication.headercomponent;

import ch.nolix.relationaldocapi.webapplicationapi.contextapi.IRelationalDocContext;
import ch.nolix.system.application.component.Controller;
import ch.nolix.system.application.webapplication.WebClientSession;

final class HeaderController extends Controller<IRelationalDocContext> {
	
	public HeaderController(final WebClientSession<IRelationalDocContext> session) {
		super(session);
	}
}
