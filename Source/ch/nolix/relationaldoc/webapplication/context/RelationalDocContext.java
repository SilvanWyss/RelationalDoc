package ch.nolix.relationaldoc.webapplication.context;

import ch.nolix.core.errorcontrol.validator.GlobalValidator;
import ch.nolix.relationaldocapi.webapplicationapi.contextapi.IRelationalDocContext;
import ch.nolix.system.graphic.color.Color;
import ch.nolix.system.graphic.image.MutableImage;
import ch.nolix.systemapi.graphicapi.imageapi.IImage;
import ch.nolix.techapi.relationaldocapi.dataaapterapi.IDataAdapter;

public final class RelationalDocContext implements IRelationalDocContext {
	
	public static RelationalDocContext withDataAdapter(final IDataAdapter dataAdapter) {
		return new RelationalDocContext(dataAdapter);
	}
	
	private final IDataAdapter dataAdapter;
	
	private RelationalDocContext(final IDataAdapter dataAdapter) {
		
		GlobalValidator.assertThat(dataAdapter).thatIsNamed(IDataAdapter.class).isNotNull();
		
		this.dataAdapter =dataAdapter;
	}
	
	@Override
	public IDataAdapter createDataAdapter() {
		return dataAdapter.getEmptyCopy();
	}
	
	@Override
	public IImage getApplicationLogo() {
		return MutableImage.withWidthAndHeightAndColor(100, 100, Color.DARK_GREEN);
	}
}
