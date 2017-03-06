package oop.homework.patterns.battleships;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private Field.Cell[] cells;
    private int size;

    public Ship(int size) {
        this.size = size;
        cells = new Field.Cell[this.size];
    }

    public int getSize() {
        return size;
    }

    public void setCells(Field.Cell... cells) {
        if (cells.length != size) {
            throw new IllegalArgumentException();
        }

        for (Field.Cell cell : cells) {
            if (cell.isEngaged()) {
                throw new IllegalArgumentException();
            }
        }

        List<Integer> vertical = new ArrayList<>();
        List<Integer> horizontal = new ArrayList<>();
        for (Field.Cell cell : cells) {
            if (cell.getVertical() != cells[0].getVertical()
                    && cell.getHorizontal() != cells[0].getHorizontal()) {
                throw new IllegalArgumentException();
            }
            vertical.add(cell.getVertical());
            horizontal.add(cell.getHorizontal());
        }

        checkSpaces(vertical);
        checkSpaces(horizontal);

        this.cells = cells;
        for (Field.Cell cell : cells) {
            cell.engage();
        }
    }

    public Field.Cell[] getCells() {
        return cells;
    }

    private void checkSpaces(List<Integer> values) {
        Integer prev;
        values.sort(Integer::compareTo);
        prev = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            if (Math.abs(prev - values.get(i)) > 1) {
                throw new IllegalArgumentException();
            }
            prev = values.get(i);
        }
    }

    public boolean isAlive() {
        for (Field.Cell cell : cells) {
            if (!cell.isShooted()) {
                return true;
            }
        }

        return false;
    }
}
