package ratpack.healthcheck.example.api.foo;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.form.Form;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.healthcheck.example.data.foo.FooRepository;

/**
 * Handler that changes the health status of the foo component for demonstration purposes.
 */
public class FooHandler implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(FooHandler.class);

    @Inject
    private FooRepository fooRepo;

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Form.class).then(form -> {
            boolean healthy = Boolean.parseBoolean(form.getOrDefault("healthy", "true"));

            if (healthy) {
                LOG.info("Setting Foo Health: Healthy");
                fooRepo.setHealthy().then(() -> {
                    ctx.getResponse().send();
                });
            } else {
                LOG.info("Setting Foo Health: Unhealthy");
                fooRepo.setUnhealthy().then(() -> {
                    ctx.getResponse().send();
                });
            }
        });
    }
}
