package oop.homework.patterns.battleships;

public abstract class Player {
    protected Field ownField;
    protected Field enemyField;
    protected Ship[] ships = new Ship[SHIPS_COUNT];

    private static int SHIPS_COUNT = 10;

    public Player() {
        for (int i = 0; i < 10; i++) {
            ships[i] = new Ship(Game.getShipsSizes()[i]);
        }
    }

    public Field getOwnField() {
        return ownField;
    }

    public void setOwnField(Field ownField) {
        this.ownField = ownField;
    }

    public Field getEnemyField() {
        return enemyField;
    }

    public void setEnemyField(Field enemyField) {
        this.enemyField = enemyField;
    }

    public Ship[] getShips() {
        return ships;
    }

    public boolean isСombating() {
        for (Ship ship : ships) {
            if (ship.isAlive()) {
                return true;
            }
        }
        return false;
    }

    abstract public void placeShips();
    abstract public void takeTurn();
}
