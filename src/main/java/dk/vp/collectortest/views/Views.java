package dk.vp.collectortest.views;

public class Views {

    private Views() {
        throw new IllegalStateException("Static class");
    }

    public interface Query extends Input {
    }

    public interface Input {

    }

}
