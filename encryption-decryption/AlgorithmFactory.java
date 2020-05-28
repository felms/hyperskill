public class AlgorithmFactory {

    public static Algorithm getAlgorithm(String alg) {
        alg = alg.toUpperCase();

        if ("UNICODE".equals(alg)) {
            return new UnicodeAlgorithm();
        }

        if ("SHIFT".equals(alg)) {
           return new ShiftAlgorithm();
        }

        return null;
    }
}
