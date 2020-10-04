package br.com.codingInterview.business.challenges;

// "static void main" must be defined in a public class.
public class BufferMain {
     static class Buffer {
        int size;
        int start;
        int end;
        char[] bf;
        int cap;
	public Buffer(int capacity) {
        bf= new char[capacity];
        size =0;
        start=0;
        end =0;
        cap = capacity;
	}

	/**
	* Transfers the content of the given source char array into this buffer.
	* Returns the the number of chars that were written into the buffer.
	*/
	public int write(char[] src) {
        if(src == null || src.length ==0|| size == cap)
            return 0;
        int i = 0;
        for(; i < src.length; i++){
            bf[end++] = src[i];
            size++;     
            end =end%cap;
            if(size >= cap)
                break;
        }
        return i;
	}

	public char[] read(int n) {
        int rl = n;
        if(n> size)
            rl = size;
        char[] res = new char[rl];
        for(int i = 0; i < rl; i++){
            res[i] = bf[start++];
            size--;
            start = start%cap;
        }
        return res;
	}
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Buffer t = new Buffer(5);
        char[] in = {'a','b','c'};
        t.write(in);
        char[] in2 = {'d','e','f'};
        t.write(in2);
        char[] out = t.read(3);
        System.out.println(out);
        char[] in3 = {'x','y','z','a','b','c'};
        t.write(in3);
        out = t.read(8);
        System.out.println(out);
    }
}