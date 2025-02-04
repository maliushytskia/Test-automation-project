package core;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestWatcherExtension implements TestWatcher {
    private static final Logger logger = Logger.getInstance();

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.logTestEnd(context.getDisplayName(), true);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.logTestEnd(context.getDisplayName(), false);
    }
}
