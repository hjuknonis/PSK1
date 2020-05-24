package lt.vu.alternatives;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Alternative
public class InstantNumberGenerator implements NumberGenerator {
    public int generateNumber() {
        int min = 10000;

        return ThreadLocalRandom.current().nextInt(min);
    }
}
