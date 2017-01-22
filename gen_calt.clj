(comment "
  Modified 2016 under the terms of SIL for use in Hasklig.
  Ian Tuomi

  Copyright (c) 2014, Nikita Prokopov http://tonsky.me
  with Reserved Font Name Fira Code.

  Copyright (c) 2014, Mozilla Foundation https://mozilla.org/
  with Reserved Font Name Fira Sans.

  Copyright (c) 2014, Mozilla Foundation https://mozilla.org/
  with Reserved Font Name Fira Mono.

  Copyright (c) 2014, Telefonica S.A.

  This Font Software is licensed under the SIL Open Font License, Version 1.1.
  This license is copied below, and is also available with a FAQ at:
  http://scripts.sil.org/OFL
")


#^:shebang '[
              exec java -cp "$HOME/.m2/repository/org/clojure/clojure/1.7.0/clojure-1.7.0.jar" clojure.main "$0" "$@"]


(require '[clojure.string :as str])

(def ligas
   [ ["asterisk" "asterisk" "asterisk"]
     ;["bar" "bar" "bar"]
     ["colon" "colon" "colon"]
     ["equal" "equal" "equal"]
     ["equal" "equal" "greater"]
     ["equal" "less" "less"]
     ["greater" "greater" "equal"]
     ["greater" "greater" "greater"]
     ["greater" "greater" "hyphen"]
     ["hyphen" "greater" "greater"]
     ["hyphen" "less" "less"]
     ["less" "asterisk" "greater"]
     ["less" "bar" "greater"]
     ["less" "dollar" "greater"]
     ["less" "equal" "greater"]
     ["less" "equal" "less"]
     ["less" "hyphen" "greater"]
     ["less" "plus" "greater"]
     ["less" "less" "less"]
     ["period" "period" "period"]
     ["plus" "plus" "plus"]
     ["asterisk" "greater"]
     ["backslash" "backslash"]
     ["bar" "bar"]
     ["bar" "greater"]
     ["colon" "colon"]
     ["equal" "equal"]
     ["equal" "greater"]
     ["exclam" "exclam"]
     ["greater" "equal" "greater"]
     ["greater" "greater"]
     ["greater" "hyphen"]
     ["hyphen" "greater"]
     ["hyphen" "less"]
     ["less" "asterisk"]
     ["less" "greater"]
     ["less" "bar"]
     ["less" "hyphen"]
     ["less" "less"]
     ["period" "period"]
     ["plus" "plus"]
     ["slash" "equal"]])

     (def ignores
       { ["slash" "asterisk"]
         (str
           "    ignore sub slash' asterisk slash;\n"
           "    ignore sub asterisk slash' asterisk;\n")

         ["asterisk" "slash"]
         (str
           "    ignore sub slash asterisk' slash;\n"
           "    ignore sub asterisk' slash asterisk;\n")

         ["asterisk" "asterisk"]
         (str
           "    ignore sub slash asterisk' asterisk;\n"
           "    ignore sub asterisk' asterisk slash;\n")

         ["asterisk" "asterisk" "asterisk"]
         (str
           "    ignore sub slash asterisk' asterisk asterisk;\n"
           "    ignore sub asterisk' asterisk asterisk slash;\n")

         })

     (defn liga->rule
       "[f f i] => { [LIG LIG i] f_f_i
                     [LIG   f i] LIG
                     [ f    f i] LIG }"
       [liga]
       (case (count liga)
         2 (let [[a b] liga]
             (str/replace
               (str "  lookup 1_2 {\n"
                    "    ignore sub 1 1' 2;\n"
                    "    ignore sub 1' 2 2;\n"
                    (get ignores liga)
                    "    sub LIG 2' by 1_2;\n"
                    "    sub 1'  2  by LIG;\n"
                    "  } 1_2;")
               #"\d" {"1" a "2" b}))
         3 (let [[a b c] liga]
             (str/replace
               (str "  lookup 1_2_3 {\n"
                    "    ignore sub 1 1' 2 3;\n"
                    "    ignore sub 1' 2 3 3;\n"
                    (get ignores liga)
                    "    sub LIG LIG 3' by 1_2_3;\n"
                    "    sub LIG  2' 3  by LIG;\n"
                    "    sub 1'   2  3  by LIG;\n"
                    "  } 1_2_3;")
               #"\d" {"1" a "2" b "3" c}))
         4 (let [[a b c d] liga]
             (str/replace
               (str "  lookup 1_2_3_4 {\n"
                    "    ignore sub 1 1' 2 3 4;\n"
                    "    ignore sub 1' 2 3 4 4;\n"
                    (get ignores liga)
                    "    sub LIG LIG LIG 4' by 1_2_3_4;\n"
                    "    sub LIG LIG  3' 4  by LIG;\n"
                    "    sub LIG  2'  3  4  by LIG;\n"
                    "    sub 1'   2   3  4  by LIG;\n"
                    "  } 1_2_3_4;")
               #"\d" {"1" a "2" b "3" c "4" d}))))

     (println (->> ligas (sort-by count) (reverse) (map liga->rule) (str/join "\n\n")))
