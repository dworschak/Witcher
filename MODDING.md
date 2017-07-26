This page lists some useful information for modders.

### Tips & tricks

- There is a 3 year discrepancy in the timeline between the dates from the books (used in the mod) and the video games (used in the wikis). Don't get confused by the mess CD project has created !

### Army sizes

With vanilla default building values, the size of armies is probably scaled down by a factor of 3 to 5 compared to sources:
- Nilfgaard ~ 150,000
	- Impera Brigade ~ 5,000
- Kaedwen ~ 35,000 ?
- Redania ~ 35,000
- Temeria ~ 25,000
- Lyria & Rivia ~ 13,000

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

### Supernatural events

The vanilla game rules supernatural_events is obviously removed, there's lots of supernatural stuff in the witcher world.
Vanilla events be altered to usually keep the scripts associated to value = unrestricted of the game rule.

### Immortality

Don't use age checks for old (ex: age = 60), but instead:

````
has_character_modifier = old_age
````

Some races are infertile, so never impregnate without an actual fertility check.

### Races

Vanilla condition "race = FROM" cannot be used, because it compares ethnicities/cultures and not fantasy racial traits.
Instead use has_same_race_as_from_trigger = yes to know if THIS and FROM have the same racial trait.
This is useful for racist trait MTTH, that should not apply if has_same_race_as_from_trigger = yes.

### Magic

Check for protection spells before killing a character: 

````
limit = { NOT = { has_character_modifier = protection_spell } }
````
