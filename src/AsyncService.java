import java.util.concurrent.CompletableFuture;

public class AsyncService {
    public static String futureMethod() {
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) { e.printStackTrace(); }
        finally {
            return "End of future";
        }

    }

    public static void handleResolved(String result) {
        System.out.println("handleResolved result: " +result);
    }

    public static String handleRejected(Throwable e) {
        e.printStackTrace();
        return e.getMessage();
    }

    public static void callFuture() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(AsyncService::futureMethod);
        future.thenAccept(AsyncService::handleResolved);
        future.exceptionally(AsyncService::handleRejected);
    }
}
