package ratpack.healthcheck.example.api.bar;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.form.Form;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.healthcheck.example.data.bar.BarRepository;

/**
 * Handler that changes the health status of the bar component for demonstration purposes.
 */
public class BarHandler implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(BarHandler.class);

    @Inject
    private BarRepository barRepo;

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Form.class).then(form -> {
            boolean healthy = Boolean.parseBoolean(form.getOrDefault("healthy", "true"));

            if (healthy) {
                LOG.info("Setting Bar Health: Healthy");
                barRepo.setHealthy().then(() -> {
                    ctx.getResponse().send();
                });
            } else {
                LOG.info("Setting Bar Health: Unhealthy");
                barRepo.setUnhealthy().then(() -> {
                    ctx.getResponse().send();
                });
            }
        });
    }
}
