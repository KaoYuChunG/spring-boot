package com.kao.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator  implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return null;
    }

    @Override
    public Health health() {
        //自定義在此
        //Health.up().build()

        return Health.down().withDetail("msg","error").build();
    }
}
