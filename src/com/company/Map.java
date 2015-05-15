package com.company;

public class Map {
    int mapWidth, mapHeight;
    Entity[] entities;
    Tile[][] tileMap;
    String[][] stringMap;
    String spacing = "";

    public Map(int width, int height, Entity[] entities) {
        this.mapWidth = width;
        this.mapHeight = height;
        this.tileMap = new Tile[height][width];
        this.stringMap = new String[height][width];
        this.entities = entities;
    }

    void generateTileMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                    tileMap[y][x] = new Tile("Grass");
            }
        }
    }

    void generateStringMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                stringMap[y][x] = tileMap[y][x].printTile();
            }
        }

        for (Entity e : this.entities) {
            e.setBgColor(tileMap[e.returnPos().y][e.returnPos().x].tileColor);
            stringMap[e.returnPos().y][e.returnPos().x] = e.printEntity();
        }
        printStringMap();
    }
    /*
    void placeEntitiesInMap(Entity[] entities) {
        this.entities = entities;
        for (int i = 0; i < entities.length; i++){
            entities[i].setBgColor(tileMap[entities[i].returnPos().y][entities[i].returnPos().x].tileColor);
            entities[i].setBoundaries(new Position(mapWidth,mapHeight));
            stringMap[entities[i].returnPos().y][entities[i].returnPos().x] = entities[i].printEntity();
        }

    }
*/
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
