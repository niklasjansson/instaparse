# Instaparse 1.4.1 CLR

## How to reproduce bug in CLR.

In this example I tried to use lein clr with the following call:

	lein clr -v compile instaparse.core
        
The following is the result

	[lein-clr] [DEBUG] Running:  "C:\\Users\\Niklas\\Documents\\Egna projekt\\clojur
	e-clr-1.7.0-debug-4.0\\debug 4.0\\Clojure.Compile.exe" "instaparse.core"
	Compiling instaparse.core to C:\Users\Niklas\Documents\Egna projekt\instaparse\t
	arget\clr\binBad type
	System.NullReferenceException: Object reference not set to an instance of an obj
	ect.
	   at clojure.lang.Util.NameForType(Type t) in d:\work\clojure-clr\Clojure\Cloju
	re\Lib\Util.cs:line 769
	   at clojure.lang.Namespace.importClass(Type t) in d:\work\clojure-clr\Clojure\
	Clojure\Lib\Namespace.cs:line 340
	   at instaparse/failure$loading__17861__auto____324__327.invoke() in failure.cl
	j:line 1
	   at clojure.lang.AFn.ApplyToHelper(IFn fn, ISeq argList) in d:\work\clojure-cl
	r\Clojure\Clojure\Lib\AFn.cs:line 189
	   at clojure.lang.AFn.applyTo(ISeq arglist) in d:\work\clojure-clr\Clojure\Cloj
	ure\Lib\AFn.cs:line 178
	   at clojure.lang.CljCompiler.Ast.InvokeExpr.Eval() in d:\work\clojure-clr\Cloj
	ure\Clojure\CljCompiler\Ast\InvokeExpr.cs:line 197, compiling: (failure.clj:1:2)
	
	[lein-clr] [DEBUG] Output closed:  #<PrintWriter java.io.PrintWriter@68e84a9e>
	[lein-clr] [DEBUG] Output closed:  #<OutputStreamWriter java.io.OutputStreamWrit
	er@654029a9>
	1

The changes I made are all in the `auto_flatten_seq.clj` file. There are three kinds of changes:

1. To implement `object` I needed to rename hashCode, toString and equals.
2. I commented out all java collection classes
3. I commented out the cons call since it wanted type hints, and as a first attempt it was easier to remove them.

