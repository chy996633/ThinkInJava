package design_mode.command;

import java.util.ArrayList;

/**
 * Created by backstop-samuel on 7/4/17.
 */
public class Waiter {

    ArrayList<Command> commands = new ArrayList<>();

    public void addCommand(Command command){
        commands.add(command);
        System.out.println("增加命令:"+command.toString());
    }

    public void cancelCommand(Command command){
        commands.remove(command);
        System.out.println("取消命令:不"+command.toString());
    }

    public void notifyCommand(){
        commands.forEach(Command::execute);
    }


}
