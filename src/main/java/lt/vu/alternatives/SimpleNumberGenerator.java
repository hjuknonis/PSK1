package lt.vu.alternatives;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Alternative
public class SimpleNumberGenerator implements NumberGenerator{

    public int generateNumber() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        int min = 10000;

        return ThreadLocalRandom.current().nextInt(min);
    }
}
