package design_mode.creational.builder;

/**
 * Created by Andrew on 2016/11/7.
 */
public abstract class MazeBuilder {

    char [][] maze;

    MazeBuilder(char [][] maze){this.maze = maze;}

    public void buildWall(int i, int j){}

    public void buildRoom(int i, int j){}

    public void buildTreasure(int i, int j){}

    public abstract Maze getMaze();

}
