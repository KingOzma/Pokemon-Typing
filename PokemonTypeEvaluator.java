///Ryan Arce
//Final Project 

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PokemonTypeEvaluator {

	static PokemonType normal = new PokemonType.Body(Type.NORMAL)
			.vulnTo(Type.FIGHTING).immuneTo(Type.GHOST).generate();

			static PokemonType fire = new PokemonType.Body(Type.FIRE)
			.vulnTo(Type.WATER, Type.GROUND, Type.ROCK)
			.resistTo(Type.FIRE, Type.GRASS, Type.ICE,
			        Type.BUG, Type.STEEL, Type.FAIRY)
			.generate();

			static PokemonType water = new PokemonType.Body(Type.WATER)
			.vulnTo(Type.ELECTRIC, Type.GRASS)
			.resistTo(Type.FIRE, Type.WATER, Type.ICE, Type.STEEL)
			.generate();

			static PokemonType electric = new PokemonType.Body(Type.ELECTRIC)
			.resistTo(Type.ELECTRIC, Type.STEEL, Type.FLYING)
			.vulnTo(Type.GROUND).generate();

			static PokemonType grass = new PokemonType.Body(Type.GRASS)
			.resistTo(Type.GRASS, Type.WATER, Type.GROUND, Type.ELECTRIC)
			.vulnTo(Type.FIRE, Type.ICE,
			        Type.POISON, Type.FLYING, Type.BUG)
			.generate();

			static PokemonType ice = new PokemonType.Body(Type.ICE)
			.vulnTo(Type.FIRE, Type.STEEL, Type.ROCK, Type.FIGHTING)
			.resistTo(Type.ICE).generate();

			static PokemonType fighting = new PokemonType.Body(Type.FIGHTING)
			.vulnTo(Type.PSYCHIC, Type.FLYING, Type.FAIRY)
			.resistTo(Type.BUG, Type.ROCK, Type.DARK)
			.generate();

			static PokemonType poison = new PokemonType.Body(Type.POISON)
			.resistTo(Type.GRASS, Type.FIGHTING, Type.POISON,
			        Type.BUG, Type.FAIRY)
			.vulnTo(Type.GROUND, Type.PSYCHIC).generate();

			static PokemonType ground = new PokemonType.Body(Type.GROUND)
			.resistTo(Type.POISON, Type.ROCK)
			.vulnTo(Type.WATER, Type.GRASS, Type.ICE)
			.immuneTo(Type.ELECTRIC).generate();

			static PokemonType flying = new PokemonType.Body(Type.FLYING)
			.resistTo(Type.GRASS, Type.FIGHTING, Type.BUG)
			.vulnTo(Type.ELECTRIC, Type.ICE, Type.ROCK)
			.immuneTo(Type.GROUND).generate();

			static PokemonType psychic = new PokemonType.Body(Type.PSYCHIC)
			.vulnTo(Type.BUG, Type.DARK, Type.GHOST)
			.resistTo(Type.FIGHTING, Type.PSYCHIC).generate();

			static PokemonType bug = new PokemonType.Body(Type.BUG)
			.vulnTo(Type.FIRE, Type.FLYING, Type.ROCK)
			.resistTo(Type.GRASS, Type.FIGHTING, Type.GROUND)
			.generate();

			static PokemonType rock = new PokemonType.Body(Type.ROCK)
			.vulnTo(Type.WATER, Type.GRASS, Type.FIGHTING,
			        Type.GROUND, Type.STEEL)
			.resistTo(Type.NORMAL, Type.FIRE, Type.POISON, Type.FLYING)
			.generate();

			static PokemonType ghost = new PokemonType.Body(Type.GHOST)
			.vulnTo(Type.GHOST, Type.DARK)
			.resistTo(Type.BUG, Type.POISON)
			.immuneTo(Type.NORMAL, Type.FIGHTING)
			.generate();

			static PokemonType dragon = new PokemonType.Body(Type.DRAGON)
			.resistTo(Type.WATER, Type.FIRE, Type.ELECTRIC, Type.GRASS)
			.generate();

			static PokemonType dark = new PokemonType.Body(Type.DARK)
			.vulnTo(Type.FIGHTING, Type.BUG, Type.FAIRY)
			.resistTo(Type.GHOST, Type.DARK)
			.immuneTo(Type.PSYCHIC).generate();

			static PokemonType steel = new PokemonType.Body(Type.STEEL)
			.vulnTo(Type.FIRE, Type.FIGHTING, Type.GROUND)
			.resistTo(Type.NORMAL, Type.GRASS, Type.ICE, Type.FLYING,
			       Type.PSYCHIC, Type.BUG, Type.ROCK, Type.DRAGON,
			        Type.STEEL, Type.FAIRY)
			.immuneTo(Type.POISON).generate();

			static PokemonType fairy = new PokemonType.Body(Type.FAIRY)
			.vulnTo(Type.STEEL, Type.POISON)
			.resistTo(Type.FIGHTING, Type.DARK, Type.BUG)
			.immuneTo(Type.DRAGON).generate();

			static PokemonType none = new PokemonType.Body(Type.NONE).generate();

    static ArrayList<PokemonType> pokemonTypes = new ArrayList<>(Arrays.asList(none, normal,
            fire, water, electric, grass, ice, fighting, poison, ground, flying, psychic,
            bug, rock, ghost, dragon, dark, steel, fairy));

    static JTextField immunities = new JTextField(15),
            resistances = new JTextField(15), vulnerabilities = new JTextField(15);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pokemon Type Evaluator");
        JPanel selectionPanel = new JPanel(), result = new JPanel();
        result.setLayout(new GridLayout(3, 2, 0, 2));

        immunities.setEditable(false);
        resistances.setEditable(false);
        vulnerabilities.setEditable(false);

        result.add(new JLabel("Immune to:"));
        result.add(immunities);
        result.add(new JLabel("Resistant to:"));
        result.add(resistances);
        result.add(new JLabel("Vulnerable to:"));
        result.add(vulnerabilities);

        JComboBox<String> typeList = new JComboBox<String>();
        JComboBox<String> typeList2 = new JComboBox<String>();

        for (Type t : Type.values()) {
            typeList.addItem(t.Pokemon);
            typeList2.addItem(t.Pokemon);
        }

        typeList.setSelectedItem(Type.NORMAL.Pokemon);

        ItemListener typeListener = t -> {
            PokemonType primaryPokemonType = normal, secondaryPokemonType = none;
            if (t.getStateChange() == ItemEvent.SELECTED) {
                displayAttributes(getPokemonType((String)typeList.getSelectedItem()),
                        getPokemonType((String)typeList2.getSelectedItem())
                );
            }
        };

        typeList.addItemListener(typeListener);
        typeList2.addItemListener(typeListener);

        selectionPanel.add(typeList);
        selectionPanel.add(typeList2);

        frame.add(result, BorderLayout.CENTER);
        frame.add(selectionPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void displayAttributes(PokemonType primary, PokemonType secondary) {
        if (primary == secondary) { secondary = none; }

        immunities.setText("");
        vulnerabilities.setText("");
        resistances.setText("");
        StringBuilder immuneBody = new StringBuilder(""),
                vulnerableBody = new StringBuilder(""),
                resistBody = new StringBuilder("");

        for(Map.Entry<Type, Double> entry : primary.getMultipliers().entrySet()){
            for(Map.Entry<Type, Double> entry2 : secondary.getMultipliers().entrySet()) {
                if (entry.getKey() == entry2.getKey()) {

                    if (entry.getValue() * entry2.getValue() == 0.0) {
                        immuneBody.append(entry.getKey().Pokemon).append(", ");
                    }
                    else if (entry.getValue() * entry2.getValue()  <= 0.5 ) {
                        resistBody.append(entry.getKey().Pokemon).append(", ");
                    }
                    else if (entry.getValue() * entry2.getValue()  >= 2.0) {
                        vulnerableBody.append(entry.getKey().Pokemon).append(", ");
                    }
                }
            }
        }

        finalizeBody(immuneBody);
        finalizeBody(resistBody);
        finalizeBody(vulnerableBody);

        immunities.setText(immuneBody.toString());
        vulnerabilities.setText(vulnerableBody.toString());
        resistances.setText(resistBody.toString());
    }

    public static PokemonType getPokemonType(String pokemon) {
        for (PokemonType b : pokemonTypes) {
            if (b.type.Pokemon == pokemon) {
                return b;
            }
        }
        return none; 
    }
    public static StringBuilder finalizeBody(StringBuilder sb) {
        if (sb.length() == 0) { sb.append("None."); }
        else {
            sb.setLength(sb.length() - 2);
            sb.append('.');
        }
        return sb;
    }
}