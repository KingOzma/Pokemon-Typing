import java.util.HashMap;

public class PokemonType {
    String name;
    HashMap<Type, Double> multipliers = new HashMap<Type, Double>();
    Type type;

    PokemonType(Body b) {
        name = b.pokemon; multipliers = b.multipliers; type = b.type;
    }

    static class Body {
        final String pokemon;
        HashMap<Type, Double> multipliers = new HashMap<Type, Double>();
        Type type;

        public Body(Type type) {
            this.pokemon = type.Pokemon;
            this.type = type;

            for (Type t : Type.values()) {
                multipliers.put(t, 1.0);
            }
        }

        public Body vulnTo(Type... types) {
            for (Type t : types) { multipliers.put(t, 2.0); }
            return this;
        }
        public Body immuneTo(Type... types) {
            for (Type t : types) { multipliers.put(t, 0.0); }
            return this;
        }
        public Body resistTo(Type... types) {
            for (Type t : types) { multipliers.put(t, 0.5); }
            return this;
        }
        public PokemonType generate() { return new PokemonType(this); }
    }
    public HashMap<Type, Double> getMultipliers() {
        return this.multipliers;
    }
}
