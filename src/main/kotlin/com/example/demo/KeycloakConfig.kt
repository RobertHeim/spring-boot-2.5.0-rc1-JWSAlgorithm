package com.example.demo

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder
import org.keycloak.OAuth2Constants
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "keycloak")
class KeycloakConfig {
  var serverUrl: String? = null
  var realm: String? = null
  var clientId: String? = null
  var clientSecret: String? = null

  @Bean
  fun init(): Keycloak {
    return KeycloakBuilder.builder()
      .serverUrl(serverUrl)
      .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
      .realm(realm)
      .clientId(clientId)
      .clientSecret(clientSecret)
      .resteasyClient(
        ResteasyClientBuilder().connectionPoolSize(10).build()
      )
      .build()
  }
}
