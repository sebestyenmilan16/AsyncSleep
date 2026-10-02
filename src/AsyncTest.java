import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTest {

    @Test
    public void testResolved() throws InterruptedException {
        Main.main(null);
        Assert.assertNull(Main.error);
    }

    public static String fail() {
        throw new RuntimeException("Test Expection");

    }

    @Test
    public void testReject() throws ExecutionException, InterruptedException {
        CompletableFuture<String> jobToFail = CompletableFuture.supplyAsync(AsyncTest::fail);
        jobToFail.exceptionally(AsyncService::handleRejected);
        Assert.assertThrows(ExecutionException.class, jobToFail::get);
    }

}
