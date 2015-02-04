default:
	mkdir -p build
	fpc src/stripper.pas -FEbuild
	touch build/lex.yy.c
	lex -o build/lex.yy.c src/stripper.lex
	gcc ./build/lex.yy.c -o build/lex_stripper -lfl

test: build/stripper
	cat tests/program.c | build/stripper > build/stripped_pas
	cat tests/program.c | build/lex_stripper > build/stripped_lex
	diff -wB build/stripped_pas build/stripped_lex

clean:
	rm -fr build
