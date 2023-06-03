package org.example;

public class AsciiPanel {
    private static final int WIDTH = 80;
    private static final int HEIGHT = 24;
    private char[][] panel;

    public AsciiPanel() {
        panel = new char[HEIGHT][WIDTH];
        clear();
    }

    public void clear() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                panel[y][x] = ' ';
            }
        }
    }

    public void setChar(int x, int y, char ch) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            panel[y][x] = ch;
        }
    }

    public void display() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(panel[y][x]);
            }
            System.out.println();
        }
    }
}

