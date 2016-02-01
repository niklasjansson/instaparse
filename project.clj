(defproject instaparse "1.4.1"
  :description "Instaparse: No grammar left behind"
  :url "https://github.com/Engelberg/instaparse"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:dependencies 
                   [[org.clojure/tools.trace "0.7.5"]
                    [criterium "0.3.1"]
                    [rhizome "0.2.5"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0-RC2"]]}}
  :aliases {"test-all" ["with-profile" "+1.5:+1.6:+1.7" "test"]}
  :test-paths ["test"]
  :target-path "target"
  :scm {:name "git"
        :url "https://github.com/Engelberg/instaparse"}


  :plugins [[lein-clr "0.2.1"]]
  :clr {:cmd-templates  {:clj-exe   [[?PATH "mono"] [CLJCLR17_40 %1]]
                         :clj-dep   [[?PATH "mono"] ["target/clr/clj/Debug 4.0" %1]]
                         :clj-url   "http://sourceforge.net/projects/clojureclr/files/clojure-clr-1.7.0-Debug-4.0.zip/download"
                         :clj-zip   "clojure-clr-1.7.0-Debug-4.0.zip"
                         :curl      ["curl" "--insecure" "-f" "-L" "-o" %1 %2]
                         :nuget-ver [[?PATH "mono"] [*PATH "nuget.exe"] "install" %1 "-Version" %2]
                         :nuget-any [[?PATH "mono"] [*PATH "nuget.exe"] "install" %1]
                         :unzip     ["unzip" "-d" %1 %2]
                         :wget      ["wget" "--no-check-certificate" "--no-clobber" "-O" %1 %2]}
        ;; for automatic download/unzip of ClojureCLR,
        ;; 1. make sure you have curl or wget installed and on PATH,
        ;; 2. uncomment deps in :deps-cmds, and
        ;; 3. use :clj-dep instead of :clj-exe in :main-cmd and :compile-cmd
        :deps-cmds      [; [:wget  :clj-zip :clj-url] ; edit to use :curl instead of :wget
                         ; [:unzip "../clj" :clj-zip]
                         ]
        :main-cmd      [:clj-exe "Clojure.Main.exe"]
        :compile-cmd   [:clj-exe "Clojure.Compile.exe"]})
