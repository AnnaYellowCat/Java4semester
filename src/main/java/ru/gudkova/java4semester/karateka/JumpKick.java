package ru.gudkova.karateka;

import ru.gudkova.karateka.Karateka;
import ru.gudkova.karateka.Strike;

public class JumpKick implements Strike{
    public static final JumpKick jk = new JumpKick();
    private JumpKick(){}
    public static JumpKick createJumpKick(){
        return jk;
    }
    public void perform(Karateka kar){
        kar.jumpKick();
    }
}