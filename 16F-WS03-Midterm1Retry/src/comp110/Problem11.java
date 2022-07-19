package comp110;

public class Problem11 {

  public static void main(String[] args) {

    // !!!! DO YOUR WORK IN Courses.java !!!!
    
    Courses all = Utils.load("data.csv");

    Courses comp, psyc, econ, lvl100, hours3, hours4;
    comp = all.filter(new ByDept("COMP"));
    psyc = all.filter(new ByDept("PSYC"));
    econ = all.filter(new ByDept("ECON"));
    lvl100 = all.filter(new ByLevel(100));
    hours3 = all.filter(new ByHours(3));
    hours4 = all.filter(new ByHours(4));

    Courses a, b, c, d, e;
    a = comp.intersect(lvl100);
    b = psyc.union(econ);
    c = lvl100.subtract(a);
    d = psyc.union(comp).intersect(hours4);
    e = comp.subtract(lvl100);

    System.out.println("a:" + a);
    System.out.println("b:" + b);
    System.out.println("c:" + c);
    System.out.println("d:" + d);
    System.out.println("e:" + e);
    

  }

}
