package oop.lection8;

abstract class Building {
    String base;
    String walls;
    String roof;

    abstract public void setBase(String base);
    abstract public void setWalls(String walls);
    abstract public void setRoof(String roof);
}


class Cottage extends Building {
    @Override
    public void setBase(String base) {
        /* any cottage contructing logic */
        this.base = base;
    }

    @Override
    public void setWalls(String walls) {
        /* any cottage contructing logic */
        this.walls = walls;
    }

    @Override
    public void setRoof(String roof) {
        /* any cottage contructing logic */
        this.roof = roof;
    }
}

class Skyscraper extends Building {
    @Override
    public void setBase(String base) {
        /* any skyscraper contructing logic */
        this.base = base;
    }

    @Override
    public void setWalls(String walls) {
        /* any skyscraper contructing logic */
        this.walls = walls;
    }

    @Override
    public void setRoof(String roof) {
        /* any skyscraper contructing logic */
        this.roof = roof;
    }
}

abstract class BUilder {
    Building building;
    public Building getBuilding() {
        return building;
    }

    abstract public void buildBase();
    abstract public void buildWall();
    abstract public void buildRoof();
}

class CottageBuilder extends BUilder {

    public CottageBuilder() {
        this.building = new Cottage();
    }

    @Override
    public void buildBase() {
        building.setBase("base");
    }

    @Override
    public void buildWall() {
        building.setWalls("walls");
    }

    @Override
    public void buildRoof() {
        building.setRoof("roof");
    }
}

class SkyscraperBuilder extends BUilder {

    public SkyscraperBuilder() {
        this.building = new Skyscraper();
    }

    @Override
    public void buildBase() {
        building.setBase("base");
    }

    @Override
    public void buildWall() {
        building.setWalls("walls");
    }

    @Override
    public void buildRoof() {
        building.setRoof("roof");
    }
}

class Formen {
    BUilder bUilder;

    public Formen(BUilder bUilder) {
        this.bUilder = bUilder;
    }

    public void createBuilding() {
        bUilder.buildBase();
        bUilder.buildWall();
        bUilder.buildRoof();
    }
}
// Allow build different types with the same algorithm of constructing
public class Builder {
    public static void main(String[] args) {
        BUilder builder = new CottageBuilder();
        Formen formen = new Formen(builder);
        formen.createBuilding();
        Building building = builder.getBuilding();
    }
}
