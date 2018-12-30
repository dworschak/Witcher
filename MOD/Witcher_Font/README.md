Open thewitcher.ttf in [Hiero](https://github.com/libgdx/libgdx/wiki/Hiero) and put the following settings:

- Size: 100
- Rendering: Java
- Glyph cache: Page height & width 1024
- Effects: 
  - Distance field:
    - Color: white
    - Scale 5
    - Spread: 3.0
  - Color (black)
- Padding: 2,2,2,2 
- Spacing: 1,1

Click on Save BMFont files (text).

Open generated thewitcher.fnt (rename to Mapfont.fnt):

- Add charset="ANSI"
- Remove unicode=0
- Remove packed=0
- Remove the lines page and chars
- Remove chnl=0 column
- Add mapping for accentuated letters, to use their non-accentuated equivalent.

Open generated thewitcher.png:

- Make the letters transparent (in GIMP: Color Tools / Levels)
- Export to Mapfont.dds (use DTX5 compression)

The font doesn't support some ANSI characters (oe,ae, ...), so some province and title localization is overridden.