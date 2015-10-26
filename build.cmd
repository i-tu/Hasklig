@echo off
SET family=Hasklig
SET weights=Black Bold ExtraLight Light Medium Regular Semibold

rem clean existing build artifacts
rmdir /s /q target
mkdir target

for %%w in (%weights%) do (
    makeotf -f Roman\%%w\font.pfa -r -o target/%family%-%%w.otf && del Roman\%%w\current.fpr
    rem  makeotf -f Roman/$w/font.ttf -gf GlyphOrderAndAliasDB_TT -r -o target/TTF/$family-$w.ttf
)



