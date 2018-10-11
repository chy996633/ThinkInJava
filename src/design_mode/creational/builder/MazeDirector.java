package design_mode.creational.builder;

/**
 * Created by Andrew on 2016/11/7.
 */
public class MazeDirector {

    char [][] maze;
    MazeBuilder builder;

    MazeDirector(char [][] maze, MazeBuilder builder){
        this.maze = maze;
        this.builder = builder;
    }

    public Maze construct(){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                switch (maze[i][j]){
                    case 0:
                        builder.buildWall(i,j);
                        break;
                    case 1:
                        builder.buildRoom(i, j);
                        break;
                    case 2:
                        builder.buildTreasure(i,j);
                        break;
                }
            }
        }
        return builder.getMaze();
    }


    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {0,1,0,1,0},
                {0,1,2,1,0},
                {0,1,0,1,0}
        };
        MazeDirector mazeDirector = new MazeDirector(maze,new PlainMazeBuilder(maze));
//        MazeDirector mazeDirector = new MazeDirector(maze,new CountMazeBuilder(maze));
        Maze maze1= mazeDirector.construct();
        maze1.paint();
    }

}
