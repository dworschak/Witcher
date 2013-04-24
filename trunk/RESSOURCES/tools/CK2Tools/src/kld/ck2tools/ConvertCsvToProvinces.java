package kld.ck2tools;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * User: Klaus
 * Date: 05.04.13
 */
public class ConvertCsvToProvinces {

    //public static final String dir = "D:\\Dropbox\\_Witcher\\trunk\\MOD\\Witcher";
    public static final String dir = "E:\\Documents\\Paradox Interactive\\Crusader Kings II\\mod\\Witcher";

    private static Map<String, Holding> topList = new HashMap<>();
    private static Set<Holding> counties = new TreeSet<>();

    public static void main(String[] args) {

        File file = new File(dir + File.separator + "common" + File.separator + "landed_titles" + File.separator + "landed_titles.txt");
        File file1 = new File(dir + File.separator + "map" + File.separator + "definition.csv");
        File file2 = new File(dir + File.separator + "localisation" + File.separator + "Province names.csv");
        file.getParentFile().mkdirs();
        file1.getParentFile().mkdirs();
        file2.getParentFile().mkdirs();

        try (
                BufferedReader br = new BufferedReader(new FileReader(file1));
                BufferedWriter landed_titles = new BufferedWriter(new FileWriter(file));
                BufferedWriter provinceWriter = new BufferedWriter(new FileWriter(file2))
        ) {

            deleteExisting();

            provinceWriter.write("#CODE;ENGLISH;FRENCH;GERMAN;SPANISH;;;;;;;;x\n");

            String str;
            br.readLine();//title
            while ((str = br.readLine()) != null) {

                String[] split = str.split(";");
                //System.out.println(Arrays.toString(split));
                Integer id = Integer.parseInt(split[0]);

                String red = split[1];
                String green = split[2];
                String blue = split[3];

                String details = split[4];
                String culture = details.substring(0, details.indexOf("/"));
                String religion = details.substring(details.indexOf("/") + 1);

                String[] fullName = split[5].split("/");
                String countyStr = fullName[0];
                String empireStr = fullName[1];
                String kingdomStr = fullName[2];
                String duchyStr = fullName[3];
                int holder = -1;
                try {
                    holder = Integer.parseInt(fullName[4]);
                } catch (NumberFormatException e) {
                }
                boolean hasLiege = "n".equalsIgnoreCase(fullName[5]);

                Holding county = new Holding(countyStr, id, red, green, blue, culture, religion, holder, 3, hasLiege);
                Holding barony = new Holding(countyStr, id, red, green, blue, culture, religion, -1, 4, hasLiege);
                county.addChild(countyStr, barony);

                counties.add(county);

                Holding empire = null;
                if (!topList.containsKey(Holding.getHoldingTitle(kingdomStr, 1))) {
                    Holding kingdom = new Holding(kingdomStr, -1, red, green, blue, culture, religion, holder, 1, hasLiege);
                    if ("x".equals(empireStr)) {
                        topList.put(kingdom.getHoldingTitlePrefixed(), kingdom);
                    } else {
                        empire = findOrCreateEmpire(empireStr, red, green, blue, culture, religion, holder, county);
                        empire.addChild(kingdom.getHoldingTitlePrefixed(), kingdom);
                    }
                    kingdom.setCapital(county);
                }
                Holding kingdom = topList.get(Holding.getHoldingTitle(kingdomStr, 1));
                if (empire != null) {
                    kingdom = empire.children.get(Holding.getHoldingTitle(kingdomStr, 1));
                }

                if (!kingdom.children.containsKey(Holding.getHoldingTitle(duchyStr, 2))) {
                    Holding duchy = new Holding(duchyStr, -1, red, green, blue, culture, religion, holder, 2, hasLiege);
                    kingdom.addChild(duchy.getHoldingTitlePrefixed(), duchy);
                    duchy.setCapital(county);
                }
                Holding duchy = kingdom.children.get(Holding.getHoldingTitle(duchyStr, 2));
                duchy.addChild(countyStr, county);

                writeProvinceFile(county);

                System.out.println(id + " " + culture + " " + religion + " " + county);
            }

            topList.remove("e_x");
            topList.remove("k_x");


            landed_titles.write(Defines.header);

            for (Holding holding : topList.values()) {
                writeHolding(landed_titles, holding);
            }
            for (Holding county : counties) {
                writeProvinceName(provinceWriter, county);
            }

            System.out.println();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteExisting() {
        File file = new File(dir + File.separator + "history" + File.separator + "titles");
        if (file.isDirectory()) {
            String[] myFiles = file.list();
            for (String myFile1 : myFiles) {
                File myFile = new File(file, myFile1);
                myFile.delete();
            }
        }
    }

    private static void checkFlag(Holding county) throws IOException {
        File dest = new File(dir + File.separator + "gfx" + File.separator + "flags" + File.separator + county.getHoldingTitlePrefixed() + ".tga");
        dest.getParentFile().mkdirs();

        if (!dest.exists()) {
            File otherFlags = new File(dir + File.separator + "gfx" + File.separator + "flags" + File.separator + "_other");
            FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File directory, String fileName) {
                    return fileName.endsWith(".tga");
                }
            };
            File[] flags = otherFlags.listFiles(filter);

            int index = (int) (flags.length * Math.random());

            File pickedOne = flags[index];
            File destFile = new File(pickedOne.getParent() + File.separator + "used" + File.separator + pickedOne.getName());
            destFile.getParentFile().mkdirs();
            copyFile(pickedOne, destFile);
            pickedOne.renameTo(dest);
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.getParentFile().mkdirs();
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

    private static Holding findOrCreateEmpire(String empireStr, String red, String green, String blue, String culture, String religion, int holder, Holding county) {
        if (!"x".equals(empireStr)) {
            if (!topList.containsKey(Holding.getHoldingTitle(empireStr, 0))) {
                Holding empire = new Holding(empireStr, -1, red, green, blue, culture, religion, holder, 0, false);
                topList.put(empire.getHoldingTitlePrefixed(), empire);
                empire.setCapital(county);
                return empire;
            }
            return topList.get(Holding.getHoldingTitle(empireStr, 0));
        }
        return null;
    }

    private static void writeHolding(BufferedWriter writer, Holding holding) throws IOException {
        String template = getTemplateForLevel(holding.level);
        String text = fillTemplate(template, holding);
        writer.write(text);

        for (Holding childHolding : holding.children.values()) {
            writeHolding(writer, childHolding);
        }

        writer.write("}\n\t");

        if (holding.level < 4) {
            writeHistoryTitle(holding, holding.level);
            checkFlag(holding);
        }
    }

    private static void writeProvinceName(BufferedWriter provinceWriter, Holding holding) throws IOException {
        provinceWriter.write("PROV" + holding.id + ";" + holding.getName() + ";;;;;;;;x\n");
    }

    private static void writeHistoryTitle(Holding holding, int level) {
        System.out.println("Write title history for " + holding);
        String holdingTitle = getHoldingTitle(holding, level);
        if (holding.holder > 0) {
            File dest = new File(dir + File.separator + "history" + File.separator + "titles" + File.separator + holdingTitle + ".txt");
            dest.getParentFile().mkdirs();

            //if (!dest.exists()) {

            try (
                    BufferedWriter bw = new BufferedWriter(new FileWriter(dest))
            ) {
                if (holding.parent != null && holding.hasLiege) {
                    bw.write("500.1.1={\n\tliege=" + holding.parent.getHoldingTitlePrefixed() + "\n}\n\n");
                }

                bw.write("1273.1.1={\n\tholder=" + holding.holder + "\n}");

            } catch (IOException e) {
                e.printStackTrace();
            }

            // }
        }
    }

    private static String getHoldingTitle(Holding holding, int level) {
        String template = null;
        switch (level) {
            case 0:
                return "e_" + holding.getHoldingTitle();
            case 1:
                return "k_" + holding.getHoldingTitle();
            case 2:
                return "d_" + holding.getHoldingTitle();
            case 3:
                return "c_" + holding.getHoldingTitle();
            case 4:
                return "b_" + holding.getHoldingTitle();
        }
        return template;
    }

    private static String getTemplateForLevel(int level) {
        String template = null;
        switch (level) {
            case 0:
                template = Defines.empireTemplate;
                break;
            case 1:
                template = Defines.kingdomTemplate;
                break;
            case 2:
                template = Defines.duchyTemplate;
                break;
            case 3:
                template = Defines.countyTemplate;
                break;
            case 4:
                template = Defines.baronyTemplate;
                break;
        }
        return template;
    }

    private static String fillTemplate(String template, Holding holding) {
        template = template.replace("{name}", holding.getHoldingTitle());
        template = template.replace("{red}", holding.red);
        template = template.replace("{green}", holding.green);
        template = template.replace("{blue}", holding.blue);
        if (holding.capital != null) {
            template = template.replace("{capital}", holding.capital.getName());
            template = template.replace("{capitalId}", String.valueOf(holding.capital.id));
            template = template.replace("{culture}", String.valueOf(holding.capital.culture.toLowerCase()));
            template = template.replace("{religion}", String.valueOf(holding.capital.religion.toLowerCase()));
        }
        return template;
    }

    private static void writeProvinceFile(Holding holding) {
        File dest = new File(dir + File.separator + "history" + File.separator + "provinces" + File.separator + holding.id + " - " + holding.getName() + ".txt");
        dest.getParentFile().mkdirs();
        if (!"x".equals(holding.culture)) {
            //if (!dest.exists()) {

            try (
                    BufferedWriter bw = new BufferedWriter(new FileWriter(dest))
            ) {
                String text = Defines.template;
                text = text.replace("{name}", holding.getHoldingTitle());
                text = text.replace("{culture}", holding.culture);
                text = text.replace("{religion}", holding.religion);

                bw.write(text);

            } catch (IOException e) {
                e.printStackTrace();
            }

            // }
        }
    }

}
