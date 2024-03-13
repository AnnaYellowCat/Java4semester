package ru.gudkova.numbers;
public enum Operations {
    PLUS{
        @Override
        public int make(int x, int y){
            return x+y;
        }
    },
    SUB{
        @Override
        public int make(int x, int y){
            return x-y;
        }
    },
    MULT{ 
        @Override
        public int make(int x, int y){
            return x*y;
        }
    },
    DIV{
        @Override
        public int make(int x, int y){
            return x/y;
        }
    };
    
    abstract public int make(int x, int y);
}
