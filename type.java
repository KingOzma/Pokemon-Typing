//Ryan Arce
//Final Project

public enum Type {
    NONE("None"),
    NORMAL("Normal"),
    FIRE("Fire"),
    WATER("Water"),
    ELECTRIC("Electric"),
    GRASS("Grass"),
    ICE("Ice"),
    FIGHTING("Fighting"),
    POISON("Poison"),
    GROUND("Ground"),
    FLYING("Flying"),
    PSYCHIC("Psychic"),
    BUG("Bug"),
    ROCK("Rock"),
    GHOST("Ghost"),
	DRAGON("Dragon"),
	DARK("Dark"),
	STEEL("Steel"),
	FAIRY("Fairy");
	
    public final String Pokemon;

    Type(String pokemon) {
        this.Pokemon = pokemon;
    }
}