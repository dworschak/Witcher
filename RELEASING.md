This page lists the steps to perform a new release of the mod.

1. Update [MOD/Witcher/changelog.txt](MOD/Witcher/changelog.txt) with release version and date, compatible vanilla version, list of features & bugfixes.
2. Check that [MOD/Witcher/credits.txt](MOD/Witcher/credits.txt) is up-to-date.
3. Launch the game with vanilla only and verify the in-game checksum matches the one from the launcher (otherwise verify game files integrity in Steam).
4. Launch the game with vanilla + Witcher Kings mod (and no other mod) and note down the checksum.
5. Update the supported_checksums in Witcher.mod file, replacing with the new checksum
6. Copy the modified [MOD/Witcher/Witcher.mod](MOD/Witcher/Witcher.mod) file from git, launch the game again, and verify that the on-startup checksum warning doesn't popup, even when the associated game rule is active.
7. Commit the changes above
> git commit -m "Prepare release v0.M.m"
8. Tag the previous commit:
> git tag v0.M.m
and push:
> git push --tags
9. On github releases, click "Draft a new release" with name "v0.M.m" and copy/paste the changelog.
10. Zip [MOD/Witcher/](MOD/Witcher/), [MOD/Witcher_Font/](MOD/Witcher_Font/), [MOD/Witcher.mod](MOD/Witcher.mod) and [MOD/Witcher_Font.mod](MOD/Witcher_Font.mod) into Witcher_Kings_0.M.m.zip
11. Generate the Windows installer:
	1. Install [NSIS Unicode 2.46.5](https://code.google.com/p/unsis/downloads/list)
	2. Right-click [MOD/setup.nsi](MOD/setup.nsi) and select "Compile Unicode NSIS Script"
	3. Wait for packaging
	4. Rename Witcher_Kings.exe into Witcher_Kings_0.M.m.exe
12. Zip the .exe into Witcher_Kings_0.M.m.exe.zip, as the forum doesn't allow .exe extensions
13. Upload manual zip install and Windows installer
14. Update the [Wiki page](https://ck2.paradoxwikis.com/Witcher_Kings) with new version and features
15. Advertise the release ([/r/CrusaderKings](https://www.reddit.com/r/CrusaderKings), Moddb news article, ...). For major releases consider also x-posting to [r/witcher/](https://www.reddit.com/r/witcher/).
16. Relax :-)