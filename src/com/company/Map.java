package com.company;

public class Map {
    int mapWidth, mapHeight;
    Entity[] entities;
    Plant[] plants;
    Tile[][] tileMap;
    String[][] stringMap;
    String[][] experimentMap = new String[][]{// G = Grass, R = Rock, W = Floor, F = Water, B = Bridge
            {"R","R","R","R","R","R","R","F","G","G","G","G","G","G","G","G","G","G","G","R"},
            {"R","W","W","W","R","W","R","F","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"R","W","W","W","W","W","R","F","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"R","R","R","R","R","W","R","F","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","R","W","R","F","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","R","W","R","F","F","F","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","F","G","F","F","G","G","G","G","G","G","G","G","G"},
            {"F","F","F","B","F","F","G","F","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","F","F","F","F","F","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","F","G","F","G","F","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","F","G","F","G","F","F","F","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","F","G","B","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"F","F","F","B","F","F","G","F","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","F","G","G","G","G","G","G","G","G","G","G","G","G"},
            {"G","G","G","G","G","G","G","F","G","R","R","R","R","R","G","R","R","R","R","R"},
            {"G","G","G","G","G","G","G","F","G","R","W","W","W","R","G","R","W","W","W","R"},
            {"G","G","G","G","G","G","G","F","F","R","W","W","W","R","G","R","W","W","W","R"},
            {"G","G","G","G","G","G","G","G","G","R","W","W","W","R","G","R","R","R","W","R"},
            {"G","G","G","G","G","G","G","G","G","R","W","W","W","W","G","G","G","G","G","R"},
            {"R","G","G","G","G","G","G","G","G","R","R","R","R","R","R","R","R","R","R","R"}
    };
    //String spacing = "";

    public Map(int width, int height, Entity[] entities, Plant[] plants) {
        this.mapWidth = width;
        this.mapHeight = height;
        this.tileMap = new Tile[height][width];
        this.stringMap = new String[height][width];
        this.entities = entities;
        this.plants = plants;

        generateTileMap();
    }

    private void generateTileMap() {// Luo mapin ton ison teksti arrayn mukaan (experimentMap), alkaa vasen-ylä kulmasta ja menee oikealle.
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                tileMap[y][x] = new Tile(experimentMap[y][x]);
            }
        }
    }
    void generateStringMap() {//Luo kartan jonka voi helposti printata
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

    private void printStringMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++){
                System.out.print(stringMap[y][x]);
            }
            System.out.print("\n");
        }
    }
}
