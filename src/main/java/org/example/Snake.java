package org.example;

import java.util.LinkedList;

public class Snake {
    private AsciiPanel panel;
    private LinkedList<Point> snake;
    private Point food;
    private Direction direction;

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Snake() {
        panel = new AsciiPanel(80, 24);
        snake = new LinkedList<>();
        snake.add(new Point(40, 12));
        food = generateFood();
        direction = Direction.RIGHT;
    }

    public void start() {
        boolean running = true;
        while (running) {
            update();
            render();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isGameOver()) {
                running = false;
            }
        }
    }

    private void update() {
        Point head = snake.getFirst();
        Point newHead = new Point(head.x, head.y);

        switch (direction) {
            case UP -> newHead.y--;
            case DOWN -> newHead.y++;
            case LEFT -> newHead.x--;
            case RIGHT -> newHead.x++;
        }

        if (newHead.x == food.x && newHead.y == food.y) {
            snake.addFirst(newHead);
            food = generateFood();
        } else {
            snake.removeLast();
            snake.addFirst(newHead);
        }

        if (snake.size() > 1 && isCollision(newHead)) {
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    private void render() {
        panel.clear();

        for (Point point : snake) {
            panel.setChar(point.x, point.y, '#');
        }

        panel.setChar(food.x, food.y, '@');

        panel.display();

    }

    private Point generateFood() {
        int x = (int) (Math.random() * panel.getWidth());
        int y = (int) (Math.random() * panel.getHeight());
        return new Point(x, y);
    }

    private boolean isCollision (Point head) {
        for (Point point : snake) {
            if (point != head && point.x == head.x && point.y == head.y) {
                return true;
            }
        }
        return false;
    }

    private boolean isGameOver() {
        Point head = snake.getFirst();
        int x = head.x;
        int y = head.y;
        return x < 0 || x >= panel.getWidth() || y < 0 || y >= panel.getHeight();
    }
}
