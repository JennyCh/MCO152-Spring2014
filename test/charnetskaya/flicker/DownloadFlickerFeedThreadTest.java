package charnetskaya.flicker;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;

public class DownloadFlickerFeedThreadTest {


	@Test
	public void testCallsLoadImages() throws IOException {
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread t = new DownloadFlickerFeedThread(frame);
		
		Mockito.verify(frame, Mockito.never()).loadImages(Mockito.any(FlickerFeed.class));
		t.run(); //we want to execute this code in the same thread
		//Verifica
		Mockito.verify(frame, Mockito.timeout(1)).loadImages(Mockito.any(FlickerFeed.class));
	}

}
