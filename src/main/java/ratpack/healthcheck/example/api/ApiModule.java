package ratpack.healthcheck.example.api;

import com.google.inject.AbstractModule;
import ratpack.healthcheck.example.api.bar.BarHandler;
import ratpack.healthcheck.example.api.foo.FooHandler;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiEndpoints.class);

        bind(FooHandler.class);
        bind(BarHandler.class);
    }
}
