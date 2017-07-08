This page lists some useful information for modders.

### Tips & tricks

- There is a 3 year discrepancy in the timeline between the dates from the books (used in the mod) and the video games (used in the wikis). Don't get confused by the mess CD project has created !

### Cultures

When adapting vanilla elements (events, portrait, music, etc.), here is a rough association:
- Temeria ~ German
- Redania ~ Polish
- Kaedwen ~ Russian
- Kovir and Powys ~ Netherlands
- Hengfors League ~ Baltic
- Kerack ~ Scandinavian
- Skellige ~ Scandinavian
- Nilfgaard ~ Holy Roman Empire
- Sodden ~ Lombard
- Lyria ~ Italian
- Aedirn ~ Frankish
- Toussaint ~ French
- Ebbing ~ Hungrarian
- Dol Blathanna ~ Welsh
- Metinna ~ Anglo-Irish
- Nazair ~ Anglo-Saxon
- Maetcht ~ Frisian
- Etolia ~ Latin
- Cintra ~ Lowland Scots
- Gesco ~ Spanish

### Immortality

Don't use age checks for old (ex: age = 60), but instead:

````
has_character_modifier = old_age
````

Some races are infertile, so never impregnate without an actual fertility check.

### Races

Vanilla conditions "race = FROM" cannot be used, because it compares ethnicities/cultures and not fantasy racial traits.
Instead use has_same_race_as_from_trigger = yes to know if THIS and FROM have the same racial trait.
This is useful for racist trait MTTH, that should not apply if has_same_race_as_from_trigger = yes.

### Magic

Check for protection spells before killing a character: 

````
limit = { NOT = { has_character_modifier = protection_spell } }
````
