package kz.EnumsAndAnnotations;

public enum Operation {
    SUBTRACT{
        @Override
        public int action(int x, int y) {
            return x - y;
        }
    },
    ADD{
        @Override
        public int action(int x, int y) {
            return x + y;
        }
    },
    MULTIPLY{
        @Override
        public int action(int x, int y) {
            return x * y;
        }
    };

    public abstract int action(int x, int y);
}
