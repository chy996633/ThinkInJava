package design_mode.creational.builder;

/**
 * Created by Andrew on 2016/11/7.
 */
public class CountMazeBuilder extends MazeBuilder {

    int i;
    int j;
    int k;

    CountMazeBuilder(char[][] maze) {
        super(maze);
    }

    @Override
    public void buildTreasure(int i, int j) {
        this.i++;
    }

    @Override
    public void buildWall(int i, int j) {
        this.j++;
    }

    @Override
    public void buildRoom(int i, int j) {
        this.k++;
    }

    @Override
    public Maze getMaze() {
        return new Maze() {
            @Override
            public void paint() {
                System.out.println("当前迷宫物件：");
                System.out.println("宝藏："+i+"个");
                System.out.println("墙壁："+j+"面");
                System.out.println("房间："+k+"个");
            }
        };
    }
}
