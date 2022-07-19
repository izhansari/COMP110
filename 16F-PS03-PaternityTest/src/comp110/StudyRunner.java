package comp110;

public class StudyRunner {

  public static void main(String[] args) {

	  
    // TODO: Test Part 2.1 and 2.2
	  Sample subject = generateSampleA();
	  Study study = new Study (subject, 2);
	  
    // TODO: Test Part 2.3
	  System.out.println(study.getAncestorProbability(generateSampleB()));
	  System.out.println(study.getAncestorProbability(generateSampleC()));
	  
    // TODO: Test Part 2.4 and 2.5
	  study.addCandidate(generateSampleB());
	  study.addCandidate(generateSampleC());
	  System.out.println(study.getAncestors());
  }

  /*
   * The following methods are provided to you for testing purposes. Uncomment
   * them by selecting all of the commented lines, right clicking, finding the
   * "Source" menu and selecting "Toggle Comment."
   */
   public static Sample generateSampleA() {
   Sample sample = new Sample("Baby Doe");
   sample.addAllele("AA");
   sample.addAllele("AA");
   sample.addAllele("AA");
   sample.addAllele("AT");
   sample.addAllele("AT");
   sample.addAllele("TA");
   sample.addAllele("TC");
   sample.addAllele("TG");
   sample.addAllele("GT");
   sample.addAllele("TT");
  return sample;
   }
  //
   public static Sample generateSampleB() {
   Sample sample = new Sample("John Doe");
   sample.addAllele("GG");
   sample.addAllele("GG");
   sample.addAllele("GG");
   sample.addAllele("AT");
   sample.addAllele("AT");
   sample.addAllele("TA");
   sample.addAllele("TC");
   sample.addAllele("TG");
   sample.addAllele("GT");
   sample.addAllele("TT");
   return sample;
   }
  //
  public static Sample generateSampleC() {
   Sample sample = new Sample("John Smith");
   sample.addAllele("GG");
   sample.addAllele("GG");
   sample.addAllele("GG");
   sample.addAllele("AT");
   sample.addAllele("AG");
   sample.addAllele("TA");
   sample.addAllele("TC");
   sample.addAllele("TG");
   sample.addAllele("GT");
   sample.addAllele("TT");
   return sample;
   }

}
