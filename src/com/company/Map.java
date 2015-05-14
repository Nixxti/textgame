package com.company;

public class Map {
    int mapWidth, mapHeight;
    Tile[][] map;

    String spacing = "  ";
    public Map(int width, int height) {
        mapWidth = width;
        mapHeight = height;
        map = new Tile[height][width];
    }
    void Generate() {
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++) {
                if (x%2 == 0) {
                    map[y][x] = new Tile("Grass", '@');
                } else {
                    map[y][x] = new Tile("Rock", '@');
                }
            }
        }
    }

    void ShowMap() {
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++){
                System.out.print(map[y][x].PrintTile() + spacing);
            }
            System.out.print("\n");
        }
        System.out.println(map[3][4].Info());
    }
}
