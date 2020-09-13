package de.clumsystuff.spring_boot_keycloak;

import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class IntegrationTestConfiguration {

    /**
     * This bean is used by Keycloak, it holds the properties required to operate with it. When running the
     * application in a normal way, there is an instance available. However, for some reason, there is
     * no instance available for integration tests, so the test would run into a NPE. This mocked instance is a
     * workaround.
     *
     * @see https://issues.redhat.com/browse/KEYCLOAK-14520?_sscc=t
     */
    @Bean
    public AdapterConfig adapterConfig() {

        AdapterConfig adapterConfig = new AdapterConfig();
        adapterConfig.setRealm("realm");
        adapterConfig.setResource("resource");
        adapterConfig.setAuthServerUrl("authServerUrl");

        return adapterConfig;
    }
}
