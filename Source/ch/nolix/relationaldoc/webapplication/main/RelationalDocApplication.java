package ch.nolix.relationaldoc.webapplication.main;

import ch.nolix.core.document.node.FileNode;
import ch.nolix.core.document.node.MutableNode;
import ch.nolix.relationaldoc.webapplication.context.RelationalDocContext;
import ch.nolix.relationaldoc.webapplication.session.ObjectOverviewSession;
import ch.nolix.relationaldocapi.webapplicationapi.contextapi.IRelationalDocContext;
import ch.nolix.system.application.main.Application;
import ch.nolix.system.application.webapplication.WebClient;
import ch.nolix.tech.relationaldoc.dataadapter.DataAdapter;
import ch.nolix.techapi.relationaldocapi.dataaapterapi.IDataAdapter;

public final class RelationalDocApplication
extends Application<WebClient<IRelationalDocContext>, IRelationalDocContext> {
	
	public static final String APPLICATION_NAME = "Relational Doc";
	
	public static RelationalDocApplication withFileNodeDatabase(final String filePath) {
		
		final var fileNodeDatabase = new FileNode(filePath);
		
		final var dataAdapter = DataAdapter.forNodeDatabase(fileNodeDatabase);
		
		return new RelationalDocApplication(dataAdapter);
	}
	
	public static RelationalDocApplication withInMemoryNodeDatabase() {
		
		final var nodeDatabase = new MutableNode();
		
		final var dataAdapter = DataAdapter.forNodeDatabase(nodeDatabase);
		
		return new RelationalDocApplication(dataAdapter);
	}
	
	private RelationalDocApplication(final IDataAdapter databaseAdapter) {
		super(RelationalDocContext.withDataAdapter(databaseAdapter));
	}
	
	@Override
	public String getApplicationName() {
		return APPLICATION_NAME;
	}
	
	@Override
	protected Class<?> getInitialSessionClass() {
		return ObjectOverviewSession.class;
	}
}
