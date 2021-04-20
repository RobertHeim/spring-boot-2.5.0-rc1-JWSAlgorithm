package com.example.demo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.keycloak.admin.client.CreatedResponseUtil
import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.resource.RealmResource
import org.keycloak.admin.client.resource.UsersResource
import org.keycloak.representations.idm.CredentialRepresentation
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.context.SmartLifecycle
import org.springframework.stereotype.Component
import javax.ws.rs.core.Response

@Component
class Initializer(
  val kc: Keycloak,
  val kcConfig: KeycloakConfig,
) : SmartLifecycle {
  private var running = false

  override fun start() {
    running = true
    GlobalScope.launch {
      try {
        // CREATE USER
        val pw = "test"
        val email = "test@example.com"
        // Define user
        // define password credential
        val passwordCred = CredentialRepresentation()
        passwordCred.isTemporary = false
        passwordCred.type = CredentialRepresentation.PASSWORD
        passwordCred.value = pw

        val u = UserRepresentation()
        u.isEnabled = true
        u.username = email
        u.email = email
        u.credentials = listOf(passwordCred)

        // Get realm
        val realmResources: RealmResource = kc.realm(kcConfig.realm)
        val usersResource: UsersResource = realmResources.users()

        // create user
        val response: Response = usersResource.create(u)
        val userId: String = CreatedResponseUtil.getCreatedId(response)
        println("Created user with user id $userId")
      } catch (e: Exception) {
        println(e.message)
        println("ERROR CREATING USER")
      }
      running = false
    }
  }

  override fun stop() {
  }

  override fun isRunning(): Boolean = running
}
