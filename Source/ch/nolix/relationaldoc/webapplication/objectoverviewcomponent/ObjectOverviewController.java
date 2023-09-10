package ch.nolix.relationaldoc.webapplication.objectoverviewcomponent;

import ch.nolix.core.container.immutablelist.ImmutableList;
import ch.nolix.core.language.GlobalEnglishNounHelper;
import ch.nolix.core.programatom.name.PluralPascalCaseCatalogue;
import ch.nolix.coreapi.containerapi.baseapi.IContainer;
import ch.nolix.coreapi.containerapi.singlecontainerapi.ISingleContainer;
import ch.nolix.relationaldocapi.webapplicationapi.contextapi.IRelationalDocContext;
import ch.nolix.system.application.component.Controller;
import ch.nolix.system.application.webapplication.WebClientSession;
import ch.nolix.techapi.relationaldocapi.datamodelapi.IAbstractableObject;

final class ObjectOverviewController extends Controller<IRelationalDocContext> {
	
	private final IAbstractableObject baseObject;
	
	public ObjectOverviewController(
		final ISingleContainer<IAbstractableObject> baseObject,
		final WebClientSession<IRelationalDocContext> session
	) {
		
		super(session);
		
		if (baseObject.containsAny()) {
			this.baseObject = baseObject.getStoredElement();
		} else {
			this.baseObject = null;
		}
	}
	
	public String getHeader() {
		
		if (hasBaseObject()) {
			return GlobalEnglishNounHelper.getPlural(baseObject.getName());
		}
		
		return PluralPascalCaseCatalogue.OBJECTS;
	}
	
	public IContainer<? extends IAbstractableObject> getStoredObjects() {
		
		if (hasBaseObject()) {
			return baseObject.getStoredDirectSubTypes();
		}
		
		return new ImmutableList<>();
	}
	
	private boolean hasBaseObject() {
		return (baseObject != null);
	}
}
