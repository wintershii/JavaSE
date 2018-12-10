package nio;

import java.nio.ByteBuffer;

public class GetData {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        //Allocation automatically zeroes the ByteBuffer
        int i = 0;
        while (i++ < bb.limit()){
            if (bb.get() != 0)
                System.out.println("no zero");
        }
        System.out.println("i = " + i);
        bb.rewind();
        //store and read a char array
        bb.asCharBuffer().put("Hello");
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println("");
        bb.rewind();
        //store and read a short
        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());
        bb.rewind();
        //store and read an int
        bb.asIntBuffer().put(324324432);
        System.out.println(bb.getInt());
        bb.rewind();
        //store and read a long
        bb.asLongBuffer().put(999324342);
        System.out.println(bb.getLong());
        bb.rewind();
    }
}
