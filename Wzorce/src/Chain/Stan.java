package Chain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Stan {
    SPAM,
    IMPORTANT,
    OTHER;
    private static final List<Stan> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Stan randomValue()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
