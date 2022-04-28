package gatyou;

import io.gatling.javaapi.core.Simulation;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class SampleSimulation extends Simulation {

    {
        var httpProtocol = http.baseUrl("https://gatyou.herokuapp.com");
        var scenario = scenario("sample")
                .exec(http("request-root").get("/"));

        setUp(scenario.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
    }
}
