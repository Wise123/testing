import org.example.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureRestTestClient
public class IntegrationTest {

    @Autowired
    RestTestClient restTestClient;

    @Test
    public void test() {
        restTestClient.get().uri("/main/?regionNumbers=59")

                .exchange().expectStatus().isOk();

        assertTrue(true);
    }
}
