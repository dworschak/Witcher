This page lists some useful information for modders.

### General

- There is a 3 year discrepancy in the timeline between the dates from the books (used in the mod) and the video games (used in the wikis). Don't get confused by this mistake from CD project !

### Cultures

When adapting vanilla elements (events, portrait, music, etc.), here is a rough association:

- Temeria ~ German
- Redania ~ Polish
- Kaedwen ~ Russian
- Kovir and Powys ~ Netherlands
- Hengfors League ~ Baltic
- Kerack ~ Scandinavian
- Skellige ~ Scandinavian
- Cidaris ~ Denmark
- Verden ~ Norway
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

### Events

The vanilla game rules "supernatural_events" is obviously removed, as there is lot of supernatural stuff in the Witcher world.
Vanilla events should usually be altered to keep the part associated to the value "unrestricted" of the game rule.

When a vanilla event is unsuitable, try to find a lore-equivalent and override the event localization keys, rather than disabling the event entirely - it's cheaper than creating a new event chain !

### Immortality

Don't use age checks for old (ex: age = 60), but instead:

````
has_character_modifier = old_age
````

This is added via event at:

- ~50 for humans, who can live up to ~90
- ~75 for halflings and gnomes, who can live up to ~125
- ~100 for dwarves, who can live up to ~150
- ~300 for elves and dryads, who can live up to ~400
- ~300 for witchers and sorcerers, who can live eternally

The culling is done via defines for non-immortal races, and via event otherwise.

Court pruning of immortals is mainly controlled via health (NDefines.NEngine.HEALTH_IMMUNITY_TO_PRUNING). 
All races that are immortal, but get auto-generated courtiers, need to be subject to pruning to keep game performances acceptable, and should have total health below the limit.
In addition marriage also prevent pruning, so A.I. should not be helped to marry immortal race courtiers.

### Fertility

Some races are infertile, so never impregnate via event without an actual fertility check:

- Most races become infertile at 50
- Elves are fertile between ~50 and ~250, but get a -10%/-20% fertility reduction per each birth
- Dryads are fertile between ~50 and ~300 (impregnated only via event)

### Adulthood

Age of adulthood is set to 15 instead of 16 via defines:

- Use is_adult instead of age = 15 for ability to rule
- Use is_marriage_adult instead of age = 15 for ability to marry

### Races

Vanilla condition "race = FROM" cannot be used, because it compares ethnicities/cultures and not fantasy racial traits.
Instead use has_same_race_as_from_trigger = yes to know if THIS and FROM have the same racial trait.
This is useful for racist trait MTTH, that should not apply if has_same_race_as_from_trigger = yes.

### Magic

Check for protection spells before killing a character: 

````
limit = { NOT = { has_character_modifier = protection_spell } }
````
