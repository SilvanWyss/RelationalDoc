package ch.nolix.relationaldoc.webapplication.testlauncher;

import ch.nolix.core.environment.localcomputer.ShellProvider;
import ch.nolix.relationaldoc.webapplication.main.RelationalDocApplication;
import ch.nolix.system.application.main.Server;

final class TestLauncherWithFileNodeDatabase {
	
	public static void main(String[] args) {
		
		//Creates a Server.
		final var server = Server.forHttpPort();
		
		//Creates a RelationalDocApplication.
		final var databaseFilePath = "relational_doc_database.spec";
		final var planningPokerApplication = RelationalDocApplication.withFileNodeDatabase(databaseFilePath);
		
		//Adds the RelationalDocApplication as default application to the Server.
		server.addDefaultApplication(planningPokerApplication);
		
		//Starts a default web browser that will connect to the Server.
		ShellProvider.startDefaultWebBrowserOpeningLoopBackAddress();
	}
	
	private TestLauncherWithFileNodeDatabase() {}
}
