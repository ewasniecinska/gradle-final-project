import android.test.AndroidTestCase;
import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

/**
 * Created by ewasniecinska on 25.07.2018.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTest extends AndroidTestCase {

    @Test
    public void asyncTaskTest() throws Exception {
        String joke = null
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(InstrumentationRegistry.getContext());
        try {
            joke = asyncTask.get(40, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail("Timed out");
        }

        if (joke.equals(null)) {
            throw new AssertionError("Joke cannot be null");
        }

    }
}
