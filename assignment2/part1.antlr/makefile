ANTLR4=java -Xmx500M -cp "/usr/local/lib/antlr-4.5-complete.jar:$$CLASSPATH" org.antlr.v4.Tool

default: antlr
	mkdir -p bin
	javac -d bin -sourcepath src src/com/pascalindent/PascalIndent.java

antlr:
	$(ANTLR4) src/com/pascalindent/antlr/Pascal0.g4 -package com.pascalindent.antlr

run:
	cd bin && java com.pascalindent.PascalIndent

clean:
	rm -fr bin
	rm -fr src/com/pascalindent/antlr/*.java
	rm -fr src/com/pascalindent/antlr/*.class
	rm -fr src/com/pascalindent/antlr/*.tokens
