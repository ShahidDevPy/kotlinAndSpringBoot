package com.example.flower
import org.springframework.graphql.test.tester.HttpGraphQlTester
import org.springframework.stereotype.Component
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.servlet.client.MockMvcWebTestClient
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.reactive.function.client.ExchangeStrategies
import java.time.Duration

@Component
class GraphQLTest(private val applicationContext: WebApplicationContext) {
    val tester = run {
        val client: WebTestClient = MockMvcWebTestClient.bindToApplicationContext(applicationContext)
            .configureClient().responseTimeout(Duration.ofMinutes(5))
            .baseUrl("/graphql")
            .exchangeStrategies(
                ExchangeStrategies.builder()
                    .codecs { codecs -> codecs.defaultCodecs().maxInMemorySize(10 * 1024 * 1024) }
                    .build())
            .build()
        HttpGraphQlTester.create(client)
    }
}