#!/usr/bin/env sh

family=Hasklig
set -e

roman_weights=(Black Bold ExtraLight Light Medium Regular Semibold)
italic_weights=(BlackIt BoldIt ExtraLightIt LightIt MediumIt It SemiboldIt)

# get absolute path to bash script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

# clean existing build artifacts
rm -rf $DIR/target/
otf_dir="$DIR/target/OTF"
mkdir -p $otf_dir

function build_font {
    # $1 is Roman or Italic
    # $2 is weight name
    font_dir=$DIR/$1/$2
    font_ufo=$font_dir/font.ufo
    ps_name=$family-$2
    echo $ps_name
    echo "Building OTF ..."
    # -r is for "release mode"
    # (subroutinization + applied glyph order)
    makeotf -f $font_ufo -r -omitMacNames

    # move font files to target directory
    mv $font_dir/$ps_name.otf $otf_dir
    echo "Done with $ps_name"
    echo ""
    echo ""
}

for w in ${roman_weights[@]}
do
    build_font Roman $w
done

for w in ${italic_weights[@]}
do
    build_font Italic $w
done
