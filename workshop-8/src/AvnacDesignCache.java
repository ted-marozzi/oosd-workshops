import java.util.HashMap;
import java.util.Map;

public class AvnacDesignCache implements DesignCache {

    private final Map<String, Design> cache;

    private static AvnacDesignCache _INSTANCE;

    private AvnacDesignCache() {
        this.cache = new HashMap<>();
    }

    public static AvnacDesignCache getInstance() {
        if(_INSTANCE == null)
            _INSTANCE = new AvnacDesignCache();
        return _INSTANCE;
    }

    @Override
    public Design getDesign(String url) {
        if (!cache.containsKey(url)) {
            cache.put(url, loadDesignFromUrl(url));
        }
        return cache.get(url);
    }

    @Override
    public Design loadDesignFromUrl(String url) {
        System.out.format("Retrieving design from: %s!", url);
        return new Design();
    }
}
