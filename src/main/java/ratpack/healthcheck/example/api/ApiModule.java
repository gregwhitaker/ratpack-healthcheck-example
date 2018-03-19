package ratpack.healthcheck.example.api;

import com.google.inject.AbstractModule;
import ratpack.healthcheck.example.api.bar.UpdateBarHealthyHandler;
import ratpack.healthcheck.example.api.bar.UpdateBarUnhealthyHandler;
import ratpack.healthcheck.example.api.foo.UpdateFooHealthyHandler;
import ratpack.healthcheck.example.api.foo.UpdateFooUnhealthyHandler;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiEndpoints.class);

        bind(UpdateBarHealthyHandler.class);
        bind(UpdateBarUnhealthyHandler.class);
        bind(UpdateFooHealthyHandler.class);
        bind(UpdateFooUnhealthyHandler.class);
    }
}
