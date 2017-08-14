package com.creat.command;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class CloseCommand implements Command{
    private Document document;
    public CloseCommand(Document document){
        this.document = document;
    }
    public void execute() {
        document.close();
    }
}
