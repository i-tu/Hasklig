_N.B. This is a fork of the_ [Source Code Pro repository](https://github.com/adobe/source-code-pro)

Programming languages are limited to relatively few characters. As a result of a limited character set, combined character operators surfaced quite early, such as the widely used arrow (`->`), comprised of a hyphen and greater sign. It looks like an arrow if you know the analogy and squint a bit.

Composite glyphs become especially  problematic in languages such as Haskell which utilize these complicated operators (`<-`, `::`, `=>`, `-<`, `>>=` etc.) extensively (over 100 in `lens` alone!). Prettified code improves readability considerably - some Haskell programmers have even resorted to unicode symbols (ie. `⇒`, `←` etc.). This merely opens a whole new can of worms. In addition to encoding/compatibility problems and all the reasons it never worked out in APL, these symbols are one-character-wide and therefore eye-strainingly small.

Source Code Pro L solves this problem the way typographers have always solved ill-fitting characters which co-occur often: ligatures.

####Source Code Pro L with ligature support
![Source Code Pro L Sample](SourceCodeProLSample.png?raw=true)

####Source Code Pro
![Source Code Pro Sample](SourceCodeProSample.png?raw=true)


[Download OTF font](https://github.com/i-tu/source-code-pro-L/releases/download/v0.1/SourceCodeProL.zip)

## Support 

TextEdit, Atom and the Haskell IDE Leksah support OpenType. Support is missing from many popular editors though, such as Sublime Text and terminal-based editors such as Vim.
