
### Run dirac

```bash
./lein figwheel
./lein repl
```

### Emacs Cider connect

* `(rename-buffer "*cider-repl localhost(cljs)*")`
* C-xC-e的第一次就会发送ns头过去,后面就不会了=> 所以需要暂时注释一些dirac devtool上面repl不过的东西(实际是可以引用的)

```txt
user> (dirac!)
You can control Dirac REPL via special `dirac` command:

  `(dirac <action> [arg1] [arg2] [...])`

The argument `action` is a keyword followed by optional arguments.

List of supported actions:

  `:status`     print current session state
  `:ls`         list available sessions/compilers

  `:switch`     switch ClojureScript compiler
  `:spawn`      start a new ClojureScript compiler
  `:kill`       kill ClojureScript compiler

  `:join`       join a Dirac session
  `:disjoin`    disjoin Dirac session
  `:match`      list matching Dirac sessions

  `:fig`        Figwheel REPL API bridge

  `:version`    print version info
  `:help`       print usage help

For more information use `(dirac :help <action>)`.
Also note that outer-most parentheses are optional. You may also alternatively use `dirac!`.
user> 
user> 
user> (dirac! :ls)
Listing all Dirac sessions currently connected to your nREPL server:
    #1 blockly-games-by-clojurescript-reagent | http://localhost:3449/index.html | Chrome/75.0.3759.0 | Mac/10.14.4 [7fe75a73]

Listing all ClojureScript compilers currently available in your nREPL server:
    #1 dirac/7fe75a73.1
cljs.user> 
cljs.user> (js/alert 321312)
CompilerException java.lang.RuntimeException: No such namespace: js, compiling:(*cider-repl localhost*:84:11) 
cljs.user> 
cljs.user> 
cljs.user> (dirac! :join 1)
Specific target Dirac session will be determined dynamically according to current matching strategy.
Your current nREPL session is a joined Dirac session (ClojureScript) which targets 'the Dirac session #1'
which is currently forwarding commands to the Dirac session (ClojureScript) connected to 'blockly-games-by-clojurescript-reagent | http://localhost:3449/index.html | Chrome/75.0.3759.0 | Mac/10.14.4 [7fe75a73]'
with selected ClojureScript compiler nil (any available) which is currently matching compiler <dirac/7fe75a73.1>.
To quit, type: :cljs/quit
cljs.user> (dirac! :join 1)
Specific target Dirac session will be determined dynamically according to current matching strategy.
Your current nREPL session is a joined Dirac session (ClojureScript) which targets 'the Dirac session #1'
which is currently forwarding commands to the Dirac session (ClojureScript) connected to 'blockly-games-by-clojurescript-reagent | http://localhost:3449/index.html | Chrome/75.0.3759.0 | Mac/10.14.4 [7fe75a73]'
with selected ClojureScript compiler nil (any available) which is currently matching compiler <dirac/7fe75a73.1>.
To quit, type: :cljs/quit
cljs.user> (js/alert 312321)
nil
cljs.user> ;; 上面的执行成功了
cljs.user> (+ 1 2)
3
cljs.user> ;; 成功同步到了dirac的devtools上面了
cljs.user> 
```
