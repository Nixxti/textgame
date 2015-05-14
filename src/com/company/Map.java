package com.company;

public class Map {
    int mapWidth, mapHeight;
    Tile[][] tileMap;
    Entity[][] entityMap;
    String spacing = "";
    public Map(int width, int height) {
        this.mapWidth = width;
        this.mapHeight = height;
        this.tileMap = new Tile[height][width];
        this.entityMap = new Entity[height][width];
    }

    void generateTileMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                    tileMap[y][x] = new Tile("Grass", ' ');
            }
        }
    }


    // Maa palat ovat eri "kartalla" kuin esim. NPC:eet ja pelaaja
    void generateEntityMap(Object entities) {


    }

    void printTileMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++){
                System.out.print(tileMap[y][x].printTile() + spacing);
            }
            System.out.print("\n");
        }
        System.out.println(tileMap[3][4].info());
    }
}
