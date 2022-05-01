package click.thisisjhoel.faulttolerancepattern;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class ServiceClientConfiguration {

    private static final CircuitBreakerConfig CIRCUIT_BREAKER_CONFIG = CircuitBreakerConfig.ofDefaults();

    private static final FeignDecorators RESILIENCE_DECORATORS = FeignDecorators.builder()
            .withCircuitBreaker(CircuitBreaker.of("common", CIRCUIT_BREAKER_CONFIG))
            .build();
    private static final Feign.Builder DECORATED_BUILDER = Resilience4jFeign.builder(RESILIENCE_DECORATORS)
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logLevel(Logger.Level.FULL)
            .logger(new Slf4jLogger());

    private final AddressServiceProperties addressServiceProperties;

    @Bean
    public AddressServiceClient createAddressClient() {
        return DECORATED_BUILDER
                .retryer(new CommonRetryer())
                .target(AddressServiceClient.class, addressServiceProperties.getUrl());
    }

}
