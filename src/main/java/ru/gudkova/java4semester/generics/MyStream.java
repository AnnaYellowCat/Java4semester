/*public class MyStrem<T> {
    private List<T> list = new ArrayList<>();
    private List<Object> action = new ArrayList<>();
    private MyStream(T..ts){
        for(T t: ts){
            list.add(t);
        }
    }
    public static<T> MyStream<T> of(T..ts){return new MyStream<>(ts);}
    
    public <P> MyStream<P> map(Function<T, P> method){
        action.add(method);
        return (MyStream<P>)this;
    }
    
    public MyStream<T> filter(Predicate<T> method){
        action.add(method);
        return this;
    }
    public T reduce(BinaryOperator<T> method, T init){
        up:for(T val: list){
            for(Object o: action){
                if(ob instanceof Predicate){
                    if(((Predicate)ob).test(val)) continue;
                    else continue up;
                }
                val =(T) ((Function)ob).apply(val);
            }
            init = oper.apply(init, val);
        }
        return init;
    }
    
}*/
