package ch.nolix.relationaldocapi.webapplicationapi.contextapi;

import ch.nolix.systemapi.applicationapi.applicationcontextapi.IDataAdapterFactory;
import ch.nolix.systemapi.applicationapi.webapplicationapi.IWebApplicationContext;
import ch.nolix.techapi.relationaldocapi.dataaapterapi.IDataAdapter;

public interface IRelationalDocContext extends IDataAdapterFactory<IDataAdapter>, IWebApplicationContext {}
