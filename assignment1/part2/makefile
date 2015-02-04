default:
	mkdir -p build
	fpc src/stripper.pas -FEbuild

test: build/stripper
	cat tests/program.c | build/stripper

clean:
	rm -fr build
