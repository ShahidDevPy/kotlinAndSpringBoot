package com.example.flower

import com.fasterxml.jackson.databind.JsonNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GraphQLSupportIntegration(@Autowired val graphQLTest: GraphQLTest ) {
    @Test
    fun `test hello` () {
        val controller = ApiController()
        assertEquals("hello, My name is Shahid Rasool", controller.hello())

    }
    @Test
    fun `given graphql pole query fetches hello successfully`() {

        println("hello query successfull")
        val hello = graphQLTest.tester.mutate().webTestClient {
        }.build().document(
            "query Hello {\n" +
                    "  hello\n" +
                    "}"
        ).execute().path("").entity(JsonNode::class.java).also {
            println(it.get().toPrettyString())
        }

}}