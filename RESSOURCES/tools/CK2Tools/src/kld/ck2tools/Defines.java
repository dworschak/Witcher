package kld.ck2tools;

/**
 * User: Klaus
 * Date: 06.04.13
 * Time: 15:46
 */
public class Defines {
    static final String template = "# {name}\n" +
            "\n" +
            "# County Title\n" +
            "title = c_{name}\n" +
            "\n" +
            "# Settlements\n" +
            "max_settlements = 3\n" +
            "b_{name} = castle\n" +
            "\n" +
            "# Misc\n" +
            "culture = {culture}\n" +
            "religion = {religion}";
    static String header = "e_rebels = {\n" +
            "\trebel = yes\n" +
            "\tlandless = yes\n" +
            "\tprimary = yes\n" +
            "\n" +
            "\tculture = cidarian\n" +
            "\ttribe = yes\n" +
            "\n" +
            "\tcolor={ 0 0 0 }\n" +
            "\tcolor2={ 0 0 0 }\n" +
            "}\n" +
            "\n" +
            "e_pirates = {\n" +
            "\tpirate = yes\n" +
            "\tlandless = yes\n" +
            "\tprimary = yes\n" +
            "\n" +
            "\tculture = cidarian\n" +
            "\ttribe = yes\n" +
            "\n" +
            "\tcolor={ 0 0 0 }\n" +
            "\tcolor2={ 0 0 0 }\n" +
            "}\n" +
            "\n" +
            "e_byzantium = {\n" +
            "\t\n" +
            "\tlandless = yes\n" +
            "\tprimary = yes\n" +
            "\t\n" +
            "\tculture = cidarian\n" +
            "\ttribe = yes\n" +
            "\n" +
            "\tcolor={ 0 0 0 }\n" +
            "\tcolor2={ 0 0 0 }\n" +
            "\n" +
            "}\n" +
            "\n" +
            "#####\n" +
            "\n" +
            "k_papal_state = {\n" +
            "\tcolor={ 255 249 198 }\n" +
            "\tcolor2={ 220 220 0 }\n" +
            "\t\n" +
            "\tcapital = 108\n" +
            "\t\n" +
            "\ttitle = \"POPE\"\n" +
            "\tfoa = \"POPE_FOA\"\n" +
            "\tshort_name = yes\n" +
            "\tlocation_ruler_title = yes\n" +
            "\t\n" +
            "\t# Always exists\n" +
            "\tlandless = yes\n" +
            "\t\n" +
            "\t# Controls a religion\n" +
            "\tcontrols_religion = catholic\n" +
            "\t\n" +
            "\treligion = catholic\n" +
            "\t\n" +
            "\t# Cannot be held as a secondary title\n" +
            "\tprimary = yes\n" +
            "\t\n" +
            "\tdynasty_title_names = no \t# Will not be named \"Seljuk\", etc.\n" +
            "\t\n" +
            "\t# Regnal names\n" +
            "\tmale_names = {\n" +
            "\t\tIoannes Gregorius Benedictus Clement Innocentius Leo Pius Stephen Bonifacius Urban Alexander Adrian Paul\n" +
            "\t\tCelestine Martin Nicholas Sixtus Felix Sergius Anastasius Honorius Eugene Sylvester Victor\n" +
            "\t\tLucius Callixtus Julius Pelagius Adeodatus Theodore Marinus Agapetus Damasus Paschal\n" +
            "\t\tGelasius Marcellus \"Ioannes Paulus\" Anacletus Evaristus Telesphorus Hyginus Anicetus Mark Hilarius \n" +
            "\t\tSimplicius Symmachus Hormisdas Silverius Vigilius Sabinian Severinus Vitalian Donus Agatho\n" +
            "\t\tConon Sisinnius Constantinus Zachary Valentinus Formosus Romanus Lando\n" +
            "\t}\n" +
            "}\n" +
            "\n" +
            "k_orthodox = {\n" +
            "#\tcolor={ 150 90 30 }\n" +
            "\tcolor={ 183 60 155 }\n" +
            "\tcolor2={ 220 220 0 }\n" +
            "\t\n" +
            "\tcapital = 50\n" +
            "\t\n" +
            "\ttitle = \"ECUMENICAL_PATRIARCH\"\n" +
            "\tfoa = \"ECUMENICAL_PATRIARCH_FOA\"\n" +
            "\tshort_name = yes\n" +
            "\n" +
            "\t# Always exists\n" +
            "\tlandless = yes\n" +
            "\t\n" +
            "\t# Controls a religion\n" +
            "\tcontrols_religion = orthodox\n" +
            "\t\n" +
            "\treligion = orthodox\n" +
            "\t\n" +
            "\t# Cannot be held as a secondary title\n" +
            "\tprimary = yes\n" +
            "\t\n" +
            "\tdynasty_title_names = no \t# Will not be named \"Seljuk\", etc.\n" +
            "\t\n" +
            "\t# Regnal names\n" +
            "\tmale_names = {\n" +
            "\t\tAlexios Antonios Athanasios Basileios Chariton Dionysios Dositheos Eustathios Eustratios Euthymios\n" +
            "\t\tGennadios Georgios Gerasimos Germanos Gregoras Ioannes Iosephos Isidoros Kallistos Konstantinos\n" +
            "\t\tKosmas Leon Leontios Loukas Makarios Manuel Maximos Metrophanes Michael Neophytos Nephon Niketas\n" +
            "\t\tNikolaos Nilos Matthaios Paulos Sergios Sisinnios Symeon Theodoros Theodosios Theodotos\n" +
            "\t}\n" +
            "}\n" +
            "\n" +
            "e_sunni = {\n" +
            "\t# OBSOLETE\n" +
            "\tcolor={ 40 160 40 }\n" +
            "\tcolor2={ 220 220 0 }\n" +
            "\t\n" +
            "#\tcapital = 30 # Mecca\n" +
            "\t\n" +
            "\ttitle = \"CALIPH\"\n" +
            "\ttitle_female = \"CALIPHA\"\n" +
            "\tfoa = \"CALIPH_FOA\"\n" +
            "\tshort_name = yes\n" +
            "\t\n" +
            "\treligion=sunni\n" +
            "\t\n" +
            "\t# controls_religion = sunni\n" +
            "\t\n" +
            "\tcaliphate = yes\n" +
            "}\n" +
            "\n" +
            "e_shiite = {\n" +
            "\t# OBSOLETE\n" +
            "\tcolor={ 60 190 60 }\n" +
            "\tcolor2={ 220 220 0 }\n" +
            "\t\n" +
            "#\tcapital = 30 # Mecca\n" +
            "\t\n" +
            "\ttitle = \"CALIPH\"\n" +
            "\ttitle_female = \"CALIPHA\"\n" +
            "\tfoa = \"CALIPH_FOA\"\n" +
            "\tshort_name = yes\n" +
            "\t\n" +
            "\treligion=shiite\n" +
            "\t\n" +
            "\t# controls_religion = shiite\n" +
            "\n" +
            "\tcaliphate = yes\n" +
            "}\n" +
            "\n" +
            "d_sunni = {\n" +
            "\tcolor={ 40 160 40 }\n" +
            "\tcolor2={ 220 220 0 }\n" +
            "\t\n" +
            "\tcapital = 15 # Mecca\n" +
            "\t\n" +
            "\tcreation_requires_capital = no\n" +
            "\t\n" +
            "\tdignity = 100 # Counted as having this many more counties than it does\n" +
            "\t\n" +
            "\ttitle = \"CALIPH\"\n" +
            "\ttitle_female = \"CALIPHA\"\n" +
            "\tfoa = \"CALIPH_FOA\"\n" +
            "\tshort_name = yes\n" +
            "\t\n" +
            "\treligion=sunni\n" +
            "\t\n" +
            "\t# Controls a religion\n" +
            "\tcontrols_religion = sunni\n" +
            "\t\n" +
            "\tcaliphate = yes\n" +
            "}\n" +
            "\n" +
            "d_shiite = {\n" +
            "\tcolor={ 60 190 60 }\n" +
            "\tcolor2={ 220 220 0 }\n" +
            "\t\n" +
            "\tcapital = 23 # Mecca\n" +
            "\t\n" +
            "\tcreation_requires_capital = no\n" +
            "\t\n" +
            "\tdignity = 100 # Counted as having this many more counties than it does\n" +
            "\t\n" +
            "\ttitle = \"CALIPH\"\n" +
            "\ttitle_female = \"CALIPHA\"\n" +
            "\tfoa = \"CALIPH_FOA\"\n" +
            "\tshort_name = yes\n" +
            "\t\n" +
            "\treligion=shiite\n" +
            "\t\n" +
            "\t# Controls a religion\n" +
            "\tcontrols_religion = shiite\n" +
            "\t\n" +
            "\tcaliphate = yes\n" +
            "}\n" +
            "\n" +
            "e_golden_horde = {\n" +
            "\tcolor = { 243 180 17 }\n" +
            "\t\n" +
            "\tcapital = 42\n" +
            "\t\n" +
            "\t# Always exists\n" +
            "\tlandless = yes\n" +
            "\t\n" +
            "\ttribe = yes\n" +
            "\t\n" +
            "\tculture = mongol\n" +
            "\treligion = tengri_pagan\n" +
            "}\n" +
            "\n" +
            "e_il-khanate = {\n" +
            "\tcolor = { 120 180 20 }\n" +
            "\t\n" +
            "\tcapital = 2\n" +
            "\t\n" +
            "\t# Always exists\n" +
            "\tlandless = yes\n" +
            "\t\n" +
            "\ttribe = yes\n" +
            "\t\n" +
            "\tculture = mongol\n" +
            "\treligion = tengri_pagan\n" +
            "}\n" +
            "\n" +
            "e_timurids = {\n" +
            "\tcolor = { 120 20 20 }\n" +
            "\t\n" +
            "\tcapital = 10\n" +
            "\t\n" +
            "\t# Always exists\n" +
            "\tlandless = yes\n" +
            "\t\n" +
            "\ttribe = yes\n" +
            "\t\n" +
            "\tculture = mongol\n" +
            "\treligion = sunni\n" +
            "}\n" +
            "\n" +
            "d_varangian_guard = {\n" +
            "\tcolor={ 180 180 180 }\n" +
            "\tcolor2={ 255 255 255 }\n" +
            "\n" +
            "\tcapital = 12 # Uppland\n" +
            "\t\n" +
            "\t# Parent Religion \n" +
            "\treligion = orthodox\n" +
            "\t\n" +
            "\tculture = swedish\n" +
            "\t\n" +
            "\tmercenary = yes\n" +
            "\n" +
            "\ttitle = \"CAPTAIN\"\n" +
            "\tfoa = \"CAPTAIN_FOA\"\n" +
            "\n" +
            "\t# Always exists\n" +
            "\tlandless = yes\n" +
            "\t\n" +
            "\t# Cannot be held as a secondary title\n" +
            "\tprimary = yes\n" +
            "\t\n" +
            "\tstrength_growth_per_century = 0.10\n" +
            "\t\n" +
            "\tmodifier = d_varangian_guard_modifier\n" +
            "}\n" +
            "d_flaming_rose = {\n" +
            "\tcolor={ 230 230 230 }\n" +
            "\tcolor2={ 255 255 255 }\n" +
            "\t\n" +
            "\tcapital = 108 # Roggeven / Barienmurg\n" +
            "\t\n" +
            "\ttitle = \"GRANDMASTER\"\n" +
            "\tfoa = \"GRANDMASTER_FOA\"\n" +
            "\n" +
            "\t# Always exists\n" +
            "\tlandless = yes\n" +
            "\t\n" +
            "\tholy_order = yes\n" +
            "\t\n" +
            "\t# Parent Religion \n" +
            "\treligion = eternal_fire\n" +
            "\t\n" +
            "\t# Cannot be held as a secondary title\n" +
            "\tprimary = yes\n" +
            "\n" +
            "\tmodifier = d_flaming_rose_modifier\n" +
            "}" +
            "\n" +
            "#####\n\n\n";
    static String empireTemplate = "\ne_{name} = {\n" +
            "\tcolor={ {red} {green} {blue} }\n" +
            "\tcolor2={ 255 255 20 }\n" +
            "\t\n" +
            "\tcapital = {capitalId} # {capital}" +
            "\t\n" +
            "\tshort_name = yes\n" +
            "\t\n" +
            "\tculture = {culture}\n" +
            "\t\n";
    static String kingdomTemplate = "\nk_{name} = {\n" +
            "\tcolor={ {red} {green} {blue} }\n" +
            "\tcolor2={ 255 255 255 }\n" +
            "\t\n" +
            "\tcapital = {capitalId} # {capital}\n" +
            "\t\n" +
            "\tculture = {culture}\n" +
            "\t\n" +
            "\tcatholic = 100 # Crusade target weight\n" +
            "\t\n";
    static String duchyTemplate =
            "\td_{name} = {\n" +
                    "\t\tcolor={ {red} {green} {blue} }\n" +
                    "\t\tcolor2={ 255 255 255 }\n" +
                    "\t\t\n" +
                    "\t\tcapital = {capitalId} # {capital}\n" +
                    "\t\t\n";
    static String countyTemplate = "\t\tc_{name} = {\n" +
            "\t\t\tcolor={ {red} {green} {blue} }\n" +
            "\t\t\tcolor2={ 255 255 255 }\n" +
            "\t\t\n";
    static String baronyTemplate = "\t\t\tb_{name} = {\n";
}
