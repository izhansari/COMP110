package comp110;

public class SampleRunner {

  public static void main(String[] args) {

    // TODO: Test Part 1.2 and 1.3
	  Sample Rec = new Sample("Test");
	  System.out.println(Rec);

    // TODO: Test Part 1.4 and 1.5
	  Rec.addAllele("AA");
	  Rec.addAllele("AA");
	  Rec.addAllele("AA");
	  Rec.addAllele("TT");
	  Rec.addAllele("TT");
	  Rec.addAllele("CC");
	  Rec.addAllele("GG");
	  System.out.println(Rec.getAlleles());

	  System.out.println(Rec.countAlleles());
	  System.out.println(Rec.filterAlleles(1));
	  System.out.println(Rec.filterAlleles(1));
	  
    // TODO: Test Part 1.6
	  
    // TODO: Test Part 1.7
  }

}
