package net.lafox.jdk;

interface Jdk9InterfaceWithPrivateMethods {

    private static String staticPrivate() {
        return "static private";
    }

    private String instancePrivate() {
        return "instance private";
    }

    default void check() {
        String result = staticPrivate();
        Jdk9InterfaceWithPrivateMethods pvt = new Jdk9InterfaceWithPrivateMethods() {
            // anonymous class
        };
        result = pvt.instancePrivate();
    }
}
