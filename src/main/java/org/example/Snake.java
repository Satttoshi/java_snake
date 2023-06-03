package org.example;

public class Snake {

    public static AsciiPanel panel = new AsciiPanel();

    public Snake () {
        panel.setChar(headX, headY, 'O');
        panel.display();
        start();
    }

    private Direction direction;
    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

private int headX = 22;
private int headY = 7;

    public static void start() {
        // Create a new thread for the update loop
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    // Your method code goes here
                    update();

                    // Sleep for 100 milliseconds
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the update loop thread
        updateThread.start();
    }

    private static void update() {
        panel.display();
    }

}
