package com.example.flower

import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller


@Controller
class GraphQLSupport {
@QueryMapping
fun hello()="hello, My name is shahid rasool"

}