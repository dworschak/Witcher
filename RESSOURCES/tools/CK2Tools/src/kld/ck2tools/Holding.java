package kld.ck2tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Klaus
 * Date: 05.04.13
 */
public class Holding implements Comparable<Holding> {

    private String name;
    public int id;
    public String red;
    public String green;
    public String blue;

    public Map<String, Holding> children = new HashMap<>();
    public Holding capital;

    public String culture;
    public String religion;
    public int holder;
    public int level;
    public boolean hasLiege;
    public Holding parent;

    public Holding(String name, int id, String red, String green, String blue, String culture, String religion, int holder, int level, boolean hasLiege) {
        this.name = name;
        this.id = id;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.culture = culture;
        this.religion = religion;
        this.holder = holder;
        this.level = level;
        this.hasLiege = hasLiege;
    }

    public void setCapital(Holding capital) {
        this.capital = capital;
    }

    public String getHoldingTitle() {
        return normalize(name);
    }

    public static String normalize(String name) {
        String result = name.replace(" ", "_");
        result = result.replace("&", "_");
        result = result.replace("__", "_");
        result = result.replace("__", "_");
        return result.toLowerCase();
    }

    public String getHoldingTitlePrefixed() {
        String template = null;
        switch (level) {
            case 0:
                return "e_" + getHoldingTitle();
            case 1:
                return "k_" + getHoldingTitle();
            case 2:
                return "d_" + getHoldingTitle();
            case 3:
                return "c_" + getHoldingTitle();
            case 4:
                return "b_" + getHoldingTitle();
        }
        return template;
    }

    public static String getHoldingTitle(String name, int level) {
        String template = normalize(name);
        switch (level) {
            case 0:
                return "e_" + template;
            case 1:
                return "k_" + template;
            case 2:
                return "d_" + template;
            case 3:
                return "c_" + template;
            case 4:
                return "b_" + template;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Holding o) {
        return new Integer(id).compareTo(o.id);
    }

    public void addChild(String key, Holding holding) {
        if (!children.containsKey(key)) {
            children.put(key, holding);
            holding.setParent(this);
        }
    }

    public void setParent(Holding parent) {
        this.parent = parent;
    }

    public Holding getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return getHoldingTitlePrefixed() + " -> " + "Holding{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", red='" + red + '\'' +
                ", green='" + green + '\'' +
                ", blue='" + blue + '\'' +
                ", culture='" + culture + '\'' +
                ", religion='" + religion + '\'' +
                ", holder=" + holder +
                ", level=" + level +
                ", hasLiege=" + hasLiege +
                ", parent=" + parent +
                '}';
    }
}
