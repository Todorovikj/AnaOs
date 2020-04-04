public class TestReferencePrimitive {
    public static void main (String [] args){
        // COPIED VALUE EXAMLE
        int i = 0;
        TestingReferenceForInt test = new TestingReferenceForInt(i);
        i++;
        System.out.println("I in main:"+i);
        test.printJ();


        // VALUE BY REFERENCE EXAMPLE
        Name n = new Name();
        TestingReferenceForClass test1= new TestingReferenceForClass(n);
        n.addNobody();
        System.out.println("N in main:"+n.sentence);
        test1.printJ();
    }
}

// COPIED VALUE EXAMLE
class TestingReferenceForInt{
    int j;
    public TestingReferenceForInt(int i){
        this.j = i;
    }

    public void printJ(){
        System.out.println("J in TestingReferenceForInt:"+j);
    }
}


// VALUE BY REFERENCE EXAMPLE
class Name{
    public String sentence = "My Name is";

    public void addNobody(){
        this.sentence = this.sentence+" nobody";
    }
}
class TestingReferenceForClass {
    private Name j;
    public TestingReferenceForClass(Name i){
        this.j = i;
    }

    public void printJ(){
        System.out.println("J in TestingReferenceForClass:"+j.sentence);
    }
}
