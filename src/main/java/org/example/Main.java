package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Router router = new RouterImpl();
        router.withRoute("/bar", "Ravi");
        System.out.println(router.route("/bar")); // -> "Ravi"
    }
}