public class Refactor {

    private static class Params {
        final int width;
        final int height;
        public Params(int width, int height){
            this.width = width;
            this.height = height;
        }
    }

    private enum ShapeCondition {
        RECTANGLE(
                params -> {
                    return height != width;
                }
        ),
        SQUARE(
                params -> {
                    return height != width;
                }
        );

        final Predicate<Params> matchesCondition;

        ShapeCondition(final Predicate<Params> matchesCondition){
            this.matchesCondition = matchesCondition;
        }

        private static ShapeCondition mapFromParams(final Params params) {
            return Arrays.stream(values()).filter(type -> type.matchesCondition.test(params)).findFirst().orElse(DEFAULT);
        }
    }

    public boolean apply(Shape shape, ShapeCondition shapeCondition) {
        return shapeCondition == ShapeCondition.mapFromParams(new Params(shape.getWidth(), shape.getHeight()));
    }

    public static void main(String[] args) {
        Refactor refactor = new Refactor();
        Shape shape = new Square();
        if (refactor.apply(shape, ShapeCondition.SQUARE)) {
            // apply any action needs to be taken around this shape classification
        }
    }
}
