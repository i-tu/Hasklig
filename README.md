_N.B. This is a fork of the_ [Source Code Pro repository](https://github.com/adobe/source-code-pro)

### Hasklig - _Ligatures for Haskell code_

Programming languages are limited to relatively few characters. As a result, combined character operators surfaced quite early, such as the widely used arrow (`->`), comprised of a hyphen and greater sign. It looks like an arrow if you know the analogy and squint a bit.

Composite glyphs are problematic in languages such as Haskell which utilize these complicated operators (`=>` `-<` `>>=` etc.) extensively. The readability of such complex code improves with pretty printing. Academic articles featuring Haskell code often use [lhs2tex](http://www.andres-loeh.de/lhs2tex/) to achieve an appealing rendering, but it is of no use when programming.

Some Haskellers have resorted to Unicode symbols (`⇒`, `←` _etc._), which are valid in the <span style="font-variant: small-caps">ghc</span>. However they are one-character-wide and therefore eye-strainingly small. Furthermore, when displayed as substitutes to the underlying multi-character representation, as [vim2hs] (https://github.com/dag/vim2hs) does, the characters go out of alignment.

Hasklig solves the problem the way typographers have always solved ill-fitting characters which co-occur often: [ligatures](http://en.wikipedia.org/wiki/Typographic_ligature). The underlying code stays the same — only the representation changes.

Not only can multi-character glyphs be rendered more vividly, other problematic things in monospaced fonts, such as spacing can be corrected.

[**Download Hasklig Font Family v0.4**](https://github.com/i-tu/Hasklig/releases/download/0.4/Hasklig-0.4.zip)

#### Hasklig
![Hasklig Sample](hasklig_example.png?raw=true)

#### Source Code Pro
![Source Code Pro Sample](SourceCodeProSample.png?raw=true)

#### Credits
Original idea, design and implementation of code ligatures by Ian Tuomi 2014-2015.
This typeface extends [Source Code Pro](https://github.com/adobe-fonts/source-code-pro) with ligatures.

### Release notes 
+ v0.4: New ligatures: `<*` `<*>` `<+>` `<$>` `***`  `<|>` `!!` `||` `===` `==>`,  [Powerline](https://github.com/Lokaltog/powerline) symbol support
+ v0.3: New ligatures: `<<<` `>>>` `<>` and `+++`
+ v0.2: Lengthened `==` and `/=` to match other equals signs
+ v0.1: Ligatures `<-` `->` `=>` `>>` `<<` `>>=` `=<<` `..` `...` `::` `-<` `>-` `-<<` `>>-` `++` `/=` and `==`

#### Currently implemented symbols
`<*` `<*>` `<+>` `<$>` `***`  `<|>` `!!` `||` `===` `==>` `<<<` `>>>` `<>` `+++` `<-` `->` `=>` `>>` `<<` `>>=` `=<<` `..` `...` `::` `-<` `>-` `-<<` `>>-` `++` `/=` `==`

#### Editor Support
+ BBEdit 11 ([Instructions](https://github.com/i-tu/Hasklig/issues/3#issue-46601683))
+ Chocolat
+ Geany
+ gEdit
+ Kate
+ Konsole
+ KWrite
+ Leksah (_x64 W8 reported not working_)
+ Light Table ([Instructions](https://github.com/LightTable/LightTable/issues/1459#issuecomment-57366504))
+ QtCreator (_v.3.2.2 on GNU/Linux x64_)
+ Smultron
+ TextEdit
+ TextMate (_from version 2.0-alpha.9549 onwards_)
+ Vico

#### No support
Some editors have replaced standard font rendering engines with custom ones and don't support ligatures.
https://github.com/atom/atom/issues/3821
- Atom (_see [Atom issue #3821](https://github.com/atom/atom/issues/3821) for more details._)
- Emacs (_Support is currently under work._)
- gVim (_output corrupted. A_ [patch](https://groups.google.com/forum/#!topic/vim_dev/0sETSAwe5Wo) _exists, but it has not been incorporated into mainstream gVim._)
- Intellij IDEA ([Has feature request](https://youtrack.jetbrains.com/issue/IDEA-127539))
- iTerm2 ([details](https://gitlab.com/gnachman/iterm2/issues/3568))
- MacVim (_Reversing_ [this commit](https://github.com/b4winckler/macvim/commit/8c8db3cd4cb094535ecb0254a7fb2e15be31d4fd) _makes ligatures show, but advancement is borked._) 
- Sublime Text (_Vote for the enhancement_ [**here**](http://sublimetext.userecho.com/topic/433445-/))
- Terminal (OSX)
