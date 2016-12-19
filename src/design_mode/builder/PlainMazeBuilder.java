package design_mode.builder;

/**
 * Created by Andrew on 2016/11/7.
 */
public class PlainMazeBuilder extends MazeBuilder {

    PlainMazeBuilder(char[][] maze) {
        super(maze);
    }

    @Override
    public void buildRoom(int i, int j) {
        maze[i][j] = '|';
    }

    @Override
    public void buildWall(int i, int j) {
        maze[i][j] = '□';
    }

    @Override
    public void buildTreasure(int i, int j) {
        maze[i][j] = '※';
    }

    @Override
    public Maze getMaze() {
        return new Maze() {
            @Override
            public void paint() {
                for (char[] row : maze){
                    for (char ele : row){
                        System.out.print(ele);
                    }
                    System.out.println();
                }
            }
        };
    }


}
