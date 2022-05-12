package edu.school21.printer.app;

class NotValidArgumentException extends RuntimeException {
    public NotValidArgumentException() {

        System.err.println("Not valid argument");
    }
}
