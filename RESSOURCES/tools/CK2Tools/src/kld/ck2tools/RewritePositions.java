package kld.ck2tools;

import java.io.*;

/**
 * User: Klaus
 * Date: 06.04.13
 */
public class RewritePositions {

    public static final String template = "{provinceId} = { \n" +
            "    position = {  \n" +
            "\t\t{pos1X} {pos1Y} {pos2X} {pos2Y} {pos3X} {pos3Y} {pos4X} {pos4Y} {pos5X} {pos5Y}    \n" +
            "\t} \n" +
            "\trotation=\t{\t\t\n" +
            "\t\t0.000 0.000 0.000 0.000 0.000 \t\n" +
            "\t}\t\n" +
            "\theight=\t{\t\t\n" +
            "\t\t0.000 0.000 0.000 20.000 0.000 \t\n" +
            "\t}\n" +
            "}\n\n";

    public static void main(String[] args) {
        if (true) return;

        File src = new File("E:\\Documents\\Paradox Interactive\\Crusader Kings II\\Witcher\\logs\\graphics.log");
        File dest = new File(ConvertCsvToProvinces.dir + File.separator + "map" + File.separator + "positions.txt");

        try (
                BufferedReader br = new BufferedReader(new FileReader(src));
                BufferedWriter bw = new BufferedWriter(new FileWriter(dest))
        ) {

            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder builder = new StringBuilder(line);
                builder.delete(0, 37);

                int after = builder.indexOf(" ");
                String id = builder.substring(0, after);
                builder.delete(0, after);
                builder.delete(0, builder.indexOf(",") + 1);
                String xse = builder.substring(builder.indexOf(":") + 2, builder.indexOf(","));
                builder.delete(0, builder.indexOf(",") + 1);
                String yse = builder.substring(builder.indexOf(":") + 2, builder.indexOf("("));

                String filledTemplate = template;

                filledTemplate = filledTemplate.replace("{provinceId}", id);

                float x = Float.parseFloat(xse);
                float y = Float.parseFloat(yse);

                /*int after = builder.indexOf(" ");
                String id = builder.substring(0, after);
                builder.delete(0, after);
                builder.delete(0, builder.indexOf("(") + 11);
                String xse = builder.substring(0, builder.indexOf(","));
                builder.delete(0, builder.indexOf(":") + 2);
                String yse = builder.substring(0, builder.indexOf(")"));

                int xMin = Integer.parseInt(xse.substring(0, xse.lastIndexOf("-")));
                int xMax = Integer.parseInt(xse.substring(xse.lastIndexOf("-") + 1));
                int yMin = Integer.parseInt(yse.substring(0, yse.lastIndexOf("-")));
                int yMax = Integer.parseInt(yse.substring(yse.lastIndexOf("-") + 1));

                System.out.println(id + " / " + xMin + " / " + xMax + " / " + yMin + " / " + yMax);

                String filledTemplate = template;

                filledTemplate = filledTemplate.replace("{provinceId}", id);

                int x = (xMax - xMin) / 2 + xMin;
                int y = 2048 - ((yMax - yMin) / 2 + yMin);    */

                filledTemplate = filledTemplate.replace("{pos1X}", String.valueOf(x));
                filledTemplate = filledTemplate.replace("{pos1Y}", String.valueOf(y));
                filledTemplate = filledTemplate.replace("{pos2X}", String.valueOf(x));
                filledTemplate = filledTemplate.replace("{pos2Y}", String.valueOf(y));
                filledTemplate = filledTemplate.replace("{pos3X}", String.valueOf(x));
                filledTemplate = filledTemplate.replace("{pos3Y}", String.valueOf(y));
                filledTemplate = filledTemplate.replace("{pos4X}", String.valueOf(x));
                filledTemplate = filledTemplate.replace("{pos4Y}", String.valueOf(y));
                filledTemplate = filledTemplate.replace("{pos5X}", String.valueOf(x));
                filledTemplate = filledTemplate.replace("{pos5Y}", String.valueOf(y));

                bw.write(filledTemplate);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
