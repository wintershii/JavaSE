package cn.pra_01.fanxing;

import java.util.Collection;

public class Test {
    class GrandF{

    }
    class Father extends GrandF{

    }
    class  Son extends Father{

    }
    class GrandS extends Son{

    }

    class TestSub {
        public void testSub(Collection<? super Father> para){
            //       para.add(new GrandF());
            para.add(new Father());
            para.add(new Son());
            para.add(new GrandS());
        }
    }
}
