@echo off
javac -d . *.java
rmic HangmanImpl
start rmiregistry
