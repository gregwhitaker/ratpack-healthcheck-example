package ratpack.healthcheck.example.data;

import com.google.inject.AbstractModule;
import ratpack.healthcheck.example.data.bar.BarRepository;
import ratpack.healthcheck.example.data.bar.DefaultBarRepository;
import ratpack.healthcheck.example.data.foo.DefaultFooRepository;
import ratpack.healthcheck.example.data.foo.FooRepository;

public class DataModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(FooRepository.class).to(DefaultFooRepository.class);
        bind(BarRepository.class).to(DefaultBarRepository.class);
    }
}
