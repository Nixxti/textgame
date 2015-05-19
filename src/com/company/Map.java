package com.company;

public class Map {
    int mapWidth, mapHeight;
    Entity[] entities;
    Plant[] plants;
    Tile[][] tileMap;
    String[][] stringMap;
    String[][] experimentMap = new String[][]{
            {"R","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","R"},
            {"G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","R","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"R","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","G","R"}
    };
    //String spacing = "";

    public Map(int width, int height, Entity[] entities, Plant[] plants) {
        this.mapWidth = width;
        this.mapHeight = height;
        this.tileMap = new Tile[height][width];
        this.stringMap = new String[height][width];
        this.entities = entities;
        this.plants = plants;
    }
    /*
    void generateTileMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                tileMap[y][x] = new Tile("Grass");
            }
        }
    }
    */
    void generateTileMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                tileMap[y][x] = new Tile(experimentMap[y][x]);
            }
        }
    }
    void generateStringMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                stringMap[y][x] = tileMap[y][x].printTile();
            }
        }

        for (Plant p : this.plants) {
            if (p.enabled) {
                p.setBgColor(tileMap[p.returnPos().y][p.returnPos().x].tileColor);
                stringMap[p.returnPos().y][p.returnPos().x] = p.printPlant();
            }
        }

        for (Entity e : this.entities) {
            e.setBgColor(tileMap[e.returnPos().y][e.returnPos().x].tileColor);
            stringMap[e.returnPos().y][e.returnPos().x] = e.printEntity();
        }

        printStringMap();
    }

    void printStringMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++){
                System.out.print(stringMap[y][x]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
