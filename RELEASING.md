This page lists the steps to perform a new release of the mod.

1. Update the changelog.txt with release version and date, compatible vanilia version, list of features & bugfixes.
2. Check that [MOD/Witcher/credits.txt](MOD/Witcher/credits.txt) is up-to-date.
3. Launch the game with vanilla + Witcher Kings mod (and no other mod) and note down the checksum
4. Update the supported_checksums in Witcher.mod file, replacing with the new checksum
5. Copy the modified .mod file from git, launch the game again, and verify that the on-startup checksum warning doesn't popup, even when the associated game rule is active.
6. Commit the changes above
7. Tag the previous commit:
> git tag v0.M.m
8. On github releases, click "Draft a new release" with name "v0.M.m" and copy/paste the changelog.
9. Zip [MOD/Witcher/](MOD/Witcher/) and [MOD/Witcher.mod](MOD/Witcher.mod) into Witcher_Kings_0.M.m.zip
10. Generate the Windows installer:
	1. Install [NSIS Unicode 2.46.5](https://code.google.com/p/unsis/downloads/list)
	2. Right-click [MOD/setup.nsi](MOD/setup.nsi) and select "Compile Unicode NSIS Script"
	3. Wait for packaging
	4. Rename Witcher_Kings.exe into Witcher_Kings_0.M.m.exe
11. Zip the .exe into Witcher_Kings_0.M.m.exe.zip, as the forum doesn't allow .exe extensions
12. Upload manual zip install and Windows installer
13. Update the [Wiki page](http://www.ckiiwiki.com/Witcher_Kings)
14. Advertise the release ([/r/CrusaderKings](https://www.reddit.com/r/CrusaderKings), Moddb news article, ...). For major releases consider also x-posting to [r/witcher/](https://www.reddit.com/r/witcher/).
15. Relax :-)