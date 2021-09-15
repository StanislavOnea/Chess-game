JFLAGS = -g
JC = javac
.SUFFIXES: .java .class


.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java 

default: build

build: $(CLASSES:.java=.class)

clean:
	$(RM) -r ./*.class ./*/*.class
	
run:
	java Main
	
